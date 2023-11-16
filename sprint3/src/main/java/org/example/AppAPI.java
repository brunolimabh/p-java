package org.example;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AppAPI {
    public static void main(String[] args) {

        LocalDateTime dataHora = LocalDateTime.now();
        JdbcTemplate con = new BancoMySQLLocal().Conexao();
        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        Integer escolha = 0;
        Integer fkEmpresa = 0;

        do {
            System.out.println("0 - Sair");
            System.out.println("1 - Acessar Sistema");
            escolha = inputNumber.nextInt();

            if (escolha == 1){
                System.out.println("Insira seu email de acesso:");
                String email = inputString.nextLine();
                System.out.println("Insira sua senha:");
                String senha = inputString.nextLine();

                List<Integer> count = con.query("SELECT COUNT(idFuncionario) FROM Funcionario WHERE email = '%s' AND senha = %s"
                                .formatted(email,senha)
                        ,new BeanPropertyRowMapper<Integer>());

                System.out.println(count);


                if (count.get(0) == 1){
                    con.query("SELECT * FROM Funcionario WHERE email = '%s' AND senha = %s"
                                    .formatted(email,senha)
                            ,new BeanPropertyRowMapper<Funcionario>());
                } else {
                    System.out.println("Conta não cadastrada, tente novamente!");
                }
            } else if (escolha == 0){
                System.out.println("Até logo!");
            } else {
                System.out.println("Não entendi, tente outra vez!");
            }
        } while (escolha == 0);

        System.out.println("Bem-vindo ao sistema de monitoramento da AIRWAY!");
        do {
            System.out.println("Informe o nome destá máquina (cadastrado no sistema");
            System.out.println("1 - Cadastrar Máquina");
            con.query("SELECT * FROM Totem WHERE idTotem NOT IN (SELECT fkTotem FROM registro group by fkTotem)"
                    , new BeanPropertyRowMapper<Totem>());
            escolha = inputNumber.nextInt();

            if (escolha == 0){
                System.out.println("Até logo!");
            } else if (escolha == 1){
                System.out.println("Qual o nome da máquina?");
                String nome = inputString.nextLine();
                System.out.println("Qual é o estado do ");

            }
        } while (escolha != 0);

    }
}
