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
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        long porcentagem = (memoria.getEmUso() * 100) / memoria.getTotal();
        return Double.parseDouble(decimalFormat.format(porcentagem));
    }
}
