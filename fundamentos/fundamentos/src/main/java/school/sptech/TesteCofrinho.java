package school.sptech;

public class TesteCofrinho {

    public static void main(String[] args) {

        Cofrinho cofre1 = new Cofrinho("Preistaxion 5");


        cofre1.situacaoCofrinho();

        cofre1.depositar(50.0);
        cofre1.situacaoCofrinho();

        cofre1.depositar(100.0);
        cofre1.situacaoCofrinho();

        Double dinheiroRemovido = cofre1.chacoalhar();
        System.out.println("Dinheiro removido: R$%.2f".formatted(dinheiroRemovido));

        cofre1.situacaoCofrinho();

        Double valorTotalRetirado = cofre1.quebrar();
        System.out.println("Quebrou, total removido: R$%.2f".formatted(valorTotalRetirado));

        cofre1.situacaoCofrinho();

        System.out.println(cofre1);

    }
}
