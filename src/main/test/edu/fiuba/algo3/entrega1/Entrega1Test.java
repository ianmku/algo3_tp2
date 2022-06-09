package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        Auto auto = new Auto(new Posicion(1,1));
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo(new Posicion(2,1));

        /* Act */
        auto.mover(new Derecha());

        pozo.penalizarMovimiento(auto);

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        Cpc cpc = new Cpc(new Posicion(1,1));
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo(new Posicion(1,2));

        /* Act */
        cpc.mover(new Derecha());

        pozo.penalizarMovimiento(cpc);

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());

    }

    //caso de uso 4
    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaTresMovimientos(){
        /* Arrange */
        Moto moto = new Moto(new Posicion(1,1));
        int movimientosEsperados = 3;

        Piquete piquete = new Piquete(new Posicion(1,2));

        /* Act */
        moto.mover(new Derecha());

        piquete.penalizarMovimiento(moto);

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }


}
