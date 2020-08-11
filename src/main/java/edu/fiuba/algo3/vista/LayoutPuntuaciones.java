package edu.fiuba.algo3.vista;

import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LayoutPuntuaciones extends VBox {

    private VBox contenedorPuntuaciones;

    public LayoutPuntuaciones() {

        Label bienvenida = new Label("Juego Terminado");

        contenedorPuntuaciones = new VBox(bienvenida);
    }

    public VBox getLayout() {return contenedorPuntuaciones;}
}