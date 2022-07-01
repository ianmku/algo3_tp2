package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.MapaControlador;
import edu.fiuba.algo3.controladores.VehiculoControlador;
import edu.fiuba.algo3.modelo.Escenario.Calle;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Interactuables.ControlPolicial;
import edu.fiuba.algo3.modelo.Interactuables.Piquete;
import edu.fiuba.algo3.modelo.Interactuables.Pozo;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Interactuables.Interactuable;
import java.util.Map.Entry;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.ImageInput;
import javafx.scene.layout.HBox;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Hashtable;

public class MapaVista extends StackPane {
    private final MapaControlador controlador;
    private int vehiculoX = 2;
    private int vehiculoY;
    private int altoMapa;
    public MapaVista(Juego juego, MapaControlador mapaControlador){

        this.controlador = mapaControlador;

        int anchoMapa = juego.getAnchoMapa();
        this.altoMapa = juego.getAltoMapa();

        GridPane mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);
        mapa.setPrefWidth(640);
        mapa.setPrefHeight(520);

        GridPane mapaOscuro = new GridPane();
        mapaOscuro.setAlignment(Pos.CENTER);
        mapaOscuro.setPrefWidth(640);
        mapaOscuro.setPrefHeight(520);


        for(int i=0; i < anchoMapa; i++){
            for(int j=0; j < this.altoMapa; j++){
                var rectangulo = new Rectangle();
                if((i%2 != 0) && (j%2 != 0)){
                    rectangulo.setFill(Color.GREY);
                }
                else{
                    rectangulo.setFill(Color.WHITE);
                }
                rectangulo.setHeight(50);
                rectangulo.setWidth(50);
                mapa.add(rectangulo,i,j);

                var rectanguloNegro = new Rectangle();
                rectanguloNegro.setFill(Color.BLACK);
                rectanguloNegro.setWidth(50);
                rectanguloNegro.setHeight(50);
                mapaOscuro.add(rectanguloNegro,i,j);
            }
        }

        Image imagenLlegada = new Image("https://i.pinimg.com/564x/f9/60/6b/f9606ba052600841c02b9a96e357841e.jpg");
        ImageView llegada = new ImageView(imagenLlegada);
        llegada.setFitWidth(39);
        llegada.setFitHeight(39);

        mapa.add(llegada, juego.posicionDeLlegada().getPosicionX(), juego.getMapaActual().getAlto() - juego.posicionDeLlegada().getPosicionY());

        VehiculoVista vehiculoVista = new VehiculoVista(juego, new VehiculoControlador());
        Vehiculo vehiculo = juego.getJugadorActual().obtenerVehiculo();
        vehiculo.addObserver(vehiculoVista);
        this.vehiculoY = ((this.altoMapa - 1) / 2 ) - 1;
        mapa.add(vehiculoVista, this.vehiculoX, invertirY(this.vehiculoY));


        GridPane botones = this.botonesDeDireccion(mapaOscuro, vehiculoVista);

        Hashtable<Posicion, Calle> hash = juego.getMapaActual().obtenerCalles();

        for (Entry<Posicion, Calle> entry : hash.entrySet()){
            Posicion posicion = entry.getKey();
            Calle calle = entry.getValue();
            var contenedorInteractuables = new VBox();
            var contenedor1 = new HBox();
            var contenedor2 = new HBox();

            for(Interactuable i: calle.getInteractuables()){
                ImageView imgInteractuable = new ImageView(new Image(i.getUrlImagen()));
                imgInteractuable.setFitHeight(20);
                imgInteractuable.setFitWidth(20);
                if(contenedor1.getChildren().size() == 2){
                    contenedor2.getChildren().add(imgInteractuable);
                }else{
                    contenedor1.getChildren().add(imgInteractuable);
                }
                contenedorInteractuables.getChildren().add(imgInteractuable);
            }
            contenedorInteractuables.getChildren().add(contenedor1);
            if(contenedor2.getChildren().size() > 0){
                contenedorInteractuables.getChildren().add(contenedor2);
            }
            mapa.add(contenedorInteractuables, posicion.getPosicionX(),juego.getMapaActual().getAlto() - posicion.getPosicionY());
            contenedorInteractuables.setAlignment(Pos.CENTER);
        }

        this.actualizarSombra(mapaOscuro, this.vehiculoX, invertirY(this.vehiculoY));

        this.getChildren().addAll(mapa, mapaOscuro,botones);

        this.setAlignment(mapa, Pos.CENTER);

        this.setAlignment(mapaOscuro, Pos.CENTER);

        this.setAlignment(botones, Pos.BOTTOM_RIGHT);

        this.setMargin(botones, new Insets(0,0,20,10));

        this.setPrefWidth(640);
        this.setMaxHeight(520);
    }

    public GridPane botonesDeDireccion(GridPane mapa, VehiculoVista vehiculoVista){
        GridPane botones = new GridPane();
        botones.setAlignment(Pos.BOTTOM_RIGHT);

        Button btnArriba = new Button("Arriba");
        btnArriba.setCursor(Cursor.HAND);
        btnArriba.setPrefWidth(70);

        Button btnIzquierda = new Button("Izquierda");
        btnIzquierda.setCursor(Cursor.HAND);

        Button btnDerecha = new Button("Derecha");
        btnDerecha.setCursor(Cursor.HAND);

        Button btnAbajo = new Button("Abajo");
        btnAbajo.setCursor(Cursor.HAND);
        btnAbajo.setPrefWidth(70);

        botones.add(btnArriba, 0,0);
        botones.add(btnIzquierda, 0,1);
        botones.add(btnDerecha, 1,1);
        botones.add(btnAbajo, 0,2);

        botones.setMargin(btnArriba, new Insets(0,0,5,0));
        botones.setMargin(btnAbajo, new Insets(5,0,0,0));

        botones.setColumnSpan(btnArriba,2);
        botones.setColumnSpan(btnAbajo,2);

        botones.setHalignment(btnArriba, HPos.CENTER);
        botones.setHalignment(btnAbajo, HPos.CENTER);

        btnArriba.setOnMousePressed((event) -> moverArriba(mapa, vehiculoVista));
        btnDerecha.setOnMousePressed((event) -> moverDerecha(mapa, vehiculoVista));
        btnIzquierda.setOnMousePressed((event) -> moverIzquierda(mapa, vehiculoVista));
        btnAbajo.setOnMousePressed((event) -> moverAbajo(mapa, vehiculoVista));

        return botones;

    }
    private int invertirY(int y) {
        return (this.altoMapa - 1) - y;
    }

    private void moverVehiculoVista(GridPane mapa, VehiculoVista vehiculo) {
        mapa.getChildren().remove(vehiculo);
        mapa.add(vehiculo, vehiculo.getPosicionX(), invertirY(vehiculo.getPosicionY()));
        this.actualizarSombra(mapa, vehiculo.getPosicionX(), invertirY(vehiculo.getPosicionY()));
    }

    private void actualizarSombra(GridPane mapaOscuro, int posicionX, int posicionY){
        /*for(int i = posicionX-2; i <= posicionX+2; i++){
            for(int j=posicionY-2 ; j <= posicionY; j++){
                if((i >= 0) && (j>=0)){
                    var rectangulo = new Rectangle();
                    rectangulo.setWidth(50);
                    rectangulo.setHeight(60);
                    rectangulo.setVisible(false);
                }
            }
        }*/

        for (Node node : mapaOscuro.getChildren()) {
            int posicionXNodo = mapaOscuro.getColumnIndex(node);
            int posicionYNodo = mapaOscuro.getRowIndex(node);

            int resultadoX = posicionX - posicionXNodo;
            int resultadoY = posicionY - posicionYNodo;

            if( (Math.abs(resultadoX) < 2) && (Math.abs(resultadoY) < 2) ){
                node.setVisible(false);
            }

            else{
                node.setVisible(true);
            }
        }
    }


    public void moverArriba(GridPane mapa, VehiculoVista vehiculo) {
        this.controlador.moverArriba(vehiculo);
        moverVehiculoVista(mapa, vehiculo);
    }
    public void moverIzquierda(GridPane mapa, VehiculoVista vehiculo) {
        this.controlador.moverIzquierda(vehiculo);
        moverVehiculoVista(mapa, vehiculo);
    }
    private void moverDerecha(GridPane mapa, VehiculoVista vehiculo) {
        this.controlador.moverDerecha(vehiculo);
        moverVehiculoVista(mapa, vehiculo);
//        mapa.getChildren().remove(vehiculo);
//        vehiculo.setVisible(false);
//        mapa.add(vehiculo, 4, 2);
//        double x = vehiculo.getLayoutX();
//        double y = vehiculo.getLayoutY();
//
//        mapa.getChildren().remove(vehiculo);
//        mapa.add(vehiculo, 2, 2);
//        vehiculo.setVisible(true);
//
//        TranslateTransition tt = new TranslateTransition();
//        tt.setDuration(Duration.seconds(2));
//        tt.setToX(x);
//        tt.setToY(y);
//        tt.setNode(vehiculo);
//        tt.play();
//        tt.setOnFinished((event) -> {
//            mapa.getChildren().remove(vehiculo);
//            vehiculo.setTranslateX(0);
//            vehiculo.setTranslateY(0);
//            mapa.add(vehiculo, 4, 2);
//        });
    }
    public void moverAbajo(GridPane mapa, VehiculoVista vehiculo) {
        this.controlador.moverAbajo(vehiculo);
        moverVehiculoVista(mapa, vehiculo);
    }


}
