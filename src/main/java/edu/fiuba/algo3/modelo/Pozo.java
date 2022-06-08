package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Pozo implements Obstaculo{
    private Posicion pos;

    public Pozo(Posicion pos){
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozo pozo = (Pozo) o;
        return Objects.equals(pos, pozo.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }

    public penalizarMovimiento(Vehiculo vehiculo){
        if(this.pos.equals(vehiculo.getPosicion));
    }
}
