package edu.estatuas.bicipalma;

public class TarjetaUsuario {
    private final String id;
    private boolean activada;

    TarjetaUsuario(String id, boolean activada) {
        this.id = id;
        this.activada = activada;
    }

    public boolean isActivada() {
        return this.activada;
    }
    
    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return  "id: " + getId() + "\n" +
                "activado:" + isActivada();
    }
}
