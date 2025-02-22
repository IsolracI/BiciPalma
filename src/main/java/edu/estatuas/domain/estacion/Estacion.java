package edu.estatuas.domain.estacion;

public class Estacion {
    
    private final int id;
    private final String direccion;
    private final int numAnclajes;
    
    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.numAnclajes = numAnclajes;
    }


    public int getid() {
        return this.id;
    }


    public String getdireccion() {
        return this.direccion;
    }


    public int getanclajes() {
        return this.numAnclajes;
    }


    @Override
    public String toString(){
        return "id: " + getid() + '\n' +
				"direccion: " + getdireccion() + '\n' +
				"numeroAnclajes: " + getanclajes();
    }


    public void consultarEstacion() {
        System.out.println(this);
    }
}
