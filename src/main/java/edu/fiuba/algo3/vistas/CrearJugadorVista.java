package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.CrearJugadorControlador;
import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Vehiculos.Tipo.*;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class CrearJugadorVista extends StackPane {

    private Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
    private Tipo vehiculo = new Moto();
    private final CrearJugadorControlador controlador;

    public CrearJugadorVista(CrearJugadorControlador controlador) {
        this.controlador = controlador;

        Image fondoDePantalla = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/menu_principal.png?raw=true");
        ImageView fondoView = new ImageView(fondoDePantalla);
        fondoView.setFitHeight(800);
        fondoView.setFitWidth(900);

        DropShadow shadow = new DropShadow();

        Label lblNombre = new Label("Nombre: ");
        lblNombre.setStyle("-fx-text-fill: white;" +
                "-fx-font-size: 12pt;" + "-fx-font-weight: bold;"
        );
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese un nombre");
        txtNombre.setMinWidth(70);
        lblNombre.setEffect(shadow);

        HBox nombreJugador = new HBox();
        nombreJugador.getChildren().add(lblNombre);
        nombreJugador.getChildren().add(txtNombre);
        nombreJugador.setAlignment(Pos.TOP_CENTER);

        // Botones vehiculo
        ToggleGroup tg1 = new ToggleGroup();

        Label elegirVehiculo = new Label("Elegí tu vehículo: ");
        elegirVehiculo.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        elegirVehiculo.setEffect(shadow);
        RadioButton auto = new RadioButton("Auto");
        auto.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        auto.setEffect(shadow);
        RadioButton moto = new RadioButton("Moto");
        moto.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        moto.setEffect(shadow);
        RadioButton camioneta = new RadioButton("Camioneta");
        camioneta.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        camioneta.setEffect(shadow);

        auto.setToggleGroup(tg1);
        moto.setToggleGroup(tg1);
        camioneta.setToggleGroup(tg1);

        HBox vehiculos = new HBox();
        vehiculos.getChildren().addAll(elegirVehiculo, auto, moto, camioneta);
        vehiculos.setSpacing(5);
        vehiculos.setAlignment(Pos.CENTER);

        // Botones Mapa
        ToggleGroup tg2 = new ToggleGroup();

        Label elegirMapa = new Label("Elegí el tamaño del mapa: ");
        elegirMapa.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        elegirMapa.setEffect(shadow);
        RadioButton chico = new RadioButton("Chico");
        chico.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        chico.setEffect(shadow);
        RadioButton grande = new RadioButton("Grande");
        grande.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        grande.setEffect(shadow);

        chico.setToggleGroup(tg2);
        grande.setToggleGroup(tg2);

        HBox mapas = new HBox();
        mapas.getChildren().addAll(elegirMapa, chico, grande);
        mapas.setSpacing(5);
        mapas.setAlignment(Pos.CENTER);

        tg1.selectedToggleProperty().addListener(
                (observable) -> {
                    RadioButton rb = (RadioButton)tg1.getSelectedToggle();
                    switch(rb.getText()){
                        case "Auto":
                            this.vehiculo = new Auto();
                            break;
                        case "Moto":
                            this.vehiculo = new Moto();
                            break;
                        case "Camioneta":
                            this.vehiculo = new Camioneta();
                            break;
                    }
                }
        );

        tg2.selectedToggleProperty().addListener(
                (observable) -> {
                    RadioButton rb = (RadioButton)tg2.getSelectedToggle();
                    switch(rb.getText()){
                        case "Chico":
                            this.mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
                            break;
                        case "Grande":
                            this.mapa = new Mapa(TamanioMapa.GRANDE, new Aleatorio());
                            break;
                    }
                }
        );

        Button btnIniciar = new Button("Iniciar partida!");
        btnIniciar.setOnMouseClicked((evento) -> this.controlador.iniciarPartida(txtNombre.getText(), this.vehiculo, this.mapa));
        btnIniciar.setMinWidth(120);
        btnIniciar.setStyle("-fx-background-radius: 90;");
        HBox iniciar = new HBox(btnIniciar);
        iniciar.setAlignment(Pos.CENTER);

        Button btnSalir = new Button("Volver al menú");
        btnSalir.setOnMouseClicked((event) -> this.controlador.volverAlMenu());
        btnSalir.setMinWidth(120);
        btnSalir.setStyle("-fx-background-radius: 90;");
        HBox salir = new HBox(btnSalir);
        salir.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(nombreJugador, vehiculos, mapas, iniciar, salir);
        vBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(fondoView, vBox);
        this.setAlignment(vBox, Pos.CENTER);
    }

}
