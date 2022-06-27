package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.GPSChallengeControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vistas.GPSChallengeVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        GPSChallengeControlador gpscontrolador = new GPSChallengeControlador();

        GPSChallengeVista gpschallengeVista = new GPSChallengeVista(gpscontrolador);

        var juego = Juego.getInstance();

        juego.addObserver(gpschallengeVista);

        var scene = new Scene(gpschallengeVista, 640, 520);

        stage.setScene(scene);
        stage.setTitle(gpschallengeVista.obtenerTitulo());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}