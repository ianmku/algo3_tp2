package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoTest {

    @Test
    public void TestAutoRecienCreadoTieneCeroMovimientos() {
        /* Arrange */
        Auto auto = new Auto(new Posicion(0,0));

        /* Act and Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

    @Test
    public void TestAutoMoverModificaSuPosicion() {
        /* Arrange */
        Auto auto = new Auto(new Posicion(0,0));
        Posicion destino = new Posicion(1, 0);

        /* Act */
        auto.mover(new Derecha());

        /* Assert */
        assertEquals(auto.pos, destino);
    }

    @Test
    public void TestAutoAtravesarPozoAumentaSusMovimientos() {
        /* Arrange */
        Auto auto = new Auto(new Posicion(0,0));

        /* Act */
        auto.atravesarPozo();

        /* Assert */
        assertEquals(auto.getMovimientos(), 3);
    }

    @Test
    public void TestAutoAtravesarPiqueteNoAumentaSusMovimientos() {
        /* Arrange */
        Auto auto = new Auto(new Posicion(0, 0));

        /* Act */
        auto.atravesarPiquete();

        /* Assert */
        assertEquals(auto.getMovimientos(), 0);
    }
}
