package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEmpezarJuegoEventHandler;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LayoutMenuBienvenida {

    private Pane layout;

    public LayoutMenuBienvenida(ManejadorDeTurnos manejadorDeTurnos) {
        Label bienvenida = new Label("Bienvenidos a Kahoot");
        bienvenida.setStyle("-fx-font-weight: bold");
        VBox contenedorBienvenida = new VBox(bienvenida);
        contenedorBienvenida.setAlignment(Pos.CENTER);
        contenedorBienvenida.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorBienvenida.setPadding(new Insets(25));
        contenedorBienvenida.setStyle("-fx-font-size: 1.5em;");

        Label pedirNombreJugador1 = new Label("Ingrese nombre del Jugador 1");
        TextField nombreJugador1 = new TextField();
        Label pedirNombreJugador2 = new Label("Ingrese nombre del Jugador 2");
        TextField nombreJugador2 = new TextField();

        VBox contenedorNombresJugadores = new VBox( pedirNombreJugador1, nombreJugador1, pedirNombreJugador2, nombreJugador2);
        contenedorNombresJugadores.setAlignment(Pos.CENTER);
        contenedorNombresJugadores.setStyle("-fx-font-size: 1.1em;");
        contenedorNombresJugadores.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorNombresJugadores.setPadding(new Insets(20));
        contenedorNombresJugadores.setSpacing(15);

        Button iniciarJuego = new Button("Iniciar Kahoot");
        iniciarJuego.setStyle("-fx-border-color: #000000; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");
        HBox contenedorBoton = new HBox(iniciarJuego);

        BotonEmpezarJuegoEventHandler botonComienzoDeJuego = new BotonEmpezarJuegoEventHandler(nombreJugador1, nombreJugador2, manejadorDeTurnos);
        iniciarJuego.setOnAction(botonComienzoDeJuego);

        VBox contenedorInicioDeKahoot = new VBox(contenedorBienvenida, contenedorNombresJugadores, contenedorBoton);
        contenedorBoton.setAlignment(Pos.BOTTOM_RIGHT);
        contenedorBoton.setPadding(new Insets(20));

        contenedorInicioDeKahoot.setSpacing(20);
        contenedorInicioDeKahoot.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        layout = new VBox(contenedorInicioDeKahoot);
    }

    public Pane getLayout(){return layout;}

    public void mostrarVista(Pane unosLayouts) {

        unosLayouts.getChildren().forEach(element -> element.setVisible(false));
        layout.setVisible(true);
    }
}
