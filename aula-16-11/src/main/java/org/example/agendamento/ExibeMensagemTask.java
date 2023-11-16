package org.example.agendamento;

import java.util.TimerTask;

public class ExibeMensagemTask extends TimerTask {

    private String mensagem;
    private int delay;
    private int periodo;

    public ExibeMensagemTask(String mensagem, int delay, int periodo) {
        this.mensagem = mensagem;
        this.delay = delay;
        this.periodo = periodo;
    }

    @Override
    public void run() {
        System.out.println("Mensagem: %s".formatted(mensagem));
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
