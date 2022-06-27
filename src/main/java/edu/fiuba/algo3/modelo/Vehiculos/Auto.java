package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Auto implements Tipo {

    private final float CHANCE_CONTROL_POLICIAL = 0.5F;

    private final int PENALIZACION_POZO = 3;
    private final int PENALIZACION_CONTROL_POLICIAL = 3;

    public int atravesarPozo(){
        return PENALIZACION_POZO;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo) {
        mapa.moverVehiculo(vehiculo, direccion.opuesto());
        return -1;
    }

    public int atravesarControlPolicial(Aleatorio aleatorio) {
        if(aleatorio.atravesarControlPolicial(CHANCE_CONTROL_POLICIAL)) return PENALIZACION_CONTROL_POLICIAL;
        return 0;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Camioneta();
    }

}
