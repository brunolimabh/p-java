package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {
    private List<Funcionario> funcionarios;

    public Empresa() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFunc(Funcionario f){
        if (Objects.nonNull(f)){
            funcionarios.add(f);
        }
    }
    public void exibeTodos(){
        for (Funcionario funcDaVez: funcionarios){
            System.out.println(funcDaVez.toString());
        }
    }
    public void exibeTotalSalario(){
        for (Funcionario funcDaVez: funcionarios){
            System.out.println(funcDaVez.calcSalario());
        }
    }
}
