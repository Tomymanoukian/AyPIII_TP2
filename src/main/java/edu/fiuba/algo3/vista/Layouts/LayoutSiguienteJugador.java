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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static edu.fiuba.algo3.vista.Constantes.*;
import static edu.fiuba.algo3.vista.Constantes.ALTO_CINTA;

public class LayoutSiguienteJugador {

    private Pane layout;

    public LayoutSiguienteJugador(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EventHandler<ActionEvent> handlerBotonEnviar){

        HBox cinta = new HBox();
        cinta.setStyle(ESTILO_CINTA);
        cinta.setMinHeight(ALTO_CINTA);

        Label texto = new Label("Es el turno de: " + jugador.getNombre());

        VBox informacion = new VBox(texto);
        informacion.setStyle("-fx-font-weight: bold");
        informacion.setAlignment(Pos.CENTER);
        informacion.setSpacing(40);

        Rectangle rectanguloTexto = new Rectangle(20, 20,450, Constantes.ALTO_CONTENEDOR_CONSIGNA);
        rectanguloTexto.setFill(Color.web(COLOR_CONTENEDOR_CONSIGNA));

        StackPane contenedorTexto = new StackPane(rectanguloTexto, informacion);
        contenedorTexto.setStyle("-fx-font-size: 1.5em;");
        contenedorTexto.setPadding(new Insets(80));


        Button enviar = new Button("Siguiente");
        enviar.setStyle(ESTILO_BOTONES);
        enviar.setOnAction(handlerBotonEnviar);

        VBox contenedorBoton = new VBox(enviar);
        contenedorBoton.setPadding(new Insets(180));
        contenedorBoton.setAlignment(Pos.BOTTOM_CENTER);

        layout = new VBox(cinta, contenedorTexto, contenedorBoton);
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}
}
