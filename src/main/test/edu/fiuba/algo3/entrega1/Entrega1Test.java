package edu.fiuba.algo3.entrega1;

<<<<<<<<< Temporary merge branch 1
import edu.fiuba.algo3.modelo.*;
=========
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Calle;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Interactuables.Piquete;
import edu.fiuba.algo3.modelo.Interactuables.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
>>>>>>>>> Temporary merge branch 2
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
<<<<<<<<< Temporary merge branch 1
        Moto moto = new Moto(mapa);
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

        /* Act */
        moto.mover(new Derecha());
=========
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());
>>>>>>>>> Temporary merge branch 2

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
<<<<<<<<< Temporary merge branch 1
        Auto auto = new Auto(mapa);
        int movimientosEsperados = 4;
        Pozo pozo = new Pozo();
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

        /* Act */
        auto.mover(new Derecha());
=========
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());
>>>>>>>>> Temporary merge branch 2

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        Mapa mapa = new Mapa();
<<<<<<<<< Temporary merge branch 1
        Cpc cpc = new Cpc(mapa);
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo();
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

        /* Act */
        cpc.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());
=========
        Calle calle = new Calle();
        Vehiculo camioneta = new Vehiculo(mapa, new Camioneta());
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());
>>>>>>>>> Temporary merge branch 2

    }

    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaDosMovimientos(){
        /* Arrange */
        Mapa mapa = new Mapa();
<<<<<<<<< Temporary merge branch 1
        Moto moto = new Moto(mapa);
        int movimientosEsperados = 3;
        Piquete piquete = new Piquete();
        mapa.guardarObstaculo(new Posicion(2,1), piquete);

        /* Act */
        moto.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Cpc cpc = new Cpc(mapa);
        int movimientosEsperados = 5;

        Pozo pozo1 = new Pozo();
        Pozo pozo2 = new Pozo();
        Pozo pozo3 = new Pozo();
=========
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = 3;

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());
>>>>>>>>> Temporary merge branch 2

        mapa.guardarObstaculo(new Posicion(2,1), pozo1);
        mapa.guardarObstaculo(new Posicion(4,1), pozo2);
        mapa.guardarObstaculo(new Posicion(6,1), pozo3);

        /* Act */
        cpc.mover(new Derecha());

        cpc.mover(new Derecha());

        cpc.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());
    }
    @Test
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        Posicion inicio = new Posicion(1, 1);

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(mapa.getPosicionDelVehiculo(), inicio);
    }


    @Test
<<<<<<<<< Temporary merge branch 1
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Posicion inicio = new Posicion(1, 1);
        Auto auto = new Auto(mapa);

        Piquete piquete = new Piquete();
        mapa.guardarObstaculo(new Posicion(2, 1), piquete);

        /* Act */
        auto.mover(new Derecha());

        /* Assert */
        assertEquals(auto.getPosicion(), inicio);
    }

=========
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Calle calle3 = new Calle();
        Vehiculo camioneta = new Vehiculo(mapa, new Camioneta());
        int movimientosEsperados = 5;

        Pozo pozo1 = new Pozo();
        calle1.guardarObstaculo(pozo1);
        Pozo pozo2 = new Pozo();
        calle2.guardarObstaculo(pozo2);
        Pozo pozo3 = new Pozo();
        calle3.guardarObstaculo(pozo3);

        mapa.guardarCalle(new Posicion(2,1), calle1);
        mapa.guardarCalle(new Posicion(4,1), calle2);
        mapa.guardarCalle(new Posicion(6,1), calle3);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        mapa.moverVehiculo(camioneta, new Derecha());

        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());
    }


>>>>>>>>> Temporary merge branch 2
}
