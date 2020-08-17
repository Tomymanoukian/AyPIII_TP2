package edu.fiuba.algo3.vista;

import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LayoutPuntuaciones {

    private Pane contenedorPuntuaciones;

    public LayoutPuntuaciones() {

        Label bienvenida = new Label("Juego Terminado");

        contenedorPuntuaciones = new VBox(bienvenida);
    }

    public Pane getLayout() {return contenedorPuntuaciones;}

    public void mostrarVista(Pane unosLayouts) {

        unosLayouts.getChildren().forEach(element -> element.setVisible(false));
        contenedorPuntuaciones.setVisible(true);
    }
}