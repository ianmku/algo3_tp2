package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class ControlPolicial extends Obstaculo {

    private final String urlImagen = "https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/control_policial.png?raw=true";
    private Aleatorio aleatorio;

    public ControlPolicial(Aleatorio aleatorio) {
        this.aleatorio = aleatorio;
    }

    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarControlPolicial(aleatorio);
    }
    public String getUrlImagen() {
        return urlImagen;
    }
}