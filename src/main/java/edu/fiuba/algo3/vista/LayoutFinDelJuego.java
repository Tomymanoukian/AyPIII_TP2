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

    public LayoutFinDelJuego(Jugador jugadorGanador, Jugador jugadorPerdedor) {

        Label textoGanador = new Label("El ganador es: " + jugadorGanador.getNombre());
        textoGanador.setStyle("-fx-font-weight: bold");

        Label puntuacionGanador = new Label("Su puntuacion fue: " + jugadorGanador.getPuntaje().getPuntos());
        puntuacionGanador.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloGanador = new Rectangle(20, 20, 300, 100);
        rectanguloGanador.setFill(Color.LAVENDER);

        VBox informacionGanador = new VBox(textoGanador, puntuacionGanador);
        informacionGanador.setSpacing(10);
        informacionGanador.setAlignment(Pos.CENTER);

        StackPane contenedorGanador = new StackPane(rectanguloGanador, informacionGanador);
        contenedorGanador.setPadding(new Insets(10));
        contenedorGanador.setStyle("-fx-font-size: 1.5em;");

        Label textoPerdedor = new Label("El perdedor es: " + jugadorPerdedor.getNombre());
        textoPerdedor.setStyle("-fx-font-weight: bold");

        Label puntuacionPerdedor = new Label("Su puntuacion fue: " + jugadorPerdedor.getPuntaje().getPuntos());
        puntuacionPerdedor.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloPerdedor= new Rectangle(20, 20, 300, 100);
        rectanguloPerdedor.setFill(Color.LIGHTGRAY);

        VBox informacionPerdedor = new VBox(textoPerdedor, puntuacionPerdedor);
        informacionPerdedor.setPadding(new Insets(5));
        informacionPerdedor.setAlignment(Pos.CENTER);

        StackPane contenedorPerdedor = new StackPane(rectanguloPerdedor, informacionPerdedor);
        contenedorPerdedor.setPadding(new Insets(10));
        contenedorPerdedor.setStyle("-fx-font-size: 1.2em;");

        contenedorPuntuaciones = new VBox(contenedorGanador, contenedorPerdedor);
    }

    public Pane getLayout() {return contenedorPuntuaciones;}
}