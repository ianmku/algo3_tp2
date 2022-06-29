package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.GPSChallengeControlador;
import edu.fiuba.algo3.controladores.RankingControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
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

public class RankingVista extends StackPane {

    private final RankingControlador controlador;
    public RankingVista(Juego juego, RankingControlador controlador) {
        this.controlador = controlador;

        Image image = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/src/main/java/edu/fiuba/algo3/menu_principal.png?raw=true");
        ImageView img = new ImageView(image);
        DropShadow shadow = new DropShadow();

        VBox vBox = new VBox();
        Label titulo = new Label("RANKINGS");
        titulo.setFont(Font.font("Arial", 30));
        titulo.setStyle("-fx-text-fill: white;" + "-fx-font-weight: bold;");
        titulo.setEffect(shadow);
        titulo.setAlignment(Pos.TOP_CENTER);
        vBox.getChildren().add(titulo);

        juego.obtenerJugadores().forEach((jugador) -> {
            String puntaje = jugador.obtenerPuntajeString();
            Label labelPuntaje = new Label(puntaje);
            labelPuntaje.setStyle("-fx-text-fill: white;" +
                    "-fx-font-size: 30;" + "-fx-font-weight: bold;"

            );
            labelPuntaje.setEffect(shadow);
            labelPuntaje.setWrapText(true);

            HBox hBox = new HBox();
            hBox.getChildren().add(labelPuntaje);
            hBox.setMaxWidth(400);
            hBox.setAlignment(Pos.CENTER);

            vBox.getChildren().add(hBox);
        });

        Button btnSalir = new Button("Volver al menú");
        btnSalir.setOnMouseClicked((event) -> this.controlador.volverAlMenu());
        btnSalir.setMinWidth(120);
        btnSalir.setStyle("-fx-background-radius: 90;");
        HBox salir = new HBox(btnSalir);
        salir.setAlignment(Pos.CENTER);

        vBox.setSpacing(5);
        vBox.getChildren().add(salir);
        vBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(img, vBox);
        this.setAlignment(vBox, Pos.BOTTOM_CENTER);
    }
}
