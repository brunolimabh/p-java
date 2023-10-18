package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContaCorrente {
    private String titular;
    private String agencia;
    private String numero;
    private List<OperacaoBancaria> operacoes;

    public ContaCorrente(String titular, String agencia, String numero, List<OperacaoBancaria> operacoes) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.operacoes = new ArrayList<>();
    }

    public void adicionarOperacao(String categoria, String descricao, Double valor){
        if (Objects.nonNull(categoria) && Objects.nonNull(descricao) && Objects.nonNull(valor) && valor != 0 && descricao != " " && categoria != " ") {
            OperacaoBancaria novaOperacao = new OperacaoBancaria(categoria,descricao,valor);
            operacoes.add(novaOperacao);
        }
    }

    public List<OperacaoBancaria> buscarOperacoesPorCategoria(String categoria){
        List<OperacaoBancaria> listaOperacoes = new ArrayList<>();
        if (Objects.nonNull(categoria)){
            for(OperacaoBancaria operacaoDaVez: operacoes){
                if (operacaoDaVez.getCategoria().equalsIgnoreCase(categoria)){
                    listaOperacoes.add(operacaoDaVez);
                }
            }
        }
        return listaOperacoes;
    }

    public List<OperacaoBancaria> buscarOperacoesPorValor(Double valor){
        List<OperacaoBancaria> listaOperacoes = new ArrayList<>();
        if (Objects.nonNull(valor)){
            for (OperacaoBancaria operacaoDaVez: operacoes){
                if (operacaoDaVez.getValor().equals(valor)
                ){
                    listaOperacoes.add(operacaoDaVez);
                }
            }
        }
        return listaOperacoes;
    }

    public List<OperacaoBancaria> buscarOperacoesSaida(){
        List<OperacaoBancaria> listaOperacoes = new ArrayList<>();
        for(OperacaoBancaria operacaoDaVez: operacoes){
            if (operacaoDaVez.getValor() < 0){
                listaOperacoes.add(operacaoDaVez);
            }
        }
        return listaOperacoes;
    }

    public List<OperacaoBancaria> buscarOperacoesEntrada(){
        List<OperacaoBancaria> listaOperacoes = new ArrayList<>();
        for(OperacaoBancaria operacaoDaVez: operacoes){
            if (operacaoDaVez.getValor() > 0){
                listaOperacoes.add(operacaoDaVez);
            }
        }
        return listaOperacoes;
    }

    public List<OperacaoBancaria> buscarOperacoesPorDescricao(String descricao){
        List<OperacaoBancaria> listaOperacoes = new ArrayList<>();
        if (Objects.nonNull(descricao)){
            for(OperacaoBancaria operacaoDaVez: operacoes){
                if (operacaoDaVez.getDescricao().toLowerCase().contains(descricao.toLowerCase())) {
                    listaOperacoes.add(operacaoDaVez);
                }
            }
        }
        return listaOperacoes;
    }

    public Double buscarMaiorValor(){
        Double maiorValor = -10000.0;
        Boolean isAdd = false;
        for(OperacaoBancaria operacaoDaVez: operacoes){
            if (operacaoDaVez.getValor() > maiorValor){
                maiorValor = operacaoDaVez.getValor();
                isAdd = true;
            }
        }
        if (isAdd){
            return maiorValor;
        } else {
            return 0.0;
        }
    }

    public Double buscarMenorValor(){
        Double menorValor = 10000000.0;
        Boolean isAdd = false;
        for(OperacaoBancaria operacaoDaVez: operacoes){
            if (operacaoDaVez.getValor() < menorValor && Objects.nonNull(operacaoDaVez.getValor())){
                menorValor = operacaoDaVez.getValor();
                isAdd = true;
            }
        }
        if (isAdd){
            return menorValor;
        } else {
            return 0.0;
        }
    }

    public Double obterSaldo(){
        Double saldo = 0.0;
        for(OperacaoBancaria operacaoDaVez: operacoes){
            saldo += operacaoDaVez.getValor();
        }
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
