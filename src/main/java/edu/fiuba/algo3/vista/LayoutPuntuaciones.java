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

public class LayoutPuntuaciones {

    private Pane contenedorPuntuaciones;

    public LayoutPuntuaciones(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos){

        Label nombre = new Label("Actualmente los puntos de: " + jugador.getNombre() );
        Label puntos = new Label("son: " + jugador.getPuntaje().getPuntos());

        Rectangle rectangulo = new Rectangle(20, 20, 300, 100);
        rectangulo.setFill(Color.LAVENDER);

        VBox informacion = new VBox(nombre, puntos);
        informacion.setSpacing(10);
        informacion.setAlignment(Pos.CENTER);

        StackPane contenedor = new StackPane(rectangulo, informacion);
        contenedor.setPadding(new Insets(10));
        contenedor.setStyle("-fx-font-size: 1.3em;");

        Button enviar = new Button("Siguiente");
        enviar.setStyle("-fx-border-color: #A8E3E7; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");

        BotonSiguienteEventHandler botonEnviarHandler = new BotonSiguienteEventHandler(manejadorDeTurnos);
        enviar.setOnAction(botonEnviarHandler);



        contenedorPuntuaciones = new VBox(contenedor, enviar);

    }

    public Pane getLayout() {return contenedorPuntuaciones;}

}
