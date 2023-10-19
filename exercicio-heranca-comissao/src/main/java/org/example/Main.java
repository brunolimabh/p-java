package org.example;

public class Main {
    public static void main(String[] args) {

        VendedorComissao v1 = new VendedorComissao(1,"Bruno",10.0,2.0);
        VendedorComissaoMaisFixo v2 = new VendedorComissaoMaisFixo(2,"Bruno 2",13.0,1.5,1300.00);

        System.out.println(v1.calcularSalario());
        System.out.println(v2.calcularSalario());
    }
}