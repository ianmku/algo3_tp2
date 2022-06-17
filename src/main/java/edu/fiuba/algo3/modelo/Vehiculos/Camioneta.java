package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Camioneta implements Tipo {

    //private Vehiculo vehiculo;
    int cantidadDePozosAtravesados;

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
        return 0;
    }

    public int atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.3) return 3;
        return 0;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Moto();
    }


}
