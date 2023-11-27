package org.example.agendamento;

import org.example.banco.BancoMySQLLocal;
import org.example.banco.BancoSQLServer;
import org.example.banco.Conectavel;
import org.example.componente.Componente;
import org.example.componente.Disco;
import org.example.componente.Memoria;
import org.example.componente.Processador;
import org.example.totemcomponente.TotemComponente;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class InserirRegistroTask extends TimerTask {

    private int delay;
    private int periodo;
    private int fkTotem;
    private LocalDateTime dataHora;
    private List<TotemComponente> totemComponentes;
    private List<Componente> componentes;
    private Conectavel bancoLocal;
    private Conectavel bancoServidor;

    public InserirRegistroTask(int delay, int periodo, int fkTotem, List<TotemComponente> totemComponentes) {
        this.delay = delay;
        this.periodo = periodo;
        this.fkTotem = fkTotem;
        this.dataHora = LocalDateTime.now();
        this.totemComponentes = totemComponentes;
        this.componentes = new ArrayList<>();
        this.bancoLocal = new BancoMySQLLocal();
        this.bancoServidor = new BancoSQLServer();
    }

    @Override
    public void run() {
        System.out.println("""
                ------------------------
                Data: %s""".formatted(dataHora));
        for (int i = 0; i < totemComponentes.size(); i++) {
            if (totemComponentes.get(i).getNome().equals("Processador")){
                Processador processador = new Processador(1,"Processador","%");
                System.out.println("%s: %.2f%%"
                        .formatted(processador.getNome(), processador.porcentagemUso()));

                bancoLocal.insertRegistro(processador.porcentagemUso(), dataHora,1,fkTotem);
                bancoServidor.insertRegistro(processador.porcentagemUso(), dataHora,1,fkTotem);

            } else if (totemComponentes.get(i).getNome().equals("Memoria")){
                Memoria memoria = new Memoria(2,"Memoria","%");
                System.out.println("%s: %.2f%%"
                        .formatted(memoria.getNome(), memoria.porcentagemUso()));

                bancoLocal.insertRegistro(memoria.porcentagemUso(), dataHora,2,fkTotem);
                bancoServidor.insertRegistro(memoria.porcentagemUso(), dataHora,2,fkTotem);

            } /*else if (totemComponentes.get(i).getNome().equals("Disco")){
                Disco disco = new Disco(2,"Disco","%");
                System.out.println("%s: %.2f%%"
                        .formatted(disco.getNome(), disco.porcentagemUso()));

                bancoLocal.insertRegistro(disco.porcentagemUso(), dataHora,3,fkComponente);
                bancoServidor.insertRegistro(disco.porcentagemUso(), dataHora,3,fkComponente);

            }*/
        }
        System.out.println("------------------------");
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
