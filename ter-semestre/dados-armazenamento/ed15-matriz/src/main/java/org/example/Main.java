package org.example;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int escolha = 0;
        do {
            System.out.println("""
                    \n
                    0 - Sair
                    1 - EX 1
                    2 - EX 2
                    3 - EX 3
                    4 - EX 4
                    5 - EX 5
                    6 - EX 6
                    """);
            escolha = leitor.nextInt();

            if (escolha == 1){
                int[][] matriz = new int[2][3];

                for (int linha = 0; linha < matriz.length; linha++) {
                    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                        System.out.printf("Digite o valor de matriz[%d][%d]: \n", linha, coluna);
                        matriz[linha][coluna] = leitor.nextInt();
                    }
                }

                for (int linha = 0; linha < matriz.length; linha++) {
                    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                        System.out.print(matriz[linha][coluna] + "\t");
                    }
                    System.out.println();
                }

            } else if (escolha == 2) {
                int[][] matriz1 = new int[2][3];
                int[][] matriz2 = new int[2][3];
                int[][] matriz3 = new int[2][3];

                System.out.println("MATRIZ 1");
                for (int linha = 0; linha < matriz1.length; linha++) {
                    for (int coluna = 0; coluna < matriz1[linha].length; coluna++) {
                        System.out.printf("Digite o valor de matriz1[%d][%d]: \n", linha, coluna);
                        matriz1[linha][coluna] = leitor.nextInt();
                    }
                }
                System.out.println("MATRIZ 2");
                for (int linha = 0; linha < matriz2.length; linha++) {
                    for (int coluna = 0; coluna < matriz2[linha].length; coluna++) {
                        System.out.printf("Digite o valor de matriz2[%d][%d]: \n", linha, coluna);
                        matriz2[linha][coluna] = leitor.nextInt();
                    }
                }

                for (int linha = 0; linha < matriz3.length; linha++) {
                    for (int coluna = 0; coluna < matriz3[linha].length; coluna++) {
                        matriz3[linha][coluna] = matriz1[linha][coluna] + matriz2[linha][coluna];
                    }
                }

                System.out.println("MATRIZ 1");
                for (int linha = 0; linha < matriz1.length; linha++) {
                    for (int coluna = 0; coluna < matriz1[linha].length; coluna++) {
                        System.out.print(matriz1[linha][coluna] + "\t");
                    }
                    System.out.println();
                }
                System.out.println("MATRIZ 2");
                for (int linha = 0; linha < matriz2.length; linha++) {
                    for (int coluna = 0; coluna < matriz2[linha].length; coluna++) {
                        System.out.print(matriz2[linha][coluna] + "\t");
                    }
                    System.out.println();
                }
                System.out.println("MATRIZ 3");
                for (int linha = 0; linha < matriz3.length; linha++) {
                    for (int coluna = 0; coluna < matriz3[linha].length; coluna++) {
                        System.out.print(matriz3[linha][coluna] + "\t");
                    }
                    System.out.println();
                }

            } else if (escolha == 3) {
                int[][] matriz = new int[3][3];
                int[] vetor = new int[3];

                for (int linha = 0; linha < matriz.length; linha++) {
                    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                        System.out.printf("Digite o valor de matriz[%d][%d]: \n", linha, coluna);
                        matriz[linha][coluna] = leitor.nextInt();
                    }
                }

                for (int linha = 0; linha < matriz.length; linha++) {
                    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                        vetor[coluna]+=matriz[linha][coluna];
                    }
                }

                for (int linha = 0; linha < matriz.length; linha++) {
                    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                        System.out.print(matriz[linha][coluna] + "\t");
                    }
                    System.out.println();
                }
                System.out.println(Arrays.toString(vetor));

            } else if (escolha == 4) {
                int numero = 0;
                int diagonal1 = 0;
                int diagonal2 = 0;

                do {
                    System.out.println("Digite um numero maior que 1 e menor que 6: ");
                    numero = leitor.nextInt();
                } while (numero <= 1 || numero >= 6);

                int[][] matriz = new int[numero][numero];

                for (int linha = 0; linha < matriz.length; linha++) {
                    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                        System.out.printf("Digite o valor de matriz[%d][%d]: \n", linha, coluna);
                        matriz[linha][coluna] = leitor.nextInt();
                    }
                }

                for (int i = 0; i < numero; i++) {
                    diagonal1 += matriz[i][i];
                }
                int j = numero - 1;
                for (int i = 0; i < numero; i++) {
                    diagonal2 += matriz[i][j];
                    j = j - 1;
                }

                System.out.println("Diagonal principal: " + diagonal1);
                System.out.println("Diagonal secundaria: " + diagonal2);

            } else if (escolha == 5) {
                int nMatriz = 0;
                System.out.println("Digite o tamanho da matriz:");
                nMatriz = leitor.nextInt();

                int[][] matriz = new int[nMatriz][nMatriz];
                int[] vetorSoma = new int[nMatriz];
                boolean isMagico = true;

                for (int linha = 0; linha < matriz.length; linha++) {
                    for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                        System.out.printf("Digite o valor de matriz[%d][%d]: \n", linha, coluna);
                        matriz[linha][coluna] = leitor.nextInt();
                        vetorSoma[linha] += matriz[linha][coluna];
                    }
                }

                for (int i = 0; i < nMatriz; i++) {
                    if (vetorSoma[0] != vetorSoma[i]){
                        isMagico = false;
                    }
                }
                System.out.println(Arrays.toString(vetorSoma));
                if (isMagico){
                    System.out.println("A matriz é um quadrado mágico");
                } else {
                    System.out.println("A matriz NÃO é um quadrado mágico");
                }

            }  else if (escolha == 6) {
                Scanner leitorNomes = new Scanner(System.in);
                int maxAlunos = 0;

                do {
                    System.out.println("Digite o maxAlunos ( >= 5 e <= 15");
                    maxAlunos = leitor.nextInt();
                } while (maxAlunos < 5 || maxAlunos> 15);

                String[] alunos = new String[maxAlunos];
                double[][] notas = new double[maxAlunos][2];
                double[] media = new double[maxAlunos];
                double mediaAc1 = 0;
                double mediaAc2 = 0;

                for (int i = 0; i < maxAlunos; i++) {
                    System.out.printf("Digite o nome do aluno %d : \n", i+1);
                    alunos[i] = leitorNomes.nextLine();
                }

                for (int i = 0; i < maxAlunos; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.printf("Digite a nota ac%d nome do aluno %s : \n", j+1, alunos[i]);
                        notas[i][j] = leitor.nextDouble();
                        if (j == 0){
                            mediaAc1 += notas[i][j];
                        } else {
                            mediaAc2 += notas[i][j];
                        }
                    }
                    media[i] = (notas[i][0] + notas[i][1]) / 2;
                }

                mediaAc1 = mediaAc1 / maxAlunos;
                mediaAc2 = mediaAc2 / maxAlunos;

                System.out.printf("%-15S %6S %6S %6S\n", "nome", "ac1", "ac2", "media");
                for (int i = 0; i < maxAlunos; i++) {
                    System.out.printf("%-15s %6.2f %6.2f %6.2f\n", alunos[i], notas[i][0], notas[i][1], media[i]);
                }
                System.out.printf("%-15S %6.2f %6.2f\n \n", "média da ac", mediaAc1, mediaAc2);
            }

        } while (escolha != 0);
    }


}