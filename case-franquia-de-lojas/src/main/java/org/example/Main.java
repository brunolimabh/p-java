package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        JdbcTemplate con = new Conexao().getConexao();

        Eletronico e1 = new Eletronico(null,"Gameboy",5700.0,110,
                0.1,"Nointendo");
        Vestuario v1 = new Vestuario(null,"Camiseta Confortavel",35.0,
                "M","azul",true);

        con.execute("DROP TABLE IF EXISTS produto");
        con.execute("""
                CREATE TABLE produto (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nome VARCHAR(50) NOT NULL,
                    precoBase DECIMAL(10,2) NOT NULL,
                    tipo VARCHAR(50) NOT NULL,
                    tensao INT,
                    peso DECIMAL(10,2),
                    fabricante VARCHAR(50),
                    tamanho VARCHAR(5),
                    cor VARCHAR(50),
                    whiteLabel BOOLEAN
                );
                """);

        //TODO: MELHORAR AQUI!!!
        con.update("INSERT INTO produto(nome,precoBase,tipo,tensao,peso,fabricante) " +
                "VALUES(?,?,'ELETRONICO',?,?,?)",
                e1.getNome(),e1.getPrecoBase(),e1.getTensao(),e1.getPeso(),e1.getFabricante());

        con.update("INSERT INTO produto(nome,precoBase,tipo,tamanho,cor,whiteLabel) " +
                        "VALUES(?,?,'VESTUARIO',?,?,?)",
                v1.getNome(),v1.getPrecoBase(),v1.getTamanho(),v1.getCor(),v1.getWhiteLabel());

        List<Produto> produtos =
                con.query("SELECT * FROM produto", new ProdutoRowMapper());

        System.out.println(produtos);
    }
}