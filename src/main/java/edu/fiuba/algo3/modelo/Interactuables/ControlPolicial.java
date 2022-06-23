package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class ControlPolicial extends Obstaculo {

    private Aleatorio aleatorio;

    public ControlPolicial(Aleatorio aleatorio) {
        this.aleatorio = aleatorio;
    }

    public void interactuarConVehiculo(Vehiculo vehiculo){
        vehiculo.atravesarControlPolicial();
    }
}