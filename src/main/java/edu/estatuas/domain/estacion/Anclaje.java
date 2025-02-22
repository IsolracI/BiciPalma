package edu.estatuas.domain.estacion;

import edu.estatuas.domain.bicicleta.Bicicleta;

class Anclaje {
// por qué no especifica la visibilidad de nada?
    
    private boolean ocupado = false;
//si declaro un boolean siempre tengo que clarificar que es false?
    private Bicicleta bici = null;
// por qué tengo que declarar que es null?

    Anclaje() {};

    boolean isOcupado() {
        return this.ocupado;
    }

    Bicicleta getBici() {
        return this.bici;
    }

    void anclarBici(Bicicleta bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    void liberarBici() {
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return "ocupado: " + isOcupado();
    //el codigo de David tiene un Boolean.toString(isOcupado()), esto no es suficiente
    }
}
