package org.example;
public class Banco {

    PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
    FilaObj<Operacao> filaOperacao = new FilaObj(10);
    Integer contadorOperacao = 0;

    public void debitar(Double valor, ContaBancaria conta) {
        if (conta.debitar(valor)) {
            Operacao operacao = new Operacao(
                    conta,
                    "Débito",
                    valor);
            pilhaOperacao.push(operacao);
            contadorOperacao++;
        }
    }

    public void creditar(Double valor, ContaBancaria conta) {
        conta.creditar(valor);
        Operacao operacao = new Operacao(
                conta,
                "Crédito",
                valor);
        pilhaOperacao.push(operacao);
        contadorOperacao++;
    }

    public void desfazerOperacao(Integer qtdOperacaoDesfeita) {
        if (qtdOperacaoDesfeita > pilhaOperacao.getTopo() + 1 || qtdOperacaoDesfeita <= 0) throw new IllegalArgumentException();
        for (int i = 0; i < qtdOperacaoDesfeita; i++) {
            Operacao operacao = pilhaOperacao.pop();

            if (operacao.getTipoOperacao().equalsIgnoreCase("Débito")){
                operacao.getContaBancaria().creditar(operacao.getValor());
            } else {
                operacao.getContaBancaria().debitar(operacao.getValor());
            }
            contadorOperacao--;
        }
    }

    public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
        if (!(tipoOperacao.equalsIgnoreCase("Débito")) && !(tipoOperacao.equalsIgnoreCase("Crédito"))) throw new IllegalArgumentException();
        if (valor == null || valor <= 0.0) throw new IllegalArgumentException();
        if (conta == null) throw new IllegalArgumentException();
        Operacao operacao = new Operacao(
                conta, tipoOperacao, valor);
        filaOperacao.insert(operacao);
    }

    public void executarOperacoesAgendadas() {
        if (filaOperacao.isEmpty()) {
            System.out.println("Não há operações agendadas");
        } else {
            int tam = filaOperacao.getTamanho();
            for (int i = 0; i < tam; i++) {
                System.out.println(filaOperacao);
                Operacao operacao = filaOperacao.poll();

                if (operacao.getTipoOperacao().equalsIgnoreCase("Débito")) {
                    operacao.getContaBancaria().debitar(operacao.getValor());
                } else {
                    operacao.getContaBancaria().creditar(operacao.getValor());
                }

            }
        }
    }

    public PilhaObj<Operacao> getPilhaOperacao() {
        return pilhaOperacao;
    }

    public FilaObj<Operacao> getFilaOperacao() {
        return filaOperacao;
    }

    public Integer getContadorOperacao() {
        return contadorOperacao;
    }
}
