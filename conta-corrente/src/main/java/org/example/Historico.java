package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class Historico {
    private LocalDateTime dataHora;
    private String operacao;
    private Double descricao;

    public Historico(String operacao, Double descricao) {
        this.dataHora = LocalDateTime.now();
        this.operacao = operacao;
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Double getDescricao() {
        return descricao;
    }

    public void setDescricao(Double descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "dataHora=" + dataHora +
                ", operacao='" + operacao + '\'' +
                ", descricao=" + descricao +
                '}';
    }
}
