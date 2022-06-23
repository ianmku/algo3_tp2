package edu.fiuba.algo3.modelo.DireccionTest;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerechaTest {

    @Test
    public void testCalcularPosicionSiguiente() {

        /* Arrange */
        Derecha derecha = new Derecha();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(2, 1);

        /* Act */
        derecha.calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);

    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Derecha derecha = new Derecha();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(0, 1);

        /* Act */
        derecha.opuesto().calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);
    }
}
