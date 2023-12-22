package org.example.agendamento;

import java.util.Scanner;
import java.util.Timer;

public class Agendamento {
    public static void main(String[] args) {

        // Agendador de tarefas
        Timer agendador = new Timer();

        // TimerTask
//        TimerTask tarefa1 = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Olá Mundo");
//            }
//        };

        Scanner in = new Scanner(System.in);

        System.out.println("Mensagem para rotina:");
        String msgExibir = in.nextLine();

        System.out.println("Para sair pressione qualquer tecla");

        ExibeMensagemTask tarefa1 = new ExibeMensagemTask(msgExibir,1000,5000);

        ExibeMensagemTask tarefa2 = new ExibeMensagemTask("Teste 2",5000,2000);

        agendador.schedule(tarefa1, tarefa1.getDelay(), tarefa1.getPeriodo());

        agendador.schedule(tarefa2,tarefa2.getDelay(), tarefa2.getPeriodo());

        in.nextLine();
        agendador.cancel();

    }
}