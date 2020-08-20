package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.BotonSiguienteEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.vista.Constantes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LayoutSiguienteJugador {

    private Pane contenedorPuntuaciones;

    public LayoutSiguienteJugador(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EventHandler<ActionEvent> handlerBotonEnviar){

        Label texto = new Label("Es el turno de: " + jugador.getNombre());
        Label puntos = new Label("sus puntos actuales son: " + jugador.getPuntaje().getPuntos());

        VBox informacion = new VBox(texto, puntos);
        informacion.setStyle("-fx-font-weight: bold");
        informacion.setAlignment(Pos.CENTER);
        informacion.setPadding(new Insets(50));
        informacion.setSpacing(40);

        Rectangle rectanguloTexto = new Rectangle(20, 20, Constantes.ANCHO_CONTENEDOR_CONSIGNA, Constantes.ALTO_CONTENEDOR_CONSIGNA);
        rectanguloTexto.setFill(Color.LAVENDER);

        StackPane contenedorTexto = new StackPane(rectanguloTexto, informacion);
        contenedorTexto.setStyle("-fx-font-size: 1.5em;");
        contenedorTexto.setPadding(new Insets(50));

        Button enviar = new Button("Siguiente");
        enviar.setStyle("-fx-border-color: #000000; -fx-font-size: 1.6em; -fx-background-color: #A8E3E7");
        enviar.setOnAction(handlerBotonEnviar);

        VBox contenedorBoton = new VBox(enviar);
        contenedorBoton.setPadding(new Insets(50));
        contenedorBoton.setAlignment(Pos.BOTTOM_RIGHT);

        contenedorPuntuaciones = new VBox(contenedorTexto, contenedorBoton);
        contenedorPuntuaciones.setMinWidth(Constantes.ANCHO_VENTANA);
        contenedorPuntuaciones.setMinHeight(Constantes.ALTO_VENTANA);
    }

    public Pane getLayout() {return contenedorPuntuaciones;}
}
