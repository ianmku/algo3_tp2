package edu.fiuba.algo3.modelo;

public interface Tipo {
    public abstract int atravesarPozo();

    public abstract int atravesarPiquete(Mapa mapa, Direccion direccion);

    public abstract int atravesarControlPolicial();
}
