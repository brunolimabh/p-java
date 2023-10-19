package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;

public class Compra {
    private String nomeCliente;
    private List<Produto> produtos;

    public Compra(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto){
        if (Objects.nonNull(produto)){
            this.produtos.add(produto);
        }
    }
    public void removerProduto(int indice){
        for (int i = 0; i < this.produtos.size(); i++) {
            if (i == indice){
                produtos.remove(i);
            }
        }
    }
    public Integer getQuantidadeProdutos(){
        return produtos.size();
    }
    public Integer getQuantidadeProdutosFrageis(){
        Integer qtdProdutos = 0;
        for (Produto produtoDaVez: produtos){
            if (produtoDaVez.getFragil()){
                qtdProdutos += 1;
            }
        }
        return qtdProdutos;
    }
    public Produto getProdutoPorNome(String nome){
        if (Objects.nonNull(nome)){
            for (Produto produtoDaVez: produtos){
                if (produtoDaVez.getNome().equalsIgnoreCase(nome)){
                    return  produtoDaVez;
                }
            }
        }
        return null;
    }
    public List<Produto> getProdutosPorCategoria(String categoria){
        List<Produto> listaProdutos = new ArrayList<>();
        if (Objects.nonNull(categoria)){
            for (Produto produtoDaVez: produtos){
                if (produtoDaVez.getCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                    listaProdutos.add(produtoDaVez);
                }
            }
        }
        return listaProdutos;
    }
    public Double calcularTotalFrete(){
        Double freteTotal = 0.0;
        for (Produto produtoDaVez: produtos){
            freteTotal += produtoDaVez.calcularFrete();
        }
        return freteTotal;
    }
    public Double calcularTotalProdutos(){
        Double produtosTotal = 0.0;
        for (Produto produtoDaVez: produtos){
            produtosTotal += produtoDaVez.getPreco();
        }
        return produtosTotal;
    }
    public Double calcularTotalCompra(){
        Double comprasTotal = 0.0;
        for (Produto produtoDaVez: produtos){
            comprasTotal += produtoDaVez.getPreco();
            comprasTotal += produtoDaVez.calcularFrete();
        }
        return comprasTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
