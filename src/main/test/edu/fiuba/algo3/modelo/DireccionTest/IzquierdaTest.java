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
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(0, 1);

        /* Act */
        Posicion posFinal = izquierda.calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);

    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Izquierda izquierda = new Izquierda();
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(2, 1);

        /* Act */
        Posicion posFinal = izquierda.opuesto().calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);
    }
}