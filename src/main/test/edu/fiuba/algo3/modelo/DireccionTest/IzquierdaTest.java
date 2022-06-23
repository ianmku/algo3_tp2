package edu.fiuba.algo3.modelo.DireccionTest;

import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IzquierdaTest {

    @Test
    public void testCalcularPosicionSiguiente() {

        /* Arrange */
        Izquierda izquierda = new Izquierda();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(0, 1);

        /* Act */
        izquierda.calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);

    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Izquierda izquierda = new Izquierda();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(2, 1);

        /* Act */
        izquierda.opuesto().calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);
    }
}