package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
<<<<<<< HEAD
import static org.mockito.Mockito.*;

public class Entrega1Test {


=======

public class Entrega1Test {

>>>>>>> origin/desarrollo
    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Moto moto = new Moto(new Posicion(1,1));
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

        /* Act */
        moto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Auto auto = new Auto(new Posicion(1,1));
        int movimientosEsperados = 4;
        Pozo pozo = new Pozo();
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

        /* Act */
        auto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        Mapa mapa = new Mapa();
        Cpc cpc = new Cpc(new Posicion(1,1));
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo();
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

        /* Act */
        cpc.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());

    }
<<<<<<< HEAD

    //caso de uso 4
=======
>>>>>>> origin/desarrollo
    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaDosMovimientos(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Moto moto = new Moto(new Posicion(1,1));
        int movimientosEsperados = 3;
        Piquete piquete = new Piquete();
        mapa.guardarObstaculo(new Posicion(2,1), piquete);

        /* Act */
        moto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

<<<<<<< HEAD
=======
    @Test
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Cpc cpc = new Cpc(new Posicion(1,1));
        int movimientosEsperados = 5;

        Pozo pozo1 = new Pozo();
        Pozo pozo2 = new Pozo();
        Pozo pozo3 = new Pozo();

        mapa.guardarObstaculo(new Posicion(2,1), pozo1);
        mapa.guardarObstaculo(new Posicion(4,1), pozo2);
        mapa.guardarObstaculo(new Posicion(6,1), pozo3);

        /* Act */
        cpc.mover(mapa, new Derecha());

        cpc.mover(mapa, new Derecha());

        cpc.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());
    }
>>>>>>> origin/desarrollo

    @Test
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Posicion inicio = new Posicion(1, 1);
        Auto auto = new Auto(inicio);

        Piquete piquete = new Piquete();
        mapa.guardarObstaculo(new Posicion(2, 1), piquete);

        /* Act */
        auto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(auto.getPosicion(), inicio);
    }

}
