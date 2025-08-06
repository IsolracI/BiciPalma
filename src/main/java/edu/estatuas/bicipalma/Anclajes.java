package edu.estatuas.bicipalma;

import java.util.concurrent.ThreadLocalRandom;

public class Anclajes {
    private final Anclaje[] anclajes;
    
    Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    private void crearAnclajes() {
        for (int i = 0; i < numAnclajes() ; i++ ) {
            this.anclajes[i] = new Anclaje();
        }
    }

    public Anclaje[] anclajes() {
        return this.anclajes;
    }

    public int numAnclajes() {
        return anclajes().length;
    }

    public boolean isAnclajeOcupado(int index) {
        return this.anclajes[index].isOcupado();
    }
    
    public void ocuparAnclaje(int index, Bicicleta bici) {
        if (!isAnclajeOcupado(index)) {
            this.anclajes[index].anclarBici(bici);
        }
        else {
            System.out.println("mira huevón! este anclaje YA ESTÁ ocupado!");
        }
    }

    public void liberarAnclaje(int index) {
        if (isAnclajeOcupado(index)) {
            this.anclajes[index].liberarBici();
        }
        else {
            System.out.println("eeeeeeeehhm... el anclaje está libre, cuál bicicleta quieres quitar exactamente...?");
        }
    }

    public Bicicleta getBiciAt(int index) {
        return this.anclajes[index].getBici();
    }

    public int seleccionarAnclaje() {
        return ThreadLocalRandom.current().nextInt(0, numAnclajes());
    }

    public String toString() {
        return "número de anclajes: " + numAnclajes();
    }

}
