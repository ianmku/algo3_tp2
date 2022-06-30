package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Piquete extends Obstaculo {

    private final String urlImagen = "https://github.com/ianmku/algo3_tp2/blob/bd11ada4e8fe33e478a02f52b393f6d3a19e7c27/resources/images/piquete.jpg";
    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarPiquete();
    }
    public String getUrlImagen() {
        return urlImagen;
    }
}
