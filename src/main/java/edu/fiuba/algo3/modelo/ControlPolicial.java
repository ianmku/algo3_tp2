package edu.fiuba.algo3.modelo;

public class ControlPolicial extends Obstaculo {

    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarControlPolicial();
    }
}