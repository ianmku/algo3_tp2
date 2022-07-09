package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VehiculoControlador;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;

import java.util.Observable;
import java.util.Observer;

public class VehiculoVista extends VBox implements Observer {
    private ImageView vehiculoView;
    private final Juego juego;
    private final VehiculoControlador controlador;
    private int posicionX;
    private int posicionY;

    public VehiculoVista(Juego juego, VehiculoControlador controlador){
        super();
        this.controlador = controlador;
        this.vehiculoView = new ImageView();
        this.juego = juego;
        this.vehiculoView = new ImageView(new Image(juego.getJugadorActual().obtenerVehiculo().getTipo().getUrlImagen()));

        this.vehiculoView.setFitWidth(50);
        this.vehiculoView.setFitHeight(50);

        this.getChildren().add(vehiculoView);
        this.setAlignment(Pos.CENTER);
    }
    @Override
    public void update(Observable unVehiculo, Object arg) {

        var vehiculo = (Vehiculo) unVehiculo;

        this.vehiculoView = new ImageView(new Image(vehiculo.getTipo().getUrlImagen()));

        this.vehiculoView.setFitWidth(50);
        this.vehiculoView.setFitHeight(50);
        Direccion nuevaDireccion = vehiculo.getDireccion();
        rotarVehiculo(nuevaDireccion);

        this.getChildren().clear();
        this.getChildren().add(this.vehiculoView);

        this.posicionX = vehiculo.getPosicion().getPosicionX();
        this.posicionY = vehiculo.getPosicion().getPosicionY();

        if(vehiculo.estaEnLlegada()){
            this.controlador.terminarPartida();
        }
    }

    private void rotarVehiculo(Direccion nuevaDireccion) {
        Rotate rotar = new Rotate();
        rotar.setPivotX(this.vehiculoView.getFitWidth() / 2);
        rotar.setPivotY(this.vehiculoView.getFitHeight() / 2);

        if(nuevaDireccion.getClass() == Arriba.class){
            rotar.setAngle(270);

        }else if(nuevaDireccion.getClass() == Izquierda.class){
            rotar.setAngle(180);

        }else if(nuevaDireccion.getClass() == Derecha.class){
            rotar.setAngle(0);

        }else if(nuevaDireccion.getClass() == Abajo.class){
            rotar.setAngle(90);
        }
        this.vehiculoView.getTransforms().clear();
        this.vehiculoView.getTransforms().add(rotar);
    }

    public int getPosicionX() {
        return this.posicionX;
    }

    public int getPosicionY() {
        return this.posicionY;
    }

}
