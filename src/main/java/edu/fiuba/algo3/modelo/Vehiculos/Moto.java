package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Moto implements Tipo {

    private final float CHANCE_CONTROL_POLICIAL = 0.8F;

    public int atravesarPozo(){
        return 3;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo){
        return 2;
    }

    public int atravesarControlPolicial(Aleatorio aleatorio) {
        if(aleatorio.atravesarControlPolicial(CHANCE_CONTROL_POLICIAL)) return 3;
        return 0;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Auto();
    }

}