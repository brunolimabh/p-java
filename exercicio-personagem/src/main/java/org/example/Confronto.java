package org.example;

public class Confronto {
    public void lutar(Heroi heroi, Vilao vilao){
        if (heroi.getForcaTotal() > vilao.getForcaTotal()){
            System.out.println("Heroi vencedor");
        } else if (heroi.getForcaTotal() == vilao.getForcaTotal()) {
            System.out.println("Empate");
        } else if (heroi.getForcaTotal() < vilao.getForcaTotal()){
            System.out.println("Vilão vencedor");
        }
    }
}
