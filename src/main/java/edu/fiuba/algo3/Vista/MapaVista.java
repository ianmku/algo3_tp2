package edu.fiuba.algo3.Vista;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import javafx.scene.Node;

public class MapaVista extends Group{

    public double width;
    public double heigth;
    private double tileWidth = 64;
    private double tileHeigth = 64;

    private GridPane table;

    private Pane[][] panes;

    public MapaVista(Mapa map){
        table = new GridPane();
        width = tileWidth * map.getAncho();
        heigth = tileHeigth * map.getAncho();
        panes = new Pane[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane v = new Pane();
                //v.setMinHeight(this.tileHeigth);
                //v.setMinWidth(this.tileWidth);
                panes[i][j] = v;
                table.add(v , i, j);
            }
        }
        /*Background bi = new Background(new BackgroundImage(new Image("https://www.edrawsoft.com/templates/images/street-map.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.width, this.heigth, false, false, false, false)));
        table.setBackground(bi);*/
        table.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        this.addView(table);
    }

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }
}
