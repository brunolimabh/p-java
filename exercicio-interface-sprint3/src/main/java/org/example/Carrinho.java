package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carrinho {
    private List<Vendavel> vendavels;

    public Carrinho() {
        this.vendavels = new ArrayList<>();
    }

    public void adicionarVendavel(Vendavel t){
        if (Objects.nonNull(t)){
            vendavels.add(t);
        }
    }
    public double calculaTotalVenda(){
        double total = 0.0;
        for (Vendavel vendavelDaVez: vendavels){
            total += vendavelDaVez.getValorVenda();
        }
        return total;
    }
    public void exibirItensCarrinho(){
        for (Vendavel vendavelDaVez: vendavels){
            vendavelDaVez.toString();
        }
    }


}
