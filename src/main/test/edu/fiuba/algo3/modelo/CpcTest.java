package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CpcTest {
    @Test
    public void TestCpcRecienCreadaTieneCeroMovimientos() {
        /* Arrange */
        Cpc cuatroPorCuatro = new Cpc(new Mapa());

        /* Act and Assert */
        assertEquals(cuatroPorCuatro.getMovimientos(), 0);
    }

    @Test
    public void TestCpcMoverModificaSuPosicion() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Cpc cuatroPorCuatro = new Cpc(mapa);
        Posicion destino = new Posicion(3, 1);

        /* Act */
        cuatroPorCuatro.mover(new Derecha());

        /* Assert */
        assertEquals(cuatroPorCuatro.getPosicion(), destino);
    }

    @Test
    public void TestCpcAtravesarUnPozoNoAumentaSusMovimientos() {
        /* Arrange */
        Cpc cuatroPorCuatro = new Cpc(new Mapa());

        /* Act */
        cuatroPorCuatro.atravesarPozo();

        /* Assert */
        assertEquals(cuatroPorCuatro.getMovimientos(), 0);
    }

    @Test
    public void TestCpcAtravesarTresPozosAumentaSusMovimientos() {
        /* Arrange */
        Cpc cuatroPorCuatro = new Cpc(new Mapa());

        /* Act */
        cuatroPorCuatro.atravesarPozo();
        cuatroPorCuatro.atravesarPozo();
        cuatroPorCuatro.atravesarPozo();

        /* Assert */
        assertEquals(cuatroPorCuatro.getMovimientos(), 2);
    }

    @Test
    public void TestCpcAtravesarPiqueteNoAumentaSusMovimientos() {
        /* Arrange */
        Cpc cuatroPorCuatro = new Cpc(new Mapa());

        /* Act */
        cuatroPorCuatro.atravesarPiquete();

        /* Assert */
        assertEquals(cuatroPorCuatro.getMovimientos(), 0);
    }
}
