package org.example;

public class Main {
    public static void main(String[] args) {
        String[] funcionarios = {
                "Bruno",
                "Paulo",
                "Caio",
                "Joao",
                "Danilo",
                "Lucas"};

        double[][] salarios = {
                {13.2,10.3},
                {10.31,8.65},
                {8.43,9.81},
                {12.43,13.24},
                {10.46,10.76},
                {10.61,12.49}
        };

        double[] media = new double[6];
        double mediaJaneiro = 0;
        double mediaFevereiro = 0;


        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0){
                    mediaJaneiro += salarios[i][j];
                } else {
                    mediaFevereiro += salarios[i][j];
                }
            }
            media[i] = (salarios[i][0] + salarios[i][1]) / 2;
        }

        mediaJaneiro = mediaJaneiro / 6;
        mediaFevereiro = mediaFevereiro / 6;

        System.out.printf("%-15S %10S %10S %6S\n", "nome", "janeiro", "fevereiro", "media");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%-15s %10.2f %10.2f %6.2f\n", funcionarios[i], salarios[i][0], salarios[i][1], media[i]);
        }
        System.out.printf("%-15S %10.2f %10.2f\n \n", "média do mês", mediaJaneiro, mediaFevereiro);
    }
}