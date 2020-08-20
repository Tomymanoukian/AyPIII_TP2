package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.BotonPrimeraPreguntaEventHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.vista.Constantes;
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

        VBox informacion = new VBox(texto);
        informacion.setStyle("-fx-font-weight: bold");
        informacion.setAlignment(Pos.CENTER);
        informacion.setPadding(new Insets(50));
        informacion.setSpacing(40);

        Rectangle rectanguloTexto = new Rectangle(20, 20, 450, Constantes.ALTO_CONTENEDOR_CONSIGNA);
        rectanguloTexto.setFill(Color.LAVENDER);

        StackPane contenedorTexto = new StackPane(rectanguloTexto, informacion);
        contenedorTexto.setStyle("-fx-font-size: 1.5em;");
        contenedorTexto.setPadding(new Insets(80));

        Button enviar = new Button("Siguiente");
        enviar.setStyle("-fx-border-color: #000000; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");

        BotonPrimeraPreguntaEventHandler botonSiguiente = new BotonPrimeraPreguntaEventHandler(manejadorDeTurnos);
        enviar.setOnAction(botonSiguiente);

        VBox contenedorBoton = new VBox(enviar);
        contenedorBoton.setPadding(new Insets(180));
        contenedorBoton.setAlignment(Pos.BOTTOM_CENTER);

        contenedorPuntuaciones = new VBox(contenedorTexto, contenedorBoton);
        contenedorPuntuaciones.setMinWidth(Constantes.ANCHO_VENTANA);
        contenedorPuntuaciones.setMinHeight(Constantes.ALTO_VENTANA);

    }

    public Pane getLayout() {return contenedorPuntuaciones;}
}
