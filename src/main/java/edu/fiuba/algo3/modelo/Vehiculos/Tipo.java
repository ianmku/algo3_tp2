package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

public interface Tipo {
    int atravesarPozo();

    int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo);

    int atravesarControlPolicial(Aleatorio aleatorio);

    Tipo atravesarCambioVehiculo();

    String getUrlImagen();

}
