package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Pozo extends Obstaculo {

    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarPozo();
    }
}
