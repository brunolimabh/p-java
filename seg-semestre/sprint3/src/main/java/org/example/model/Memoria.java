package org.example.model;

import com.github.britooo.looca.api.core.Looca;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Memoria extends Componente {
    public Memoria(Integer idComp, String nome, String unidadeMedida) {
        super(idComp, nome, unidadeMedida);
    }

    @Override
    public Double porcentagemUso() {
        Looca looca = new Looca();
        com.github.britooo.looca.api.group.memoria.Memoria memoria = looca.getMemoria();
        long porcentagem = (memoria.getEmUso() * 100) / memoria.getTotal();
        return Double.parseDouble(String.valueOf(porcentagem));
    }
}
