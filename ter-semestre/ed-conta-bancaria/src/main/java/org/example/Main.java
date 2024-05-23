package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitorNumber = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);

        PilhaObj<Operacao> pilha = new PilhaObj<>(10);
        FilaObj<Operacao> fila = new FilaObj<>(10);

        ContaBancaria conta1 = new ContaBancaria(123, 10.0);
        ContaBancaria conta2 = new ContaBancaria(456, 5.0);
        ContaBancaria[] contas = {conta1, conta2};

        int opcao = 0;

        do {
            System.out.println("""
                    1 - Debitar valor
                    2 - Creditar (depositar) valor
                    3 - Desfazer operação
                    4 - Agendar operação
                    5 - Executar operações agendadas
                    6 - Sair
                    """);
            opcao = leitorNumber.nextInt();

            if (opcao == 1) {
                System.out.println("Digite o número da conta: ");
                int nmrConta = leitorNumber.nextInt();
                System.out.println("Digite valor a ser debitado: ");
                double valorDebitado = leitorNumber.nextDouble();

                for (ContaBancaria conta: contas) {
                    if (conta.getNumero() == nmrConta) {
                        if (conta.debitar(valorDebitado)) {
                            Operacao operacao = new Operacao(conta,
                                    "debito", valorDebitado);
                            pilha.push(operacao);
                        }
                    }
                }

            } else if (opcao == 2) {
                System.out.println("Digite o número da conta: ");
                int nmrConta = leitorNumber.nextInt();
                System.out.println("Digite valor a ser creditado: ");
                double valorDebitado = leitorNumber.nextDouble();

                for (ContaBancaria conta: contas) {
                    if (conta.getNumero() == nmrConta) {
                        conta.creditar(valorDebitado);
                        Operacao operacao = new Operacao(conta,
                                "credito", valorDebitado);
                        pilha.push(operacao);
                    }
                }

            } else if (opcao == 3) {
                System.out.println("Qtd operações: ");
                int qtd = leitorNumber.nextInt();

                if (qtd > pilha.getTopo() + 1) {
                    System.out.println("Quantidade inválida");
                } else {
                    for (int i = 0; i < qtd; i++) {
                        Operacao operacao = pilha.pop();

                        if (operacao.getTipoOperacao().equalsIgnoreCase("debito")){
                            operacao.getObjConta().creditar(operacao.getValor());
                        } else {
                            operacao.getObjConta().debitar(operacao.getValor());
                        }
                    }
                }

            } else if (opcao == 4) {
                System.out.println("Qual o tipo de operação: ");
                String tipo = leitorString.nextLine();
                System.out.println("Digite o número da conta: ");
                int nmrConta = leitorNumber.nextInt();
                System.out.println("Digite o valor: ");
                double valorDebitado = leitorNumber.nextDouble();

                Operacao operacao = new Operacao(conta1, tipo, valorDebitado);

                fila.insert(operacao);

            } else if (opcao == 5) {
                if (fila.isEmpty()) {
                    System.out.println("Não há operações agendadas");
                } else {
                    int tam = fila.getTamamho();
                    for (int i = 0; i < tam; i++) {
                        Operacao operacao = fila.poll();

                        if (operacao.getTipoOperacao().equalsIgnoreCase("debito")) {
                            operacao.getObjConta().debitar(operacao.getValor());
                        } else {
                            operacao.getObjConta().creditar(operacao.getValor());
                        }

                    }
                }

            } else if (opcao == 6) {
                System.out.println("Até a próxima");

            } else {
                System.out.println("Digite uma opção válida");

            }


        } while (opcao != 6);
    }

}