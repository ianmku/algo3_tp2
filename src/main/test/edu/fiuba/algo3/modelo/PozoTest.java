package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {

    @Test
    public void TestPenalizarMovimientoAMoto() {
        /* Arrange */
        Pozo pozo = new Pozo();
        Moto moto = new Moto(new Mapa());

        /* Act */
        pozo.penalizarMovimiento(moto);

        /* Assert */
        assertEquals(moto.getMovimientos(), 3);

    }

    @Test
    public void TestPenalizarMovmientoAAuto() {
        /* Arange */
        Pozo pozo = new Pozo();
        Auto auto = new Auto(new Mapa());

        /* Act */
        pozo.penalizarMovimiento(auto);

        /* Assert */
        assertEquals(auto.getMovimientos(), 3);
    }

    @Test
    public void TestPenalizarMovmientoACpcQueNoEncontroPozos() {
        /* Arange */
        Pozo pozo = new Pozo();
        Camioneta camioneta = new Camioneta(new Mapa());

        /* Act */
        pozo.penalizarMovimiento(camioneta);

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }

    @Test
    public void testPenalizarMovimientoTresVecesACamioneta() {
        /* Arange */
        Pozo pozo = new Pozo();
        Camioneta camioneta = new Camioneta(new Mapa());

        /* Act */
        pozo.penalizarMovimiento(camioneta);
        pozo.penalizarMovimiento(camioneta);
        pozo.penalizarMovimiento(camioneta);

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 2);
    }
}
