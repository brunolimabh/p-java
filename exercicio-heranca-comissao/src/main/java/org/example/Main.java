package org.example;

public class Main {
    public static void main(String[] args) {

        VendedorComissao v1 = new VendedorComissao(1,"Bruno",30.0,50.0);
        VendedorComissaoMaisFixo v2 = new VendedorComissaoMaisFixo(2,"Bruno 2",30.0,0.5,1300.00);

        System.out.println(v1);
        System.out.println(v2);
    }
}