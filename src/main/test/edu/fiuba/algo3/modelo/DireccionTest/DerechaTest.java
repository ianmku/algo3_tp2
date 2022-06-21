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
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(2, 1);

        /* Act */
        Posicion posFinal = derecha.calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);

    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Derecha derecha = new Derecha();
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(0, 1);

        /* Act */
        Posicion posFinal = derecha.opuesto().calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);
    }
}
