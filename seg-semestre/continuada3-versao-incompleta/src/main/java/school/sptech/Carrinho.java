package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto){
        int cont = 0;
        if (Objects.nonNull(produto)){
            if (produtos.size() == 0){
                produtos.add(produto);
            } else {
                for (Produto produtoDaVez: produtos){
                    if (produtoDaVez.getCodigoBarra().equalsIgnoreCase(produto.getCodigoBarra())){
                        cont += 1;
                    }
                }
                if (cont == 0){
                    produtos.add(produto);
                }
            }
        }
    }

    public void removerProduto(int indice){
        for (int i = 0; i < produtos.size(); i++) {
            if (i == indice){
                produtos.remove(indice);
            }
        }
    }
    public Produto obterProduto(int indice){
        if (Objects.nonNull(indice)){
            for (int i = 0; i < produtos.size(); i++) {
                if (i == indice){
                    return produtos.get(i);
                }
            }
        }
        return null;
    }
    public List<Produto> buscarPorCategoria(String categoria){
        List<Produto> listaProdutos = new ArrayList<>();
        if (Objects.nonNull(categoria)){
            for (Produto produtoDaVez: produtos){
                if (produtoDaVez.getCategoria().equalsIgnoreCase(categoria)){
                    listaProdutos.add(produtoDaVez);
                }
            }
        }
        return listaProdutos;
    }
    public List<ProdutoInternacional> buscarProdutosInternacionais(){
        List<ProdutoInternacional> listaProdutos = new ArrayList<>();
        for (Produto produtoDaVez: produtos){
            if (produtoDaVez instanceof ProdutoInternacional){
                listaProdutos.add((ProdutoInternacional) produtoDaVez);
            }
        }
        return listaProdutos;
    }
    public List<ProdutoNacional> buscarProdutosNacionais(){
        List<ProdutoNacional> listaProdutos = new ArrayList<>();
        for (Produto produtoDaVez: produtos){
            if (produtoDaVez instanceof ProdutoNacional){
                listaProdutos.add((ProdutoNacional) produtoDaVez);
            }
        }
        return listaProdutos;
    }
    public Double calcularTotalEmEstoque(){
        Double qtd = 0.0;
        for (Produto produtoDaVez: produtos){
            qtd += produtoDaVez.calcularPrecoTotal();
        }
        return qtd;
    }
    public Double calcularTotalEmEstoquePorCategoria(String categoria){
        Double qtd = 0.0;
        for (Produto produtoDaVez: produtos){
            if (produtoDaVez.getCategoria().equalsIgnoreCase(categoria)){
                qtd += produtoDaVez.calcularPrecoTotal();
            }
        }
        return qtd;
    }
    public List<ProdutoInternacional> buscarPorPaisOrigem(String paisOrigem){
        List<ProdutoInternacional> listaProdutos = new ArrayList<>();
        for (Produto produtoDaVez: produtos){
            if (produtoDaVez instanceof ProdutoInternacional){
                if (((ProdutoInternacional) produtoDaVez).getPaisOrigem().equalsIgnoreCase(paisOrigem)){
                    listaProdutos.add((ProdutoInternacional) produtoDaVez);
                }
            }
        }
        return listaProdutos;
    }
    public boolean existeProdutoPorCodigoBarra(String codigoBarra){
        if (Objects.nonNull(codigoBarra)){
            for (Produto produtoDaVez: produtos){
                if (produtoDaVez.getCodigoBarra().equalsIgnoreCase(codigoBarra)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean existePorIndice(int indice){
        if (Objects.nonNull(indice)){
            for (int i = 0; i < produtos.size(); i++) {
                if (i == indice && Objects.nonNull(produtos.get(i))){
                    return true;
                }
            }
        }
        return false;
    }
}
