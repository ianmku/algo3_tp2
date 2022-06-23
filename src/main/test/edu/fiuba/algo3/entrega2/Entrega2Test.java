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

public class Entrega2Test {

    @Test
    public void vehiculoEncuentraSorpresaFavorable() {
        /* Arrange */
        Mapa mapa = new Mapa(TamanioMapa.MEDIANO, new Aleatorio());
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = (int) (10 * 0.8);

        SorpresaFavorable sorpresa = new SorpresaFavorable();
        calle.guardarInteractuable(sorpresa);
        mapa.guardarCalle(new Posicion(4,1), calle);

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
        Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        int movimientosEsperados = (int) (2 * 1.25);

        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        calle.guardarInteractuable(sorpresa);
        mapa.guardarCalle(new Posicion(4,1), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void vehiculoEncuentraSorpresaCambioDeVehiculo() {
        Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
        Calle calle = new Calle();
        Vehiculo vehiculo = new Vehiculo(mapa, new Auto());
        Tipo tipoEsperado = new Camioneta();

        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        calle.guardarInteractuable(sorpresa);
        mapa.guardarCalle(new Posicion(4,1), calle);

        /* Act */
        mapa.moverVehiculo(vehiculo, new Derecha());
        mapa.moverVehiculo(vehiculo, new Derecha());

        /* Assert */
        assertTrue(vehiculo.es(tipoEsperado));
    }

    @Test
    public void motoEncuentraSorpresaCambioDeVehiculo() {
        /* Arrange */
        Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Vehiculo vehiculo = new Vehiculo(mapa, new Auto());
        Tipo tipoEsperado = new Moto();

        SorpresaCambioVehiculo sorpresa1 = new SorpresaCambioVehiculo();
        SorpresaCambioVehiculo sorpresa2 = new SorpresaCambioVehiculo();
        calle1.guardarInteractuable(sorpresa1);
        calle2.guardarInteractuable(sorpresa2);
        mapa.guardarCalle(new Posicion(2,1), calle1);
        mapa.guardarCalle(new Posicion(4,1), calle2);

        /* Act */
        mapa.moverVehiculo(vehiculo, new Derecha());
        mapa.moverVehiculo(vehiculo, new Derecha());

        /* Assert */
        assertTrue(vehiculo.es(tipoEsperado));
    }

    @Test
    public void camionetaCambiaAMotoYAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Vehiculo vehiculo = new Vehiculo(mapa, new Camioneta());
        Posicion posicionEsperada = new Posicion(5, 1);

        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        Piquete piquete = new Piquete();
        calle1.guardarInteractuable(sorpresa);
        calle2.guardarInteractuable(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle1);
        mapa.guardarCalle(new Posicion(4,1), calle2);

        /* Act */
        mapa.moverVehiculo(vehiculo, new Derecha());
        mapa.moverVehiculo(vehiculo, new Derecha());

        /* Assert */
        assertEquals(vehiculo.getPosicion(), posicionEsperada);
    }

}
