package edu.estatuas.bicipalma;

public class Estacion {
    private final int id;
    private final String direccion;

    Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        int[] anclajes = new int[numAnclajes];
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

    public String toString() {
        return  "Id de estación: " + getId() + "\n" +
                "Dirección: " + getDireccion() + "\n" + "Número de anclajes: ";
    }
}
