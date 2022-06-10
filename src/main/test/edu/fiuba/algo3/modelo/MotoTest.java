package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {

    @Test
    public void TestMotoRecienCreadaTieneCeroMovimientos() {
        /* Arrange */
        Moto moto = new Moto(new Posicion(0,0));

        /* Act and Assert */
        assertEquals(moto.getMovimientos(), 0);
    }

    @Test
    public void TestMotoMoverModificaSuPosicion() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Moto moto = new Moto(new Posicion(0,0));
        Posicion destino = new Posicion(2, 0);

        /* Act */
        moto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(moto.pos, destino);
    }

    @Test
    public void TestMotoAtravesarPozoAumentaSusMovimientos() {
        /* Arrange */
        Moto moto = new Moto(new Posicion(0,0));

        /* Act */
        moto.atravesarPozo();

        /* Assert */
        assertEquals(moto.getMovimientos(), 3);
    }

    @Test
    public void TestMotoAtravesarPiqueteAumentaSusMovimientos() {
        /* Arrange */
        Moto moto = new Moto(new Posicion(0, 0));

        /* Act */
        moto.atravesarPiquete();

        /* Assert */
        assertEquals(moto.getMovimientos(), 2);
    }

}
