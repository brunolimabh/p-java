package org.example;

public class ValorInvalidoException  extends RuntimeException{
    public ValorInvalidoException(String message) {
        super("valores não podem ser nulos");
    }
}
