package edu.fiuba.algo3.modelo;

public class SorpresaFavorable extends Sorpresa{
    public void interactuarConVehiculo(Vehiculo vehiculo) {
        vehiculo.atravesarSorpresaFavorable();
    }
}