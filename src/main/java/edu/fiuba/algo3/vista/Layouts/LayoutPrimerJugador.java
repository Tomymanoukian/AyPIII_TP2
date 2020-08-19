package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.BotonPrimeraPreguntaEventHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LayoutPrimerJugador {
    private Pane contenedorPuntuaciones;

    public LayoutPrimerJugador(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos){

        Label texto = new Label("Es el turno de: " + jugador.getNombre());
        texto.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloTexto = new Rectangle(20, 20, 300, 100);
        rectanguloTexto.setFill(Color.LAVENDER);

        StackPane contenedorTexto = new StackPane(rectanguloTexto, texto);
        contenedorTexto.setPadding(new Insets(10));
        contenedorTexto.setStyle("-fx-font-size: 1.3em;");

        Button enviar = new Button("Siguiente");
        enviar.setStyle("-fx-border-color: #A8E3E7; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");

        BotonPrimeraPreguntaEventHandler botonSiguiente = new BotonPrimeraPreguntaEventHandler(manejadorDeTurnos);
        enviar.setOnAction(botonSiguiente);

        VBox contenedorBoton = new VBox(enviar);
        contenedorBoton.setPadding(new Insets(50));
        contenedorBoton.setAlignment(Pos.BOTTOM_RIGHT);

        contenedorPuntuaciones = new VBox(contenedorTexto, contenedorBoton);
        contenedorPuntuaciones.setMinWidth(150);
        contenedorPuntuaciones.setMinHeight(250);
    }

    public Pane getLayout() {return contenedorPuntuaciones;}
}
