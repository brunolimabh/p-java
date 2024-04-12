package school.sptech.exercicioecommerce.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class ProdutoCriacaoDto {
    @Size(min = 3, max = 100)
    @NotBlank
    private String nome;
    @NotBlank
    @Size(min = 2, max = 50)
    private String fabricante;
    @Size(min = 2, max = 50)
    @NotBlank
    private String categoria;
    @PositiveOrZero
    @NotNull
    private int qtdEstoque;
    @NotNull
    @Positive
    private double precoVenda;
    @NotNull
    @Positive
    private double precoCompra;

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
}
