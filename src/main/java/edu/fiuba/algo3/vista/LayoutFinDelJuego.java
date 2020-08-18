package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LayoutFinDelJuego {

    private Pane contenedorPuntuaciones;

    public LayoutFinDelJuego(Jugador unJugador, Jugador otroJugador) {

        Label textoPrimerJugador = new Label("El jugador: " + unJugador.getNombre());
        textoPrimerJugador.setStyle("-fx-font-weight: bold");


        Label puntuacionPrimerJugador = new Label("obtuvo: " + unJugador.getPuntaje().getPuntos() + " puntos");
        puntuacionPrimerJugador.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloPrimerJugador = new Rectangle(20, 20, 300, 100);
        rectanguloPrimerJugador.setFill(Color.LAVENDER);

        VBox informacionPrimerJugador = new VBox(textoPrimerJugador, puntuacionPrimerJugador);
        informacionPrimerJugador.setSpacing(10);
        informacionPrimerJugador.setAlignment(Pos.CENTER);

        StackPane contenedorPrimerJugador = new StackPane(rectanguloPrimerJugador, informacionPrimerJugador);
        contenedorPrimerJugador.setPadding(new Insets(10));
        contenedorPrimerJugador.setStyle("-fx-font-size: 1.5em;");

        Label textoSegundoJugador = new Label("El jugador: " + otroJugador.getNombre());
        textoSegundoJugador.setStyle("-fx-font-weight: bold");

        Label puntuacionSegundoJugador = new Label("obtuvo: " + otroJugador.getPuntaje().getPuntos() + " puntos");
        puntuacionSegundoJugador.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloSegundoJugador= new Rectangle(20, 20, 300, 100);
        rectanguloSegundoJugador.setFill(Color.LIGHTGRAY);

        VBox informacionSegundoJugador = new VBox(textoSegundoJugador, puntuacionSegundoJugador);
        informacionSegundoJugador.setPadding(new Insets(5));
        informacionSegundoJugador.setAlignment(Pos.CENTER);

        StackPane contenedorSegundoJugador = new StackPane(rectanguloSegundoJugador, informacionSegundoJugador);
        contenedorSegundoJugador.setPadding(new Insets(10));
        contenedorSegundoJugador.setStyle("-fx-font-size: 1.5em;");

        contenedorPuntuaciones = new VBox(contenedorPrimerJugador, contenedorSegundoJugador);

    }

    public Pane getLayout() {return contenedorPuntuaciones;}
}