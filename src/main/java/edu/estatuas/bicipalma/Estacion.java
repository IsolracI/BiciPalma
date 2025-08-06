package edu.estatuas.bicipalma;

public class Estacion {
    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    public int getId() {
        return this.id;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void consultarEstacion() {
        System.out.println(this);
    }

    private Anclaje[] anclajes() {
        return this.anclajes.anclajes();
    }

    private int numAnclajes() {
        return this.anclajes.numAnclajes();
    }
    
    public int anclajesLibres() {
        int numAnclajesLibres = 0;

        for (Anclaje anclaje : anclajes()) {
            numAnclajesLibres = anclaje.isOcupado()? numAnclajesLibres: ++numAnclajesLibres;
        }
        return numAnclajesLibres;
    }

    public void anclarBicicleta(Bicicleta bici) {
        bici.getId();
    }

    public void consultarAnclajes() {
        for (Anclaje anclaje : anclajes()) {
            System.out.println("anclaje: " + anclaje.getBici());
        }
    }

    public String toString() {
        return  "Id de estación: " + getId() + "\n" +
                "Dirección: " + getDireccion() + "\n" + "Número de anclajes: ";
    }

}
