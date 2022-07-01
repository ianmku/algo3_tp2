package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Escenario.Calle;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Interactuables.Piquete;
import edu.fiuba.algo3.modelo.Interactuables.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.Interactuables.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.Interactuables.SorpresaFavorable;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega2Test {

    @Test
    public void vehiculoEncuentraSorpresaFavorable() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.MEDIANO, aleatorio);
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = (int) (10 * 0.8);

        SorpresaFavorable sorpresa = new SorpresaFavorable();
        calle.guardarInteractuable(sorpresa);
        mapa.guardarCalle(new Posicion(3,7), calle);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());
        mapa.moverVehiculo(moto, new Derecha());
        mapa.moverVehiculo(moto, new Arriba());
        mapa.moverVehiculo(moto, new Abajo());
        mapa.moverVehiculo(moto, new Izquierda());
        mapa.moverVehiculo(moto, new Abajo());
        mapa.moverVehiculo(moto, new Izquierda());
        mapa.moverVehiculo(moto, new Arriba());
        mapa.moverVehiculo(moto, new Arriba());
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());
    }

    @Test
    public void vehiculoEncuentraSorpresaDesfavorable() {
        /* Arrange */

        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.MEDIANO, aleatorio);
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        int movimientosEsperados = (int) (10 * 1.25);

        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        calle.guardarInteractuable(sorpresa);
        mapa.guardarCalle(new Posicion(3,7), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());
        mapa.moverVehiculo(auto, new Derecha());
        mapa.moverVehiculo(auto, new Arriba());
        mapa.moverVehiculo(auto, new Abajo());
        mapa.moverVehiculo(auto, new Izquierda());
        mapa.moverVehiculo(auto, new Abajo());
        mapa.moverVehiculo(auto, new Izquierda());
        mapa.moverVehiculo(auto, new Arriba());
        mapa.moverVehiculo(auto, new Arriba());
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void vehiculoEncuentraSorpresaCambioDeVehiculo() {

        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle = new Calle();
        Vehiculo vehiculo = new Vehiculo(mapa, new Auto());
        Tipo tipoEsperado = new Camioneta();

        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        calle.guardarInteractuable(sorpresa);
        mapa.guardarCalle(new Posicion(3,3), calle);

        /* Act */
        mapa.moverVehiculo(vehiculo, new Derecha());
        mapa.moverVehiculo(vehiculo, new Derecha());

        /* Assert */
        assertTrue(vehiculo.es(tipoEsperado));
    }

    @Test
    public void motoEncuentraSorpresaCambioDeVehiculo() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Vehiculo vehiculo = new Vehiculo(mapa, new Auto());
        Tipo tipoEsperado = new Moto();

        SorpresaCambioVehiculo sorpresa1 = new SorpresaCambioVehiculo();
        SorpresaCambioVehiculo sorpresa2 = new SorpresaCambioVehiculo();
        calle1.guardarInteractuable(sorpresa1);
        calle2.guardarInteractuable(sorpresa2);
        mapa.guardarCalle(new Posicion(3,2), calle1);
        mapa.guardarCalle(new Posicion(5,2), calle2);

        /* Act */
        mapa.moverVehiculo(vehiculo, new Derecha());
        mapa.moverVehiculo(vehiculo, new Derecha());

        /* Assert */
        assertTrue(vehiculo.es(tipoEsperado));
    }

    @Test
    public void camionetaCambiaAMotoYAtraviesaPiquete() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Vehiculo vehiculo = new Vehiculo(mapa, new Camioneta());
        Posicion posicionEsperada = new Posicion(6, 3);

        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        Piquete piquete = new Piquete();
        calle1.guardarInteractuable(sorpresa);
        calle2.guardarInteractuable(piquete);
        mapa.guardarCalle(new Posicion(3,3), calle1);
        mapa.guardarCalle(new Posicion(5,3), calle2);

        /* Act */
        mapa.moverVehiculo(vehiculo, new Derecha());
        mapa.moverVehiculo(vehiculo, new Derecha());

        /* Assert */
        assertEquals(vehiculo.getPosicion(), posicionEsperada);
    }

}
