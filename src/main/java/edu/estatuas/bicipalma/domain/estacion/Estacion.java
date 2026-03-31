package edu.estatuas.bicipalma.domain.estacion;

import edu.estatuas.bicipalma.domain.bicicleta.Movil;
import edu.estatuas.bicipalma.domain.tarjetausuario.Autenticacion;

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

    private void mostrarBicicleta(Movil bicicleta, int posicion) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Anclaje ");
        mensaje.append(posicion);
        mensaje.append(" ");
        mensaje.append(bicicleta.getId());
        System.out.println(mensaje.toString());
    }

    private void mostrarAnclaje(int posicion) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Anclaje ");
        mensaje.append(posicion);
        mensaje.append("  libre");
        System.out.println(mensaje.toString());
    }

    public void consultarAnclajes() {
        for (int i = 0; i < anclajes().length; i++) {
            if (anclajes()[i].isOcupado()) {
                mostrarBicicleta(anclajes()[i].getBici(), i + 1);
            }
            else {
                mostrarAnclaje(i + 1);
            }
        }
    }

    public void anclarBicicleta(Movil bici) {
        for (int i = 0; i < anclajes().length; i++) {
            if (!anclajes()[i].isOcupado()) {
                this.anclajes.ocuparAnclaje(i, bici);
                break;
            }
        }
    }

    public boolean leerTarjetaUsuario(Autenticacion tarjeta) {
        return tarjeta.isActivada();
    }

    public void retirarBicicleta(Autenticacion tarjeta) {
        int posicion = this.anclajes.seleccionarAnclaje();

        while (!anclajes()[posicion].isOcupado()) {
            posicion = this.anclajes.seleccionarAnclaje();
        }

        if  (tarjeta.isActivada()) {
            this.anclajes.liberarAnclaje(posicion);
        }
    }

}
