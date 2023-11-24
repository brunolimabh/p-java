package org.example.agendamento;

import org.example.componente.Componente;
import org.example.totemcomponente.TotemComponente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class InserirRegistroTask extends TimerTask {

    private String mensagem;
    private int delay;
    private int periodo;
    private LocalDateTime dataHora;
    private List<TotemComponente> totemComponentes;
    private List<Componente> componentes;

    public InserirRegistroTask(String mensagem, int delay, int periodo, LocalDateTime dataHora, List<TotemComponente> totemComponentes) {
        this.mensagem = mensagem;
        this.delay = delay;
        this.periodo = periodo;
        this.dataHora = dataHora;
        this.totemComponentes = totemComponentes;
        this.componentes = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < totemComponentes.size(); i++) {

        }
        System.out.println("""
                ------------------------
                %s: %.2f%%
                ------------------------
                """);

    }
}
