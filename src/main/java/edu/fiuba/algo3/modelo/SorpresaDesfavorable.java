package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable extends Sorpresa{
    public void interactuarConVehiculo(Vehiculo vehiculo) {
        vehiculo.atravesarSorpresaDesfavorable();
    }
}