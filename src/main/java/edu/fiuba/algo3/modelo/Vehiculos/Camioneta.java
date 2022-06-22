package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Camioneta implements Tipo {

    private final float CHANCE_CONTROL_POLICIAL = 0.3F;
    private int cantidadDePozosAtravesados;

    public Camioneta(){
        this.cantidadDePozosAtravesados = 0;
    }

    public int atravesarPozo(){
        this.cantidadDePozosAtravesados++;
        if((this.cantidadDePozosAtravesados % 3) == 0){
            return 2;
        }
        return 0;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo) {
        mapa.moverVehiculo(vehiculo, direccion.opuesto());
        return -1;
    }

    public int atravesarControlPolicial() {
        Aleatorio random = new Aleatorio();
        if(random.atravesarControlPolicial(CHANCE_CONTROL_POLICIAL)) return 3;
        return 0;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Moto();
    }


}
