package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {

    @Test
    public void TestMotoRecienCreadaTieneCeroMovimientos() {
        /* Arrange */
        Vehiculo moto = new Vehiculo(new Mapa(), new Moto());

        /* Act and Assert */
        assertEquals(moto.getMovimientos(), 0);
    }

    @Test
    public void TestMotoMoverModificaSuPosicion() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Vehiculo moto = new Vehiculo(new Mapa(), new Moto());
        Posicion destino = new Posicion(3, 1);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(moto.getPosicion(), destino);
    }

    @Test
    public void TestMotoAtravesarPozoAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo moto = new Vehiculo(new Mapa(), new Moto());

        /* Act */
        moto.atravesarPozo();

        /* Assert */
        assertEquals(moto.getMovimientos(), 3);
    }

    @Test
    public void TestMotoAtravesarPiqueteAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo moto = new Vehiculo(new Mapa(), new Moto());

        /* Act */
        moto.atravesarPiquete();

        /* Assert */
        assertEquals(moto.getMovimientos(), 2);
    }

}
