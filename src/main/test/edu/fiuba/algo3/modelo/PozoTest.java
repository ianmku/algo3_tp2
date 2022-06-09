package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {

    @Test
    public void TestPenalizarMovmientoAMoto() {
        /* Arrange */
        Pozo pozo = new Pozo(new Posicion(0, 0));
        Moto moto = new Moto(new Posicion(0, 0));

        /* Act */
        pozo.penalizarMovimiento(moto);

        /* Assert */
        assertEquals(moto.getMovimientos(), 3);

    }

    @Test
    public void TestPenalizarMovmientoAAuto() {
        /* Arange */
        Pozo pozo = new Pozo(new Posicion(0, 0));
        Auto auto = new Auto(new Posicion(0, 0));

        /* Act */
        pozo.penalizarMovimiento(auto);

        /* Assert */
        assertEquals(auto.getMovimientos(), 3);
    }

    @Test
    public void TestPenalizarMovmientoACpcQueNoEncontroPozos() {
        /* Arange */
        Pozo pozo = new Pozo(new Posicion(0, 0));
        Cpc cuatroPorCuatro = new Cpc(new Posicion(0, 0));

        /* Act */
        pozo.penalizarMovimiento(cuatroPorCuatro);

        /* Assert */
        assertEquals(cuatroPorCuatro.getMovimientos(), 0);
    }

    @Test
    public void testPenalizarMovimientoTresVecesACpc() {
        /* Arange */
        Pozo pozo = new Pozo(new Posicion(0, 0));
        Cpc cuatroPorCuatro = new Cpc(new Posicion(0, 0));

        /* Act */
        pozo.penalizarMovimiento(cuatroPorCuatro);
        pozo.penalizarMovimiento(cuatroPorCuatro);
        pozo.penalizarMovimiento(cuatroPorCuatro);

        /* Assert */
        assertEquals(cuatroPorCuatro.getMovimientos(), 2);
    }
}
