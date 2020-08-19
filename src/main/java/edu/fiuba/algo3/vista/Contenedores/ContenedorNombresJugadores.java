package edu.fiuba.algo3.vista.Contenedores;

import edu.fiuba.algo3.controlador.KeyEnterPrimerJugadorHandler;
import edu.fiuba.algo3.controlador.KeyEnterSegundoJugadorHandler;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ContenedorNombresJugadores {

    private VBox contenedorNombresJugadores;
    private TextField nombreJugador1;
    private TextField nombreJugador2;

    public ContenedorNombresJugadores(Jugador jugador1, Jugador jugador2){

        Label pedirNombreJugador1 = new Label("Ingrese nombre del Jugador 1");
        nombreJugador1 = new TextField();
        nombreJugador1.setPromptText(jugador1.getNombre());
        nombreJugador1.setFocusTraversable(false);

        Label pedirNombreJugador2 = new Label("Ingrese nombre del Jugador 2");
        nombreJugador2 = new TextField();
        nombreJugador2.setPromptText(jugador2.getNombre());
        nombreJugador2.setFocusTraversable(false);

        contenedorNombresJugadores = new VBox( pedirNombreJugador1, nombreJugador1, pedirNombreJugador2, nombreJugador2);
        contenedorNombresJugadores.setAlignment(Pos.CENTER);
        contenedorNombresJugadores.setStyle("-fx-font-size: 1.1em;");
        contenedorNombresJugadores.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorNombresJugadores.setPadding(new Insets(20));
        contenedorNombresJugadores.setSpacing(15);
    }

    public VBox getLayout(){
        return contenedorNombresJugadores;
    }

    public TextField nombreJugador1() {
        return nombreJugador1;
    }

    public TextField nombreJugador2() {
        return nombreJugador2;
    }
}
