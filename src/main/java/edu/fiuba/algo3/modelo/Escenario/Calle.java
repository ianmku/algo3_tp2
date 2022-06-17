package edu.fiuba.algo3.modelo.Escenario;

import edu.fiuba.algo3.modelo.Interactuables.Interactuable;
import edu.fiuba.algo3.modelo.Interactuables.Obstaculo;
import edu.fiuba.algo3.modelo.Interactuables.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Calle {

    private boolean tieneObstaculo = false;
    private boolean tieneSorpresa = false;

    private List<Interactuable> interactuables;

    public Calle() {
        interactuables = new ArrayList<>();
    }

    public void guardarObstaculo(Obstaculo unObstaculo) {
        if(!tieneObstaculo){
            interactuables.add(unObstaculo);
            tieneObstaculo = true;
        }
    }

    public void guardarSorpresa(Sorpresa unaSorpresa) {
        if(!tieneObstaculo){
            interactuables.add(unaSorpresa);
            tieneSorpresa = true;
        }
    }

    public void atravesarCalle(Vehiculo vehiculo) {
        for(Interactuable i: interactuables){
            i.interactuarConVehiculo(vehiculo);
        }
    }
}