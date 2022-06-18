package edu.fiuba.algo3.modelo.InteractuableTest;

import edu.fiuba.algo3.modelo.Escenario.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {

    @Test
    public void PosicionesConMismasCoordenadasSonIguales() {

        /* Arrange */
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1,1);

        /* Act and Assert */
        assertEquals(pos1, pos2);
    }
}
