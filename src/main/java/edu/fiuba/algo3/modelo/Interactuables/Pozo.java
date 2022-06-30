package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Pozo extends Obstaculo {

    private final String urlImagen = "https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/pozo.png?raw=true";

    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarPozo();
    }
    public String getUrlImagen() {
        return urlImagen;
    }
}
