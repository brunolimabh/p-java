package school.sptech.exercicioecommerce.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class ProdutoListagemDto {
    private int id;
    private String nome;
    private String fabricante;
    private String categoria;
    private int qtdEstoque;
    private int qtdVendidos;
    private double precoVenda;
    private double precoCompra;
    private double lucro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getQtdVendidos() {
        return qtdVendidos;
    }

    public void setQtdVendidos(int qtdVendidos) {
        this.qtdVendidos = qtdVendidos;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getLucro() {
        return (getPrecoVenda() - getPrecoCompra()) * getQtdVendidos();
    }
}
