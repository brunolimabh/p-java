package org.example.enumeradores;

// Tipo especial dentro do Java, mas existe na programação em outras linguagens
// Como se fosse uma constante mais robusta, serve para trabalhar com valores fixos

public enum DiaDaSemanaEnum {

    // Atributos e/ou variaveis que são final utilizam o padrao MACRO_CASE
    DOMINGO(1,"Domingo"),
    SEGUNDA(2,"Segunda-feira"),
    TERCA(3,"Terça-feira"),
    QUARTA(4,"Quarta-feira"),
    QUINTA(5,"Quinta-feira"),
    SEXTA(5,"Sexta-feira"),
    SABADO(7,"Sábado");
    private int codigo;
    private String descricao;

    DiaDaSemanaEnum(int codigo,String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static DiaDaSemanaEnum of(int codigo){
        switch (codigo){
            case 1:
                return DOMINGO;
            case 2:
                return SEGUNDA;
            case 3:
                return TERCA;
            case 4:
                return QUARTA;
            case 5:
                return QUINTA;
            case 6:
                return SEXTA;
            case 7:
                return SABADO;
        }
        return null;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
