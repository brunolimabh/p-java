package org.example;

public class Imovel implements IImposto {
    private double valorM2;
    private int area;
    private String bairro;

    public Imovel(double valorM2, int area, String bairro) {
        this.valorM2 = valorM2;
        this.area = area;
        this.bairro = bairro;
    }

    public double getImposto(){
        return (area * valorM2) * 0.05;
    }

    public double getValorM2() {
        return valorM2;
    }

    public void setValorM2(double valorM2) {
        this.valorM2 = valorM2;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "valorM2=" + valorM2 +
                ", area=" + area +
                ", bairro='" + bairro + '\'' +
                ", getImposto='" + getImposto() + '\'' +
                '}';
    }
}
