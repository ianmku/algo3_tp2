package edu.fiuba.algo3.modelo;


import java.util.Hashtable;

public class Mapa {

    int ancho;
    int largo;
    private Posicion posicionDelVehiculo;
    private Posicion ultimaPosicion;
    private Posicion Llegada;
    private Hashtable<Posicion, Calle> calles;

    {
        calles = new Hashtable<Posicion, Calle>();
        posicionDelVehiculo = new Posicion(1,1);
    }

    public void guardarCalle(Posicion posicion, Calle calle) {
        calles.put(posicion, calle);
    }

    public void guardarSorpresa(Posicion posicion, Sorpresa sorpresa) {
        Calle calle = calles.get(posicion);
        calle.guardarSorpresa(sorpresa);
    }

    public boolean vehiculoEstaEnLlegada(){
        return (this.posicionDelVehiculo.equals(this.Llegada));
    }

    public void moverVehiculo(Vehiculo vehiculo, Direccion direccion){
        posicionDelVehiculo = direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        Calle calle = calles.get(posicionDelVehiculo);
        if(calle != null){
            calle.atravesarCalle(vehiculo);
        }
        posicionDelVehiculo = direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        vehiculo.aumentarMovimientos(1);
    }

//    public void atravesarCalle(Vehiculo vehiculo) {
//        Calle calle = calles.get(posicionDelVehiculo);
//        if(calle == null) return;
//        calle.penalizarMovimiento(vehiculo);
//    }

    public Posicion getPosicionDelVehiculo(){
        return this.posicionDelVehiculo;
    }

    public Mapa(){
        this.ancho = 10;
        this.largo = 10;
        this.posicionDelVehiculo = new Posicion(1,5);
        this.Llegada = new Posicion(9,5);


    }

    public void imprimirPosicion(){
        this.posicionDelVehiculo.imprimirPosicion();
    }

//    public Mapa () {
//        ancho = 12;
//        largo = 11;
//        switch (tamanio) {
//            case CHICO:
//                ancho = 7;
//                largo = 6;
//                break;
//            case MEDIANO:
//                ancho = 12;
//                largo = 11;
//                break;
//            case GRANDE:
//                ancho = 16;
//                largo = 15;
//                break;
//        }
        //int controlesPoliciales = 12;
        //int piquetes = 12;
        //int pozos = 15;
        //int sorpresas = 18;

//        for (int i=0; i<2*ancho-1; i++) {
//            if(i % 2 == 0){
//                for (int j=0; j<2*largo-1; j++) {
//                    Posicion posicion = new Posicion(i, j);
//                    if(j % 2 == 0){
//                        Esquina esquina = new Esquina();
//                        ht.put(posicion, esquina);
//                    }else{
//                        Calle calle = new Calle();
//                        ht.put(posicion, calle);
//                    }
//                }
//            }
//            else{
//                for(int j=0; j<2*largo-1; j += 2){
//                    Posicion posicion = new Posicion(i, j);
//                    Calle calle = new Calle();
//                    ht.put(posicion, calle);
//                }
//            }
//        }
//
//    }
}
