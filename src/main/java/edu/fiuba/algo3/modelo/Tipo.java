package edu.fiuba.algo3.modelo;

public interface Tipo {
    public abstract int atravesarPozo();

    public abstract int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo);

    public abstract int atravesarControlPolicial();

    public abstract Tipo atravesarCambioVehiculo();

}
