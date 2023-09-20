package org.example;

import org.example.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class CriacaoBanco {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoBanco();

        con.execute("DROP TABLE IF EXISTS livros");

        con.execute("""
                CREATE TABLE livros (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nome VARCHAR(255),
                    preco DECIMAL(8,2)
                )
                """);

        con.update("INSERT INTO livros (nome,preco) VALUES ('bigbig', 59.9)");



    }
}
