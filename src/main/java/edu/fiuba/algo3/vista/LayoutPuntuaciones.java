package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEnviarHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LayoutPuntuaciones{

    private Pane contenedorPuntuaciones;

    public LayoutPuntuaciones(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos){

        /*Label nombre = new Label("Actualmente los puntos de: " + jugador.getNombre() );
        nombre.setStyle("-fx-font-weight: bold");
        Label puntos = new Label("son: " + jugador.getPuntaje().getPuntos());
        puntos.setStyle("-fx-font-weight: bold");

        Rectangle rectangulo = new Rectangle(20, 20, 300, 100);
        rectangulo.setFill(Color.LAVENDER);

        VBox informacion = new VBox(nombre, puntos);
        informacion.setSpacing(10);
        informacion.setAlignment(Pos.CENTER);

        StackPane contenedorInformacion = new StackPane(rectangulo, informacion);
        contenedorInformacion.setPadding(new Insets(10));
        contenedorInformacion.setStyle("-fx-font-size: 1.3em;");
        */

        Label texto = new Label("Es el turno de: " + jugador.getNombre());
        texto.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloTexto = new Rectangle(20, 20, 300, 100);
        rectanguloTexto.setFill(Color.LAVENDER);

        StackPane contenedorTexto = new StackPane(rectanguloTexto, texto);
        contenedorTexto.setPadding(new Insets(10));
        contenedorTexto.setStyle("-fx-font-size: 1.3em;");

        Button enviar = new Button("Siguiente");
        enviar.setStyle("-fx-border-color: #A8E3E7; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");

        BotonSiguienteEventHandler botonSiguiente = new BotonSiguienteEventHandler(manejadorDeTurnos);
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
