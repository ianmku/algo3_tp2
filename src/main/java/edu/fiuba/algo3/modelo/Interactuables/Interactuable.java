package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public interface Interactuable {
    void interactuarConVehiculo(Vehiculo vehiculo);

    String getUrlImagen();
}
