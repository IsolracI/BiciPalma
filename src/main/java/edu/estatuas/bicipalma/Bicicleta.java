package edu.estatuas.bicipalma;

public class Bicicleta {
    private final int id;

    Bicicleta(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id: " + getId();
    }
}
