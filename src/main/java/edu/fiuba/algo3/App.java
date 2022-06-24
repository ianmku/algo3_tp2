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

        // StackPane layout = new StackPane();
        GPSChallengeVista gpschallengeVista = new GPSChallengeVista(gpscontrolador);

        Juego juego = Juego.getInstance();

        juego.addObserver(gpschallengeVista);

        Scene scene = new Scene(gpschallengeVista, 640, 520);
        // Scene scene1 = new Scene(layout);

//        Button button = new Button();
//        button.setText("Boton nazi");

        // layout.getChildren().add(button);

        // Juego juego = new Juego();

        stage.setScene(scene);
        stage.setTitle(gpschallengeVista.obtenerTitulo());
        stage.show();
//        Juego unJuego = new Juego();
//        unJuego.menu();
    }

    public static void main(String[] args) {
        launch();
    }

}