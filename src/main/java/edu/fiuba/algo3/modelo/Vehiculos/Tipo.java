package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

public interface Tipo {
    public abstract int atravesarPozo();

    public abstract int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo);

    public abstract int atravesarControlPolicial();

    public abstract Tipo atravesarCambioVehiculo();

}
