package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.GPSChallengeControlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class InicioVista extends StackPane {
    private final GPSChallengeControlador controlador;

    public InicioVista(GPSChallengeControlador controlador) {
        this.controlador = controlador;

        Image image = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/src/main/java/edu/fiuba/algo3/Picsart_22-06-28_23-47-58-019.png?raw=true");


        ImageView img = new ImageView(image);
        img.setFitHeight(520);
        img.setFitWidth(640);

        //Label titulo = new Label("GPS CHALLENGE");
        //titulo.setFont(Font.font("Arial", 40));
        //titulo.setStyle("-fx-font-weight: bold;" + "-fx-text-fill: white;");
        //DropShadow shadow = new DropShadow();
        //titulo.setEffect(shadow);
        //titulo.setAlignment(Pos.TOP_CENTER);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        //vBox.getChildren().add(titulo);
        vBox.getChildren().add(agregarBotonDeInicio());
        vBox.getChildren().add(agregarBotonDeRanking());
        vBox.setPadding(new Insets(0, 0, 0, 0));
        vBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(img,vBox);

        this.setAlignment(vBox, Pos.BOTTOM_CENTER);
    }

    private HBox agregarBotonDeInicio() {
        Button botonInicio = new Button("Iniciar Juego");
        botonInicio.setOnMouseClicked((event) -> this.controlador.iniciarLobby());
        botonInicio.setMinWidth(150);
        botonInicio.setStyle("-fx-background-radius: 90;");
        HBox hBox = new HBox(botonInicio);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private HBox agregarBotonDeRanking() {
        Button botonRanking = new Button("Mostrar Ranking");
        botonRanking.setOnMouseClicked((event) -> this.controlador.mostrarRanking());
        botonRanking.setMinWidth(150);
        botonRanking.setStyle("-fx-background-radius: 90;");
        HBox hBox = new HBox(botonRanking);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }
}
