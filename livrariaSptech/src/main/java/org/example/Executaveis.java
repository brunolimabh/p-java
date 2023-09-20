package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Executaveis {
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoBanco();
    public void exibirLivros() {
        List<Livro> listaLivros = con.query("SELECT * FROM livros", new BeanPropertyRowMapper<>(Livro.class));
        System.out.println(listaLivros);
    }

    public void addLivro(String nome, Double preco) {
        Livro novoLivro = new Livro();
        novoLivro.setNome(nome);
        novoLivro.setPreco(preco);
        con.update("INSERT INTO livros(nome,preco) VALUES (?, ?)", novoLivro.getNome(), novoLivro.getPreco());
    }
    public void attLivro(Integer id, String nome, Double preco) {
        Livro attLivro = new Livro();
        attLivro.setId(id);
        attLivro.setNome(nome);
        attLivro.setPreco(preco);
        con.update("UPDATE livros SET nome = ?, preco = ? WHERE id = ?",
                attLivro.getNome(), attLivro.getPreco(), attLivro.getId());
    }

    public void dltLivro(Integer id) {
        con.update("DELETE FROM livros WHERE id = ?", id);
    }

    public void buscarNome(String nome) {
        List<Livro> listaBusca = con.query(String.format(
                "SELECT * FROM livros WHERE nome LIKE '%%%s%%'", nome), new BeanPropertyRowMapper<>(Livro.class));
        System.out.println(listaBusca);
    }

}
