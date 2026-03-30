package edu.estatuas.bicipalma.domain.bicicleta;

public class Bicicleta implements Movil {
    private final int id;

    Bicicleta(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ID de bicicleta: " + getId();
    }
}
