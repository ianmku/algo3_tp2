package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Moto implements Tipo {

    private final float CHANCE_CONTROL_POLICIAL = 0.8F;
    private final int PENALIZACION_POZO = 3;
    private final int PENALIZACION_PIQUETE = 2;
    private final int PENALIZACION_CONTROL_POLICIAL = 3;
    private final int NO_SE_PENALIZA = 0;

    private final String urlImagen = "https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/moto.jpg?raw=true";

    public int atravesarPozo(){
        return PENALIZACION_POZO;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo){
        return PENALIZACION_PIQUETE;
    }

    public int atravesarControlPolicial(Aleatorio aleatorio) {
        if(aleatorio.atravesarControlPolicial(CHANCE_CONTROL_POLICIAL)) return PENALIZACION_CONTROL_POLICIAL;
        return NO_SE_PENALIZA;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Auto();
    }

    public String getUrlImagen() {
        return urlImagen;
    }

}