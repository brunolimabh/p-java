package org.example.model;

import com.github.britooo.looca.api.core.Looca;

public class Processador extends Componente {
    public Processador(Integer idComp, String nome, String unidadeMedida) {
        super(idComp, nome, unidadeMedida);
    }

    @Override
    public Double porcentagemUso() {
        Looca looca = new Looca();
        com.github.britooo.looca.api.group.processador.Processador processador = looca.getProcessador();
        return processador.getUso();
    }
}
