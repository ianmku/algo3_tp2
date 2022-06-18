package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public abstract class Obstaculo implements Interactuable {

    public abstract void interactuarConVehiculo(Vehiculo vehiculo);
}
