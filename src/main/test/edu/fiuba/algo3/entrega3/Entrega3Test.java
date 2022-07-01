package edu.fiuba.algo3.entrega3;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Abajo;
import edu.fiuba.algo3.modelo.Direcciones.Arriba;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Calle;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Interactuables.*;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega3Test {
    @Test
    public void partidaCompleta(){
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(any(int.class),any(int.class))).thenReturn(new Posicion(0, 0));

        when(aleatorio.atravesarControlPolicial(any(float.class))).thenReturn(true);

        when(aleatorio.generarPosicionDeLlegada(anyInt(), anyInt())).thenReturn(new Posicion(6,6));

        int movimientosEsperados = (int)((4 + 3 + 3 + 2) * 1.25);
        Posicion posicionFinal = new Posicion(6,6);

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle1 = new Calle();
        calle1.guardarInteractuable(new ControlPolicial(aleatorio));
        calle1.guardarInteractuable(new Piquete());
        mapa.guardarCalle(new Posicion(3,6), calle1);

        Calle calle2 = new Calle();
        calle2.guardarInteractuable(new SorpresaCambioVehiculo());
        mapa.guardarCalle(new Posicion(4,5), calle2);

        Calle calle3 = new Calle();
        calle3.guardarInteractuable(new Pozo());
        mapa.guardarCalle(new Posicion(5,4), calle3);

        Calle calle4 = new Calle();
        calle4.guardarInteractuable(new SorpresaDesfavorable());
        mapa.guardarCalle(new Posicion(6,5), calle4);


        Vehiculo vehiculo = new Vehiculo(mapa, new Moto());
        Jugador unJugador = new Jugador("Jugador1",vehiculo);

        unJugador.moverVehiculo(new Derecha());
        unJugador.moverVehiculo(new Abajo());
        unJugador.moverVehiculo(new Derecha());
        unJugador.moverVehiculo(new Arriba());

        assertEquals(movimientosEsperados, unJugador.obtenerCantidadMovimientos());
        assertEquals(posicionFinal, vehiculo.getPosicion());
        assertTrue(mapa.vehiculoEstaEnLlegada());
    }
}
