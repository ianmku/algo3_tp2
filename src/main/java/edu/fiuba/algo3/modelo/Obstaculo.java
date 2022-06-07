package edu.fiuba.algo3.modelo;

import java.util.Random;


public abstract class Obstaculo {
    public bool penalizarVehiculo() {
        return null;
    }
}

public class Pozo implements Obstaculo {

    public bool penalizarVehiculo(Vehiculo vehiculo) {
        if(vehiculo.getTipo() == TipoVehiculo.CPC){
            if(vehiculo.getPozosAtravesados() == 3) vehiculo.aumentarMovimientos(2);
        }
        else{
            vehiculo.aumentarMovimientos(3);
        }
        vehiculo.aumentarPozosAtravesados(1);
        return True;
    }

}

public class Piquete implements Obstaculo {

    public bool penalizarVehiculo(Vehiculo vehiculo) {
        if(vehiculo.getTipo() == TipoVehiculo.MOTO){
            vehiculo.aumentarMovimientos(2);
            return True;
        }
        else{
            return False;
        }
    }
}

public class ControlPolicial implements Obstaculo {

    public bool penalizarVehiculo(Vehiculo vehiculo) {
        Random rand = new Random();
        float random = rand.nextFloat();
        TipoVehiculo tipo = vehiculo.getTipo();
        switch(tipo){
            case MOTO:
                if(random <= 0.8) vehiculo.aumentarMovimientos(3);
                break;
            case AUTO:
                if(random <= 0.5) vehiculo.aumentarMovimientos(3);
                break;
            case CPC:
                if(random < 0.3) vehiculo.aumentarMovimientos(3);
                break;
        }
        return True;
    }

}
