package edu.estatuas.bicipalma.domain.estacion;

import edu.estatuas.bicipalma.domain.bicicleta.Movil;

import java.util.concurrent.ThreadLocalRandom;

public class Anclajes {
    private Anclaje[] anclajes;

    Anclajes(int numAnclajes) {
        anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    private void crearAnclajes() {
        for (Anclaje anclaje : this.anclajes) {
            new Anclaje();
        }
    }

    Anclaje[] anclajes() {
        return this.anclajes;
    }

    int numAnclajes() {
        return anclajes().length;
    }

    void ocuparAnclaje(int posicion, Movil bici) {
        anclajes()[posicion].anclarBici(bici);
    }

    boolean isAnclajeOcupado(int posicion) {
        return anclajes()[posicion].isOcupado();
    }

    void liberarAnclaje(int posicion) {
        anclajes()[posicion].liberarBici();
    }

    Movil getBiciAt(int posicion) {
        return anclajes()[posicion].getBici();
    }

    int seleccionarAnclaje() {
        return ThreadLocalRandom.current().nextInt(0, numAnclajes());
    }

    @Override
    public String toString() {
        return "eeeeeeeeeeeeehh... y yo qué pongo aquí?...";
    }
}
