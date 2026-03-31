package edu.estatuas.bicipalma.domain.estacion;

public class Estacion {
    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        anclajes = new Anclajes(numAnclajes);
    }
}
