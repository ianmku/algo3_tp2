package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class RankingVista extends BorderPane {
    public RankingVista(Juego juego) {
        VBox vBox = new VBox();

        Label titulo = new Label("RANKINGS");
        titulo.setFont(Font.font("Arial", 30));
        titulo.setStyle("-fx-font-weight: bold;");
        vBox.getChildren().add(titulo);

        juego.obtenerJugadores().forEach((jugador) -> {
            String puntaje = jugador.obtenerPuntaje();
            Label labelPuntaje = new Label(puntaje);
            labelPuntaje.setStyle("-fx-text-fill: black;" +
                    "-fx-font-size: 30;"

            );
            labelPuntaje.setWrapText(true);

            HBox hBox = new HBox();
            hBox.getChildren().add(labelPuntaje);
            hBox.setMaxWidth(400);

            vBox.getChildren().add(hBox);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
        });

        this.setTop(vBox);
    }
}
