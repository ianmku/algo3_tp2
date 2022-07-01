package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Piquete extends Obstaculo {

    private final String urlImagen = "https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/piquete.png?raw=true";
    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarPiquete();
    }
    public String getUrlImagen() {
        return urlImagen;
    }
}
