package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Piquete extends Obstaculo {

    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarPiquete();
    }
}
