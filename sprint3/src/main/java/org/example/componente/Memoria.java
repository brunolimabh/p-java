package org.example.componente;

import com.github.britooo.looca.api.core.Looca;

public class Memoria extends Componente {
    public Memoria(Integer idComp, String nome, String unidadeMedida) {
        super(idComp, nome, unidadeMedida);
    }

    @Override
    public Double porcentagemUso() {
        Looca looca = new Looca();
        com.github.britooo.looca.api.group.memoria.Memoria memoria = looca.getMemoria();
        return (Math.ceil(memoria.getEmUso()/Math.pow(10,9))/Math.ceil(memoria.getTotal()/Math.pow(10,9)) * 100);
    }
}
