package org.example.model;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;

import java.util.List;

public class Disco extends Componente {
    public Disco(Integer idComp, String nome, String unidadeMedida) {
        super(idComp, nome, unidadeMedida);
    }

    @Override
    public Double porcentagemUso() {
        Looca looca = new Looca();

        DiscoGrupo grupoDeDiscos = new DiscoGrupo();
        List<Volume> volumes = grupoDeDiscos.getVolumes();

        Double usoDisco = 0.0;
        Double volumeTotalDiscos = 0.0;
        Double volumeDisponivelDiscos = 0.0;

        for (Volume volume : volumes) {
            volumeTotalDiscos += volume.getTotal();
            volumeDisponivelDiscos += volume.getDisponivel();
        }

        Double usoDiscos = (Double) (((volumeTotalDiscos - volumeDisponivelDiscos) * 100) / volumeTotalDiscos);

        return usoDiscos;
    }
}
