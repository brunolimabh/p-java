package org.example.model;

public enum TipoComponente {
    PROCESSADOR(1,"cpu"),
    MEMORIA(2,"memoria"),
    DISCO(3,"disco");
    private int fkComponente;
    private String descricao;

    TipoComponente(int fkComponente, String descricao) {
        this.fkComponente = fkComponente;
        this.descricao = descricao;
    }

    public static TipoComponente of(int idComponente){
        switch (idComponente){
            case 1:
                return PROCESSADOR;
            case 2:
                return MEMORIA;
            case 3:
                return DISCO;
        }
        return null;
    }


    public int getIdComponente() {
        return fkComponente;
    }

    public void setIdComponente(int idComponente) {
        this.fkComponente = idComponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
