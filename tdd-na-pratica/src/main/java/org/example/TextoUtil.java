package org.example;

public class TextoUtil {

    Integer contarPalavras(String xpto){
        return xpto.split(" ").length;
    }

    String inverter(String xpto){
        return new StringBuilder(xpto).reverse().toString();
    }

    String capitalizar(String xpto){
        return xpto.substring(0,1).toUpperCase().concat(xpto.substring(1));
    }
}
