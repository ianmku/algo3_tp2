package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {

    @Test
    public void TestPenalizarMovimientoAMoto() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Moto moto = new Moto(new Mapa());

        /* Act */
        piquete.penalizarMovimiento(moto);

        /* Assert */
        assertEquals(moto.getMovimientos(), 2);
    }

    @Test
    public void TestPenalizarMovimientoAAuto() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Auto auto = new Auto(new Mapa());

        /* Act */
        piquete.penalizarMovimiento(auto);

        /* Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

    @Test
    public void TestPenalizarMovimientoACpc() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Cpc cuatroPorCuatro = new Cpc(new Mapa());

        /* Act */
        piquete.penalizarMovimiento(cuatroPorCuatro);

        /* Assert */
        assertEquals(cuatroPorCuatro.getMovimientos(), 0);
    }
}
