package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.BotonEnviarHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class LayoutVerdaderoFalso {

    protected Pane layout;

    public Pane getLayout() {return layout;}

    protected HBox obtenerContenedorDeOpcionesVoF(VerdaderoFalso verdaderoFalso, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos, Timeline tiempo){

        Button botonVerdadero = new Button(verdaderoFalso.getOpcionVerdadera().getOpcion());
        BotonEnviarHandler botonVerdaderoHandler = new BotonEnviarHandler(unJugador, new RespuestaUnica(verdaderoFalso.getOpcionVerdadera()), manejadorDeTurnos, tiempo);
        botonVerdadero.setOnAction(botonVerdaderoHandler);

        HBox contenedroVerdadero = new HBox(botonVerdadero);
        contenedroVerdadero.setPadding(new Insets(10));
        contenedroVerdadero.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button botonFalso = new Button(verdaderoFalso.getOpcionFalsa().getOpcion());
        BotonEnviarHandler botonFalsoHandler = new BotonEnviarHandler(unJugador, new RespuestaUnica(verdaderoFalso.getOpcionFalsa()), manejadorDeTurnos, tiempo);
        botonFalso.setOnAction(botonFalsoHandler);

        HBox contenedorFalso = new HBox(botonFalso);
        contenedorFalso.setPadding(new Insets(10));
        contenedorFalso.setBackground(new Background(new BackgroundFill(Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY)));

        HBox contenedorDeOpcionesVoF = new HBox(contenedroVerdadero, contenedorFalso);
        contenedorDeOpcionesVoF.setAlignment(Pos.CENTER);
        contenedorDeOpcionesVoF.setStyle("-fx-font-weight: bold");
        contenedorDeOpcionesVoF.setStyle("-fx-font-size: 1.5em;");

        contenedorDeOpcionesVoF.setSpacing(10);
        contenedorDeOpcionesVoF.setPadding(new Insets(15));

        return contenedorDeOpcionesVoF;
    }
}
