package org.example.model;

public enum TipoComponente {
    PROCESSADOR(1),
    MEMORIA(2),
    DISCO(3);
    private int idComponente;

    TipoComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }
}
