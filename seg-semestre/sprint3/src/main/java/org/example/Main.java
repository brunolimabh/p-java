package org.example;

import org.example.task.InserirRegistroTask;
import org.example.database.BancoMySQLLocal;
import org.example.database.BancoSQLServer;
import org.example.database.Conectavel;
import org.example.dao.FuncionarioRowMapper;
import org.example.model.Totem;
import org.example.dao.TotemRowMapper;
import org.example.model.TotemComponente;
import org.example.dao.TotemComponenteRowMapper;
//import com.github.britooo.looca.api.group.servicos.Servico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {

        LocalDateTime dataHora = LocalDateTime.now();
        Conectavel sqlServer = new BancoSQLServer();
        Conectavel mySql = new BancoMySQLLocal();
        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        Integer escolha = 0;
        Integer fkEmpresa = 0;


        do {
            System.out.println("0 - Sair");
            System.out.println("1 - Acessar Sistema");
            escolha = inputNumber.nextInt();

            try {


                if (escolha == 1) {
                    System.out.println("Insira seu email de acesso:");
                    String email = inputString.nextLine();
                    System.out.println("Insira sua senha:");
                    String senha = inputString.nextLine();

                    List<Integer> count = mySql.Conexao().queryForList("SELECT COUNT(idFuncionario) FROM Funcionario WHERE email = ? AND senha = ?",
                            Integer.class,
                            email, senha);

                    if (count.get(0) == 1) {
                        mySql.Conexao().query("SELECT idFuncionario, email, senha, nome, fkEmpresa FROM Funcionario WHERE email = ? AND senha = ?",
                                new FuncionarioRowMapper(),
                                email, senha);


                        System.out.println("Bem-vindo ao sistema de monitoramento da AIRWAY!");

                        do {
                            System.out.println("Informe o nome destá máquina (cadastrado no nosso site)");
                            System.out.println("0 - Voltar");
                            /*System.out.println("1 - Cadastrar Máquina");*/
                            List<Totem> totens = mySql.Conexao().query("SELECT * FROM Totem WHERE idTotem NOT IN (SELECT fkTotem FROM Registro group by fkTotem)"
                                    , new TotemRowMapper());
                            for (int i = 0; i < totens.size(); i++) {
                                System.out.println("%d - %s".formatted(i + 2, totens.get(i).getNome()));
                            }

                            escolha = inputNumber.nextInt();

                            /*if (escolha == 1) {
                                System.out.println("Qual o nome da máquina?");
                                String nome = inputString.nextLine();
                                System.out.println("Qual é o estado do ");

                            } else*/ if (escolha >= 2 && escolha <= totens.size() + 2) {
                                Totem totemAtual = totens.get(escolha - 2);

                                do {
                                    System.out.println("Deseja começar o monitoramento?");
                                    System.out.println("0 - Não, voltar!");
                                    System.out.println("1 - Não, ajustar métricas!");
                                    System.out.println("2 - Sim, entre 5-20 segundos!");
                                    escolha = inputNumber.nextInt();

                                    if (escolha == 1){

                                    } else if (escolha == 2){
                                        List<TotemComponente> totemComponentes= mySql.Conexao().query("SELECT * FROM TotemComponente WHERE fkTotem = ?",
                                                new TotemComponenteRowMapper(),
                                                totemAtual.getIdTotem());

                                        Timer agendador = new Timer();
                                        InserirRegistroTask task = new InserirRegistroTask(1000,1000,totemAtual.getIdTotem(),totemComponentes);
                                        agendador.schedule(task, task.getDelay(), task.getPeriodo());

                                        inputString.nextLine();
                                        agendador.cancel();

                                        System.out.println("Monitoramento encerrado!");

                                    }

                                } while (escolha != 0);

                            } else {
                                System.out.println("Escolha ou cadastre um totem válido!");
                            }


                        } while (escolha != 0);


                    } else {
                        System.out.println("Conta não cadastrada, tente novamente!");
                    }

                    // escolha para repetir o loop
                    escolha = 999;

                } else if (escolha == 0){
                    System.out.println("Até logo!");
                } else {
                    System.out.println("Não entendi, tente outra vez!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite somente números");
            }

        } while (escolha != 0);
    }
}

