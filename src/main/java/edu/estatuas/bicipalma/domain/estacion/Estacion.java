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

    public int getId() {
        return this.id;
    }

    public String getDireccion() {
        return this.direccion;
    }

    private int numAnclajes() {
        return anclajes.numAnclajes();
    }

    public void consultarEstacion() {
        System.out.println("id: " + getId());
        System.out.println("direccion: " + getDireccion());
        System.out.println("numeroAnclajes: " +  numAnclajes());
    }

    private Anclaje[] anclajes() {
        return anclajes.anclajes();
    }

    public int anclajesLibres() {
        int anclajesLibres = 0;

        for (Anclaje anclaje : anclajes()) {
            if (!anclaje.isOcupado()) {
                anclajesLibres++;
            }
        }

        return anclajesLibres;
    }

    public void consultarAnclajes() {
        for (int i = 0; i < anclajes().length; i++) {
            if (anclajes()[i].isOcupado()) {
                System.out.println("bicicleta: " + anclajes()[i].getBici() + "anclada en el anclaje: " + i + 1);
            }
        }
    }


}
