package org.example;

public class Main {
    public static void main(String[] args) {
        Musica m1 = new Musica(1, "teste1","teste1", 2.1,"teste1");
        Musica m2 = new Musica(2, "teste2","teste2", 2.2,"teste2");
        Musica m3 = new Musica(3, "teste3","teste3", 2.3,"teste3");
        Musica m4 = new Musica(4, "teste4","teste4", 2.4,"teste4");
        Musica m5 = new Musica(5, "teste5","teste5", 2.5,"teste5");
        Repositorio repo = new Repositorio();
        repo.salvar(m1);
        repo.salvar(m2);
        repo.salvar(m3);
        repo.salvar(m4);
        repo.salvar(m5);
        repo.deletarPeloId(2);
        repo.exibe();
        System.out.println("Desfazendo deletar");
        repo.desfazerDeletar();
        System.out.println("Exibindo");
        repo.exibe();
        repo.agendarSalvar(m1);
        repo.agendarSalvar(m2);
        System.out.println("Executar agendamento");
        repo.executarAgendado();
        repo.exibe();
    }


}