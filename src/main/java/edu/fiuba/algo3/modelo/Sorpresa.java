package edu.fiuba.algo3.modelo;

public abstract class Sorpresa implements Interactuable {
    public abstract void interactuarConVehiculo(Vehiculo vehiculo);

    public boolean esObstaculo() {
        return false;
    }
}
