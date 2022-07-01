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
    private Direccion ultimaDireccion;

    public VehiculoVista(Juego juego, VehiculoControlador controlador){
        super();
        this.controlador = controlador;
        this.vehiculoView = new ImageView();
        this.juego = juego;
        this.vehiculoView = new ImageView(new Image(juego.getJugadorActual().obtenerVehiculo().getTipo().getUrlImagen()));
        this.ultimaDireccion = new Derecha();

        this.vehiculoView.setFitWidth(50);
        this.vehiculoView.setFitHeight(50);

        this.getChildren().add(vehiculoView);
        this.setAlignment(Pos.CENTER);
    }
    @Override
    public void update(Observable unVehiculo, Object arg) {

        var vehiculo = (Vehiculo) unVehiculo;

        //Image radio = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/radio.png?raw=true");
        //ImageView radioView = new ImageView(radio);
        //radioView.setFitHeight(300);
        //radioView.setFitWidth(300);

        this.vehiculoView = new ImageView(new Image(vehiculo.getTipo().getUrlImagen()));

        this.vehiculoView.setFitWidth(50);
        this.vehiculoView.setFitHeight(50);
        Direccion nuevaDireccion = vehiculo.getDireccion();
        //if(ultimaDireccion.getClass() != nuevaDireccion.getClass()) rotarVehiculo(ultimaDireccion, nuevaDireccion);

        //StackPane panel = new StackPane();
        //panel.getChildren().addAll(vehiculoView);

        //panel.setAlignment(vehiculoView, Pos.CENTER);
        //panel.setAlignment(radioView, Pos.CENTER);

        this.getChildren().clear();
        this.getChildren().add(this.vehiculoView);
        this.ultimaDireccion = nuevaDireccion;

        this.posicionX = vehiculo.getPosicion().getPosicionX();
        this.posicionY = vehiculo.getPosicion().getPosicionY();

        if(vehiculo.estaEnLlegada()){
            this.controlador.terminarPartida();
        }
    }
    // ultimaDireccion = donde estaba mirando | nuevaDireccion = donde tiene que mirar;
    private void rotarVehiculo(Direccion ultimaDireccion, Direccion nuevaDireccion) {
        Rotate rotar = new Rotate();
        rotar.setPivotX(this.vehiculoView.getFitWidth() / 2);
        rotar.setPivotY(this.vehiculoView.getFitHeight() / 2);

        if(ultimaDireccion.getClass() == Arriba.class){
            System.out.println("Me muevo DESDE arriba");
        }
        if(ultimaDireccion.getClass() == Izquierda.class){
            System.out.println("Me muevo DESDE la izquierda");
        }
        if(ultimaDireccion.getClass() == Derecha.class){
            System.out.println("Me muevo DESDE la derecha");
        }
        if(ultimaDireccion.getClass() == Abajo.class){
            System.out.println("Me muevo DESDE abajo");
        }

        if(nuevaDireccion.getClass() == Arriba.class){
            System.out.println("Me movi hacia arriba");
            if(ultimaDireccion.getClass() == Izquierda.class) rotar.setAngle(90);
            else if(ultimaDireccion.getClass() == Abajo.class) rotar.setAngle(180);
            else if(ultimaDireccion.getClass() == Derecha.class) rotar.setAngle(270);

        }else if(nuevaDireccion.getClass() == Izquierda.class){
            System.out.println("Me movi a la izquierda");
            if(ultimaDireccion.getClass() == Abajo.class) rotar.setAngle(90);
            else if(ultimaDireccion.getClass() == Derecha.class) rotar.setAngle(180);
            else if(ultimaDireccion.getClass() == Arriba.class) rotar.setAngle(270);

        }else if(nuevaDireccion.getClass() == Derecha.class){
            System.out.println("Me movi a la derecha");
            if(ultimaDireccion.getClass() == Arriba.class) rotar.setAngle(90);
            else if(ultimaDireccion.getClass() == Izquierda.class) rotar.setAngle(180);
            else if(ultimaDireccion.getClass() == Abajo.class) rotar.setAngle(270);

        }else if(nuevaDireccion.getClass() == Abajo.class){
            System.out.println("Me movi hacia abajo");
            if(ultimaDireccion.getClass() == Derecha.class) rotar.setAngle(90);
            else if(ultimaDireccion.getClass() == Arriba.class) rotar.setAngle(180);
            else if(ultimaDireccion.getClass() == Izquierda.class) rotar.setAngle(270);

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
