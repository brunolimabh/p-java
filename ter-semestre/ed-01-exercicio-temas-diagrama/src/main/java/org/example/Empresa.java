package org.example;

import java.util.List;
import java.util.Objects;

public class Empresa {
    private String razao;
    private int cnpj;
    private int cep;
    private List<IPagamento> pagamentos;

    public Empresa(String razao, int cnpj, int cep) {
        this.razao = razao;
        this.cnpj = cnpj;
        this.cep = cep;
    }

    public boolean addIPagamento(IPagamento ip) {
        if (Objects.nonNull(ip)){
            pagamentos.add(ip);
            return true;
        }
        return false;
    }
    public boolean rmvIPagamento(IPagamento ip) {
        if (Objects.isNull(ip)){
            pagamentos.remove(ip);
            return true;
        }
        return false;
    }
    public double getTotalPagamento(){
        double valorTotal = 0.0;
        for (IPagamento pagamentoDaVez: pagamentos){
            valorTotal += pagamentoDaVez.getValorPagamento();
        }
        return valorTotal;
    }
}
