package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VehiculoControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Observable;
import java.util.Observer;

public class VehiculoVista extends VBox implements Observer {
    private ImageView vehiculoView;
    private final Juego juego;
    private final VehiculoControlador controlador;

    public VehiculoVista(Juego juego, VehiculoControlador controlador){
        super();
        this.controlador = controlador;
        this.vehiculoView = new ImageView();
        this.juego = juego;

        this.vehiculoView.setFitWidth(50);
        this.vehiculoView.setFitHeight(50);

        this.getChildren().add(vehiculoView);
        this.setAlignment(Pos.CENTER);
    }
    @Override
    public void update(Observable unVehiculo, Object arg) {

        var vehiculo = (Vehiculo) unVehiculo;

        this.vehiculoView = new ImageView(new Image(vehiculo.getTipo().getUrlImagen()));
        this.getChildren().clear();
        this.getChildren().add(vehiculoView);

        if(vehiculo.estaEnLlegada()){
            this.controlador.terminarPartida();
        }

//        if(vehiculo.getTipo().getClass() == Auto.class){
//            this.vehiculoView = new ImageView(new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/pngegg.png?raw=true"));
//        }
//
//        if(vehiculo.getTipo().getClass() == Moto.class){
//            this.vehiculoView = new ImageView(new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/moto.jpg?raw=true"));
//        }
//
//        if(vehiculo.getTipo().getClass() == Camioneta.class){
//            this.vehiculoView = new ImageView(new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/camioneta.png?raw=true"));
//        }
    }

    public void moverDerecha(){
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(4));
        tt.setToX(this.vehiculoView.getX() + 80);
        tt.setNode(this.vehiculoView);
        tt.play();
    }

    public void moverIzquierda(){
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(4));
        tt.setToX(this.vehiculoView.getX() - 80);
        tt.setNode(this.vehiculoView);
        tt.play();
    }

    public void moverArriba(){
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(4));
        tt.setToY(this.vehiculoView.getY() - 80);
        tt.setNode(this.vehiculoView);
        tt.play();
    }

    public void moverAbajo() {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(4));
        tt.setToY(this.vehiculoView.getY() + 80);
        tt.setNode(this.vehiculoView);
        tt.play();
    }


}
