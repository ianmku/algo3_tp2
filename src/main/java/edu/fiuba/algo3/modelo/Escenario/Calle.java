package edu.fiuba.algo3.modelo.Escenario;

import edu.fiuba.algo3.modelo.Interactuables.Interactuable;
import edu.fiuba.algo3.modelo.Interactuables.Obstaculo;
import edu.fiuba.algo3.modelo.Interactuables.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Calle {

    private List<Interactuable> interactuables;

    public Calle() {
        interactuables = new ArrayList<>();
    }

    public void guardarInteractuable(Interactuable interactuable) {
        interactuables.add(interactuable);
    }

    public void atravesarCalle(Vehiculo vehiculo) {
        for(Interactuable i: interactuables){
            i.interactuarConVehiculo(vehiculo);
        }
    }
}