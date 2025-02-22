package edu.estatuas.domain.bicicleta;

public class Bicicleta {
    
    private final int id;

    public Bicicleta(int id) {
        this.id = id;
    }

    public int getid() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id: " + getid();
    }
}
