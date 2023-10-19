package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Address {
    private String nome;
    private Integer vagas;
    private List<Dev> devs;

    public Address(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.devs = new ArrayList<>();
    }

    public Boolean existePorNome(String nome){
        if (Objects.nonNull(nome)){
            for (Dev devDaVez: devs){
                if (devDaVez.getNome().equalsIgnoreCase(nome)){
                    return true;
                }
            }
        }
        return false;
    }
    public void contratar(Dev dev){
        if (Objects.nonNull(dev)){
            if (devs.size() < this.vagas){
                devs.add(dev);
            } else {
                System.out.println("Vagas cheias!");
            }
        }
    }
    public Integer qtdQuantidadeDevs(){
        return devs.size();
    }
    public Integer qtdQuantidadeDevsMobile(){
        Integer qtd = 0;
        for (Dev devDaVez: devs){
            if (devDaVez instanceof DevMobile){
                qtd++;
            }
        }
        return qtd;
    }
    public Double getTotalSalarios(){
        Double totalSalarios = 0.0;
        for (Dev devDaVez: devs){
            totalSalarios += devDaVez.getSalario();
        }
        return totalSalarios;
    }
    public Dev getDevPorNome(String nome){
        if (Objects.nonNull(nome)){
            for (Dev devDaVez: devs){
                if (devDaVez.getNome().equalsIgnoreCase(nome)){
                    return devDaVez;
                }
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "Address{" +
                "nome='" + nome + '\'' +
                ", vagas=" + vagas +
                '}';
    }
}
