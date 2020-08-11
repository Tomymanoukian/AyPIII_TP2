package edu.fiuba.algo3.vista;

import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LayoutMenuBienvenida extends VBox {

    private Pane layout;

    public LayoutMenuBienvenida() {

        Label bienvenida = new Label("Bienvenidos a Kahoot");

        Label pedirNombreJugador1 = new Label("Ingrese nombre del Jugador 1");
        TextField nombreJugador1 = new TextField();
        Label pedirNombreJugador2 = new Label("Ingrese nombre del Jugador 2");
        TextField nombreJugador2 = new TextField();

        Button iniciarJuego = new Button("Iniciar Kahoot");

        VBox contenedorBienvenida = new VBox(bienvenida);
        VBox contenedorInsertarNombreJugador1 = new VBox(pedirNombreJugador1, nombreJugador1);
        VBox contenedorInsertarNombreJugador2 = new VBox(pedirNombreJugador2, nombreJugador2);

        layout = new VBox(contenedorBienvenida, contenedorInsertarNombreJugador1, contenedorInsertarNombreJugador2, iniciarJuego);
    }

    public Pane getLayout(){return layout;}

    public void mostrarVista(Pane unosLayouts) {

        unosLayouts.getChildren().forEach(element -> element.setVisible(false));
        layout.setVisible(true);
    }
}
