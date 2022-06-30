package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VehiculoVista extends VBox {
    public VehiculoVista(Juego juego){
        Image imagenVehiculo;
        ImageView vehiculoView = new ImageView();

        if(juego.getTipoVehiculo().getClass() == Auto.class){
            imagenVehiculo = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/pngegg.png?raw=true");
            vehiculoView = new ImageView(imagenVehiculo);
        }

        if(juego.getTipoVehiculo().getClass() == Moto.class){
            imagenVehiculo = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/moto.jpg?raw=true");
            vehiculoView = new ImageView(imagenVehiculo);
            vehiculoView.setRotate(90);
        }

        if(juego.getTipoVehiculo().getClass() == Camioneta.class){
            imagenVehiculo = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/camioneta.png?raw=true");
            vehiculoView = new ImageView(imagenVehiculo);
            vehiculoView.setRotate(90);
        }

        vehiculoView.setFitWidth(50);
        vehiculoView.setFitHeight(50);

        this.getChildren().add(vehiculoView);
        this.setAlignment(Pos.CENTER);
    }

}
