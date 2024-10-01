package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Musica> lista = new ArrayList<>();

        lista.add(new Musica(1, "teste1","teste1", "01:11","teste1", 1.1, "teste1"));
        lista.add(new Musica(2, "teste2","teste2", "02:22","teste2", 2.2, "teste2"));
        lista.add(new Musica(3, "teste3","teste3", "03:33","teste3", 3.4, "teste3"));
        lista.add(new Musica(4, "teste4","teste4", "04:44","teste4", 4.4, "teste4"));
        lista.add(new Musica(5, "teste5","teste5", "05:55","teste5", 5.6, "teste5"));

        System.out.println("Lista original das musicas: ");
        for (Musica a: lista) {
            System.out.println(a);
        }

//        gravaArquivoTxt(lista, "musicas.txt");
        leArquivoTxt("musicas.txt");
    }

    public static void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;


        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }
    }

    public static void gravaArquivoTxt(List<Musica> lista, String nomeArq) {
        int contaRegDados = 0;

        if (lista.isEmpty()) {
            System.out.println("Lista vazia. Não há nada a gravar!");
        } else {

            String header = "00MUSICAS";
            header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            header += "01";
            gravaRegistro(nomeArq, header);

            String corpo;
            for (Musica a: lista) {
                corpo = "02";
                corpo += String.format("%04d", a.getId());
                corpo += String.format("%-20.20S", a.getNome());
                corpo += String.format("%-20.20S", a.getArtista());
                corpo += String.format("%5.5S", a.getDuracao());
                corpo += String.format("%-20.20S", a.getAlbum());
                corpo += String.format("%05.2f", a.getNota());
                corpo += String.format("%-10.10S", a.getGenero());

                gravaRegistro(nomeArq, corpo);
                contaRegDados++;
            }

            String trailer = "01";
            trailer +=  String.format("%010d", contaRegDados);
            gravaRegistro(nomeArq, trailer);

            System.out.println("Gravação efetuada com sucesso");
        }
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        Integer id;
        String nome, artista, duracao, album, genero;
        Double nota;
        int contaRegDados = 0;
        int qtdRegGravados;

        List<Musica> listaLida = new ArrayList<>();

        try {
            entrada = new BufferedReader((new FileReader(nomeArq)));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0,2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2,9));
                    System.out.println("Data e hora da gravação do arquivo: " + registro.substring(9,28));
                    System.out.println("Versão do documento de layout: " + registro.substring(28,29));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegGravados = Integer.parseInt(registro.substring(2,12));
                    if (contaRegDados == qtdRegGravados) {
                        System.out.println("Qtd. de reg. campatível com qtd. de reg. de dados lidos");
                    } else {
                        System.out.println("Qtd. de reg. incampatível com qtd. de reg. de dados lidos");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de dados");

                    id = Integer.parseInt(registro.substring(2,6));
                    nome = registro.substring(6,26).trim();
                    artista = registro.substring(26,46).trim();
                    duracao = registro.substring(46,51);
                    album = registro.substring(51,71).trim();
                    nota = Double.valueOf(registro.substring(71,76).replace(',', '.'));
                    genero = registro.substring(76,86).trim();

                    Musica a = new Musica(id, nome, artista, duracao, album, nota, genero);
                    listaLida.add(a);
                } else {
                    System.out.println("Registro inválido");
                }

                registro = entrada.readLine();
            }
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: ");
            erro.printStackTrace();
        }

        System.out.println("\n Lista lida das musicas: ");
        for (Musica a: listaLida) {
            System.out.println(a);
        }
    }

}