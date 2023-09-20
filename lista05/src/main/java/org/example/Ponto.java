package org.example;

public class Ponto {

    private Integer x;
    private Integer y;

    public Ponto(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void mover(Integer novoX, Integer novoY) {
        this.x = novoX;
        this.y = novoY;
        System.out.println("""
                ----------------------
                Executando mover(x,y)
                ----------------------
                X = %d
                Y = %d
                ----------------------
                """.formatted(x,y));
    }

    public Double getDistancia(Ponto outroPonto) {

        Double distancia = Math.sqrt((Math.pow((outroPonto.x - this.x), 2)) + Math.pow((outroPonto.y - this.y), 2));

        System.out.println("A distância entre o ponto atual e o ponto novo é %.2f".formatted(distancia));
        return distancia;
    }

}
