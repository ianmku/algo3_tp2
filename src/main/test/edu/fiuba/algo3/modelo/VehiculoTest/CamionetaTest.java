package edu.fiuba.algo3.modelo.VehiculoTest;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamionetaTest {
    @Test
    public void TestCamionetaRecienCreadaTieneCeroMovimientos() {
        /* Arrange */
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());

        /* Act and Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }

    @Test
    public void TestCamionetaMoverModificaSuPosicion() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());
        Posicion destino = new Posicion(3, 1);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(camioneta.getPosicion(), destino);
    }

    @Test
    public void TestCamionetaAtravesarUnPozoNoAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());

        /* Act */
        camioneta.atravesarPozo();

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }

    @Test
    public void TestCamionetaAtravesarTresPozosAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());

        /* Act */
        camioneta.atravesarPozo();
        camioneta.atravesarPozo();
        camioneta.atravesarPozo();

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 2);
    }

    @Test
    public void TestCamionetaAtravesarPiqueteNoAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());

        /* Act */
        camioneta.atravesarPiquete();

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }
}
