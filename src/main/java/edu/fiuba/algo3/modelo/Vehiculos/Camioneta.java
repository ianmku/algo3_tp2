package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Camioneta implements Tipo {

    private final float CHANCE_CONTROL_POLICIAL = 0.3F;
    private final int PENALIZACION_POZO = 2;
    private final int PENALIZACION_CONTROL_POLICIAL = 3;
    private final int NO_SE_PENALIZA = 0;
    private final int NO_SE_ATRAVIESA_CONTROL_POLICIAL = -1;
    private int cantidadDePozosAtravesados;
    private final String urlImagen = "https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/camioneta.png?raw=true";

    public Camioneta(){
        this.cantidadDePozosAtravesados = 0;
    }

    public int atravesarPozo(){
        this.cantidadDePozosAtravesados++;
        if((this.cantidadDePozosAtravesados % 3) == 0){
            return PENALIZACION_POZO;
        }
        return NO_SE_PENALIZA;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo) {
        mapa.moverVehiculo(vehiculo, direccion.opuesto());
        return NO_SE_ATRAVIESA_CONTROL_POLICIAL;
    }

    public int atravesarControlPolicial(Aleatorio aleatorio) {
        if(aleatorio.atravesarControlPolicial(CHANCE_CONTROL_POLICIAL)) return PENALIZACION_CONTROL_POLICIAL;
        return NO_SE_PENALIZA;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Robin();
    }

    public String getUrlImagen() {
        return urlImagen;
    }
}
