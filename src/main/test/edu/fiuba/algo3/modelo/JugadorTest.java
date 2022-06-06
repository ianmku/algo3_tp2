package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test

    public void jugadorRecienCreadoTieneUnNombre() {
        Jugador unJugador = new Jugador("Claudio");
        assertEquals("Claudio", unJugador.getNombre());
    }
}
