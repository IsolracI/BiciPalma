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

    public void consultarAnclajes() {
        for (int i = 0; i < anclajes().length; i++) {
            if (anclajes()[i].isOcupado()) {
                System.out.println("Anclaje: " + (i + 1) + " " + anclajes()[i].getBici());
            }
            else {
                System.out.println("Anclaje: " + (i + 1) + "\tlibre");
            }
        }
    }

    private void mostrarBicicleta(Movil bicicleta, int posicion) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("bicicleta retirada: ");
        mensaje.append(bicicleta.getId());
        mensaje.append(" del anclaje: ");
        mensaje.append(posicion);
        System.out.println(mensaje.toString());
    }

    private void mostrarAnclaje(Movil bicicleta, int posicion) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("bicicleta ");
        mensaje.append(bicicleta.getId());
        mensaje.append(" anclada en el anclaje ");
        mensaje.append(posicion);
        System.out.println(mensaje.toString());
    }

    public void anclarBicicleta(Movil bici) {
        for (int i = 0; i < anclajes().length; i++) {
            if (!anclajes()[i].isOcupado()) {
                this.anclajes.ocuparAnclaje(i, bici);
                mostrarAnclaje(bici, i + 1);
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
            mostrarBicicleta(this.anclajes.getBiciAt(posicion), posicion + 1);
            this.anclajes.liberarAnclaje(posicion);
        }
    }

}
