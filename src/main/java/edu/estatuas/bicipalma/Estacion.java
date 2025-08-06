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

    private void mostrarAnclaje(Bicicleta bici, int posicion) {
        System.out.println("bicicleta " + bici.getId() + " anclada en el anclaje Nº " + posicion);
    }

    public void anclarBicicleta(Bicicleta bici) {
        int posicion = 1;

        for (Anclaje anclaje : anclajes()) {
            if (!anclaje.isOcupado()) {
                anclaje.anclarBici(bici);
                mostrarAnclaje(bici, posicion);
                break;
            }
            else {
                posicion++;
            }
        }
    }

    public void consultarAnclajes() {
        int posicion = 1;
        for (Anclaje anclaje : anclajes()) {
            if (anclaje.isOcupado()) {
                System.out.println("anclaje Nº " + posicion + ": " + anclaje.getBici().getId());
            }
            else {
                System.out.println("anclaje Nº " + posicion + ": Libre");
            }
            posicion++;
        }
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjeta) {
        return tarjeta.isActivada();
    }

    private void mostrarBicicleta(Bicicleta bici, int posicion) {
		System.out.println("bicicleta retirada: " + bici.getId() + " del anclaje: " + posicion);
    }

    public void retirarBicicleta(TarjetaUsuario tarjeta) {

        if (leerTarjetaUsuario(tarjeta)) {

			boolean biciRetirada = false;

			while (!biciRetirada) {

				int posicion = anclajes.seleccionarAnclaje();
				int numeroAnclaje = posicion + 1;

				if (anclajes.isAnclajeOcupado(posicion)) {
					mostrarBicicleta(anclajes.getBiciAt(posicion), numeroAnclaje);
					anclajes.liberarAnclaje(posicion);
					biciRetirada = true;
				}
			}

		} else {
			System.out.println("Tarjeta de usuario inactiva :(");
		}
	}
    


    public String toString() {
        return  "Id de estación: " + getId() + "\n" +
                "Dirección: " + getDireccion() + "\n" +
                "Número de anclajes: " + numAnclajes();
    }

}
