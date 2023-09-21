package org.example;

public class Main {
    public static void main(String[] args) {

        Grupo grupoFamilia = new Grupo("Familia Adams");

        Contato contato1 = new Contato("Manoel","(11)91111-2222");
        Contato contato2 = new Contato("Paulo","(11)92222-3333");
        Contato contato3 = new Contato("Breno","(11)93333-4444");

        grupoFamilia.adiciona(contato1);
        grupoFamilia.adiciona(contato2);
        grupoFamilia.adiciona(contato3);

        Contato resultado = grupoFamilia.buscarPorContato("(11)93333-4444");
        System.out.println(resultado);

    }
}