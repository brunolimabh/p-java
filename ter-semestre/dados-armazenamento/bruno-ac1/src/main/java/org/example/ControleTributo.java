package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleTributo {
    private List<IImposto> impostos;

    public ControleTributo(List<IImposto> impostos) {
        this.impostos = new ArrayList<>();
    }

    public double getTotalImposto(){
        return impostos.stream()
                .mapToDouble(IImposto::getImposto)
                .average()
                .orElse(0.0);
    }
}
