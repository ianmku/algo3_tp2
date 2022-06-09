package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Moto moto = new Moto(new Posicion(1,1));
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo(new Posicion(2,1));

        /* Act */
        moto.mover(new Derecha());
        pozo.penalizarMovimiento(moto);

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());
    }
    @Test
    public void unAutoAtraviezaLaCiudadYSeEncuebntraConUnpozoSePenalizaConTresMovimientos(){
        /* Arrange */
        Auto auto = new Auto(new Posicion( 1,1 ));
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo(new Posicion(2,1));

        /* Act */
        auto.mover(new Derecha());
        pozo.penalizarMovimiento(auto);
        /* Assert */

        assertEquals(movimientosEsperados, auto.getMovimientos());
    }
}
