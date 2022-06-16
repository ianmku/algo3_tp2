package edu.fiuba.algo3.modelo;

public class SorpresaCambioVehiculo extends Sorpresa{
    public void interactuarConVehiculo(Vehiculo vehiculo) {
        vehiculo.atravesarSorpresaCambioDeVehiculo();
    }
}
