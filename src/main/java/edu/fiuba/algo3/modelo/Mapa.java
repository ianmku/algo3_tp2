package edu.fiuba.algo3.modelo;


import java.util.Hashtable;

public class Mapa {

//    int ancho;
//    int largo;
    public Hashtable<Posicion, Obstaculo> calles;

    {
        calles = new Hashtable<Posicion, Obstaculo >();
    }

    public Hashtable<Posicion, Vehiculo> callesVehiculo;

    {
        callesVehiculo = new Hashtable<Posicion, Vehiculo>();
    }

    public void guardarObstaculo(Posicion posicion, Obstaculo obstaculo) {
        calles.put(posicion, obstaculo);
    }

    public void atravesarObstaculo(Posicion posicion,Moto moto) {
        //Obstaculo obs = calles.get(vehiculo.getPosicion());
        Obstaculo obs = calles.get(posicion);
        if(obs == null) return;
        obs.penalizarMovimiento(moto);
    }

    public void guardarVehiculo(Posicion posicion, Moto moto) {
        callesVehiculo.put(posicion, moto);
    }

    public void mover(Moto moto, Derecha derecha) {
        Posicion nuevaPosicion = derecha.calcularPosicionSiguiente(moto.getPosicion());
        callesVehiculo.put(nuevaPosicion, moto) ;
        this.atravesarObstaculo(nuevaPosicion,moto);
        moto.cantidadDeMovimientos++;

    }

    /*
    public boolean verCalle(Posicion nuevaPosicion){
        return calles.get(nuevaPosicion) == nuevaPosicion;
    }
*/
    /*public Mapa (TamanioMapa tamanio) {
        switch (tamanio) {
            case CHICO:
                ancho = 7;
                largo = 6;
                break;
            case MEDIANO:
                ancho = 12;
                largo = 11;
                break;
            case GRANDE:
                ancho = 16;
                largo = 15;
                break;
        }
        for (int i=0; i<2*ancho-1; i++) {
            if(i % 2 == 0){
                for (int j=0; j<2*largo-1; j++) {
                    Posicion posicion = new Posicion(i, j);
                    if(j % 2 == 0){
                        Esquina esquina = new Esquina();
                        ht.put(posicion, esquina);
                    }else{
                        Calle calle = new Calle();
                        ht.put(posicion, calle);
                    }
                }
            }
            else{
                for(int j=0; j<2*largo-1; j += 2){
                    Posicion posicion = new Posicion(i, j);
                    Calle calle = new Calle();
                    ht.put(posicion, calle);
                }
            }
        }

    }*/
}
