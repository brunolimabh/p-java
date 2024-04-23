package org.example;

public class CaixaEletronico {

    private int quantidadeNotasQuinhentos;
    private int quantidadeNotasDuzentos;
    private int quantidadeNotasCem;
    private int quantidadeNotasCinquenta;
    private int quantidadeNotasVinte;
    private int quantidadeNotasDez;
    private int quantidadeNotasCinco;
    private int quantidadeNotasUm;

    private Double[] mediaLinha = new Double[8];
    private Double[] mediaColuna = new Double[3];
    private String[] cedulas = {"1 euro", "5 euros", "10 euros", "20 euros", "50 euros", "100 euros", "200 euros", "500 euros"};

    public int getQuantidadeNotasQuinhentos() {
        return quantidadeNotasQuinhentos;
    }

    public int getQuantidadeNotasDuzentos() {
        return quantidadeNotasDuzentos;
    }

    public int getQuantidadeNotasCem() {
        return quantidadeNotasCem;
    }

    public int getQuantidadeNotasCinquenta() {
        return quantidadeNotasCinquenta;
    }

    public int getQuantidadeNotasVinte() {
        return quantidadeNotasVinte;
    }

    public int getQuantidadeNotasDez() {
        return quantidadeNotasDez;
    }

    public int getQuantidadeNotasCinco() {
        return quantidadeNotasCinco;
    }

    public int getQuantidadeNotasUm() {
        return quantidadeNotasUm;
    }

    public void sacar(int valor) {
        if (valor < 0 || valor >= 5000) throw new IllegalArgumentException();
        if (valor >= 500) {
            quantidadeNotasQuinhentos++;
            valor -= 500;
            sacar(valor);
        } else if (valor >= 200) {
            quantidadeNotasDuzentos++;
            valor -= 200;
            sacar(valor);
        } else if (valor >= 100) {
            quantidadeNotasCem++;
            valor -= 100;
            sacar(valor);
        } else if (valor >= 50) {
            quantidadeNotasCinquenta++;
            valor -= 50;
            sacar(valor);
        } else if (valor >= 20) {
            quantidadeNotasVinte++;
            valor -= 20;
            sacar(valor);
        } else if (valor >= 10) {
            quantidadeNotasDez++;
            valor -= 10;
            sacar(valor);
        } else if (valor >= 5) {
            quantidadeNotasCinco++;
            valor -= 5;
            sacar(valor);
        } else if (valor >= 1) {
            quantidadeNotasUm++;
            valor -= 1;
            sacar(valor);
        }

    }

    /* Calcula a media das linhas e coloca as medias no vetor mediaLinha
       Calcula a media das colunas e coloca as medias no vetor mediaColuna
       Não esqueca de exibir na console o relatorio formatado conforme enunciado
    */
    public void exibeRelatorio(int[][] m) {
        mediaLinha[0] = 0.0;
        mediaLinha[1] = 0.0;
        mediaLinha[2] = 0.0;
        mediaLinha[3] = 0.0;
        mediaLinha[4] = 0.0;
        mediaLinha[5] = 0.0;
        mediaLinha[6] = 0.0;
        mediaLinha[7] = 0.0;
        for (int i = 0; i < 3; i++) {
            mediaLinha[0] += m[0][i];
            mediaLinha[1] += m[1][i];
            mediaLinha[2] += m[2][i];
            mediaLinha[3] += m[3][i];
            mediaLinha[4] += m[4][i];
            mediaLinha[5] += m[5][i];
            mediaLinha[6] += m[6][i];
            mediaLinha[7] += m[7][i];
        }
        mediaLinha[0] = mediaLinha[0] / 3;
        mediaLinha[1] = mediaLinha[1] / 3;
        mediaLinha[2] = mediaLinha[2] / 3;
        mediaLinha[3] = mediaLinha[3] / 3;
        mediaLinha[4] = mediaLinha[4] / 3;
        mediaLinha[5] = mediaLinha[5] / 3;
        mediaLinha[6] = mediaLinha[6] / 3;
        mediaLinha[7] = mediaLinha[7] / 3;

        mediaColuna[0] = 0.0;
        mediaColuna[1] = 0.0;
        mediaColuna[2] = 0.0;
        for (int i = 0; i < 8; i++) {
            mediaColuna[0] += m[i][0];
            mediaColuna[1] += m[i][1];
            mediaColuna[2] += m[i][2];

        }
        mediaColuna[0] = mediaColuna[0] / 8;
        mediaColuna[1] = mediaColuna[1] / 8;
        mediaColuna[2] = mediaColuna[2] / 8;


        System.out.printf("%-15S %6S %6S %6S %6S\n", "cédula", "abril", "maio", "junho", "media");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%-15s %6d %6d %6d %6.2f\n", cedulas[i], m[i][0], m[i][1], m[i][1], mediaLinha[i]);
        }
        System.out.printf("%-15s %6.2f %6.2f %6.2f\n \n", "média", mediaColuna[0], mediaColuna[1], mediaColuna[2]);
    }


    public Double[] getMediaLinha() {
        return mediaLinha;
    }
    public Double[] getMediaColuna() {
        return mediaColuna;
    }

}
