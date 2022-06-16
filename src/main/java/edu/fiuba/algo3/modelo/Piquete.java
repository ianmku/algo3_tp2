package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo {

    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarPiquete();
    }
}
