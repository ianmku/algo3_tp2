package edu.fiuba.algo3.modelo.VehiculoTest;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoTest {

    @Test
    public void TestAutoRecienCreadoTieneCeroMovimientos() {
        /* Arrange */
        Vehiculo auto = new Vehiculo(new Mapa(), new Auto());

        /* Act and Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

    @Test
    public void TestAutoMoverModificaSuPosicion() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Vehiculo auto = new Vehiculo(new Mapa(), new Auto());
        Posicion destino = new Posicion(3, 1);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(auto.getPosicion(), destino);
    }

    @Test
    public void TestAutoAtravesarPozoAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo auto = new Vehiculo(new Mapa(), new Auto());

        /* Act */
        auto.atravesarPozo();

        /* Assert */
        assertEquals(auto.getMovimientos(), 3);
    }

    @Test
    public void TestAutoAtravesarPiqueteNoAumentaUnMovimientos() {
        /* Arrange */
        Vehiculo auto = new Vehiculo(new Mapa(), new Auto());

        /* Act */
        auto.atravesarPiquete();

        /* Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

}
