package edu.estatuas.bicipalma;

public class Anclaje {
    private boolean ocupado;
    private Bicicleta bici;

    Anclaje() {}

    public boolean isOcupado() {
        return ocupado;
    }

    private void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Bicicleta getBici() {
        return bici;
    }

    private void setBici(Bicicleta bici) {
        this.bici = bici;
    }

    public void anclarBici(Bicicleta bici) {
        setOcupado(true);
        setBici(bici);
    }

    public void liberarBici() {
        setOcupado(false);
        setBici(null);
    }

    @Override
    public String toString() {
        return  "Bicicleta: " + getBici();
    }
}
