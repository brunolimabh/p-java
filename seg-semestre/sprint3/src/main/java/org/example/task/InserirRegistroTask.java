package org.example.task;

import org.example.database.BancoMySQLLocal;
import org.example.database.BancoSQLServer;
import org.example.database.Conectavel;
import org.example.model.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InserirRegistroTask extends TimerTask {

    private int delay;
    private int periodo;
    private int fkTotem;
    private LocalDateTime dateTimeNow;
    private List<TotemComponente> totemComponentes;
    private List<Componente> componentes;
    private Conectavel bancoLocal;
    private Conectavel bancoServidor;

    public InserirRegistroTask(int delay, int periodo, int fkTotem, List<TotemComponente> totemComponentes) {
        this.delay = delay;
        this.periodo = periodo;
        this.fkTotem = fkTotem;
        this.totemComponentes = totemComponentes;
        this.componentes = new ArrayList<>();
        this.bancoLocal = new BancoMySQLLocal();
        this.bancoServidor = new BancoSQLServer();
    }

    @Override
    public void run() {
        dateTimeNow = LocalDateTime.now();

        ZoneId virginiaTimeZone = ZoneId.of("America/New_York");
        LocalDateTime horaVirginia = LocalDateTime.now(virginiaTimeZone);
        ZoneId brtTimeZone = ZoneId.of("America/Sao_Paulo");
        LocalDateTime horaBRT = horaVirginia.atZone(virginiaTimeZone).withZoneSameInstant(brtTimeZone).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String stringHoraBRT = horaBRT.format(formatter);

        LocalDateTime dataHora = LocalDateTime.parse(stringHoraBRT, formatter);

        System.out.println("""
                ------------------------
                Data: %s""".formatted(stringHoraBRT));
        for (int i = 0; i < totemComponentes.size(); i++) {

            TipoComponente componenteEncontrado = TipoComponente.of(totemComponentes.get(i).getFkComponente());

            if (componenteEncontrado.getDescricao().equalsIgnoreCase("cpu")){
                Processador processador = new Processador(1,"CPU","%");
                System.out.println("%s: %.2f%%"
                        .formatted(processador.getNome(), processador.porcentagemUso()));

                bancoLocal.insertRegistro(processador.porcentagemUso(), dataHora,1,fkTotem);
//                bancoServidor.insertRegistro(processador.porcentagemUso(), dataHora,1,fkTotem);

            } else if (componenteEncontrado.getDescricao().equalsIgnoreCase("memoria")){
                Memoria memoria = new Memoria(2,"Memoria","%");
                System.out.println("%s: %.2f%%"
                        .formatted(memoria.getNome(), memoria.porcentagemUso()));

                bancoLocal.insertRegistro(memoria.porcentagemUso(), dataHora,2,fkTotem);
//                bancoServidor.insertRegistro(memoria.porcentagemUso(), dataHora,2,fkTotem);

            } else if (componenteEncontrado.getDescricao().equalsIgnoreCase("disco")){
                Disco disco = new Disco(2,"Disco","%");
                System.out.println("%s: %.2f%%"
                        .formatted(disco.getNome(), disco.porcentagemUso()));

                bancoLocal.insertRegistro(disco.porcentagemUso(), dataHora,3,fkTotem);
//                bancoServidor.insertRegistro(disco.porcentagemUso(), dataHora,3,fkTotem);

            }
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
