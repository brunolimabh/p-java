package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoBanco();

        con.execute("DROP TABLE IF EXISTS filme");

        con.execute("""
                CREATE TABLE filme (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nome VARCHAR(255),
                    anoLancamento INT
                )
                """);

        con.update("INSERT INTO filme (nome,anoLancamento) VALUES ('Avatar 2',2023)");
        con.update("INSERT INTO filme (nome,anoLancamento) VALUES ('Matrix',1999)");
        con.update("INSERT INTO filme (nome,anoLancamento) VALUES ('Interestelar',2012)");

        List<Filme> xxxxxx = con.query("SELECT * FROM filme", new BeanPropertyRowMapper<>(Filme.class));

        String busca = "%Matrix%";

        List<Filme> listaBusca = con.query(String.format(
                "SELECT * FROM filme WHERE nome LIKE '%s'", busca), new BeanPropertyRowMapper<>(Filme.class));

        Filme novoFilme = new Filme();
        novoFilme.setId(4);
        novoFilme.setNome("Sherek");
        novoFilme.setAnoLancamento(2004);

        con.update("INSERT INTO FILME (nome, anoLancamento) VALUES (?,?)",
                novoFilme.getNome(), novoFilme.getAnoLancamento());

        List<Filme> ListaSHE = con.query("SELECT * FROM filme", new BeanPropertyRowMapper<>(Filme.class));

        con.update("UPDATE filme SET nome = ?, anoLancamento = ? WHERE id = ?",
                novoFilme.getNome(),novoFilme.getAnoLancamento(),novoFilme.getId());

        List<Filme> filmesBanco = con.query("SELECT * FROM filme", new BeanPropertyRowMapper<>(Filme.class));
        System.out.println(filmesBanco);

        con.update("DELETE FROM filme WHERE id = ?",
                novoFilme.getId());
    }

}