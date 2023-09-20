package org.example;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class Main {
    public static void main(String[] args) {

        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();

        System.out.println(looca.getProcessador().getUso());

    }
}