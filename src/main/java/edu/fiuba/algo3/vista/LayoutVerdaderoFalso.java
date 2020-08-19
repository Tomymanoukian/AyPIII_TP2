package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;

public class LayoutVerdaderoFalso {

    private Pane layout;

    public LayoutVerdaderoFalso(Pregunta pregunta, Escena scene, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos) {

        VerdaderoFalso verdaderoFalso = (VerdaderoFalso)pregunta;

        ContenedorPrimerReglon contenedorPrimerReglon = new ContenedorPrimerReglon(verdaderoFalso, scene, unJugador, manejadorDeTurnos, new RespuestaUnica(verdaderoFalso.getOpcionIncorrecta()));

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        HBox contenedorVerdaderoFalso = this.obtenerContenedorDeOpcionesVoF(verdaderoFalso, unJugador, manejadorDeTurnos, contenedorPrimerReglon.getTiempo());

        layout = new VBox(contenedorPrimerReglon.getLayout(), contenedorConsigna.getLayout(), contenedorVerdaderoFalso);
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public LayoutVerdaderoFalso(Pregunta pregunta, Escena scene, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        VerdaderoFalso verdaderoFalso = (VerdaderoFalso)pregunta;

        ContenedorPrimerReglon contenedorPrimerReglon = new ContenedorPrimerReglon(verdaderoFalso, scene, unJugador, manejadorDeTurnos, new RespuestaUnica(verdaderoFalso.getOpcionIncorrecta()), unaEtiquetaTiempo);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        HBox contenedorVerdaderoFalso = this.obtenerContenedorDeOpcionesVoF(verdaderoFalso, unJugador, manejadorDeTurnos, contenedorPrimerReglon.getTiempo());

        layout = new VBox(contenedorPrimerReglon.getLayout(), contenedorConsigna.getLayout(), contenedorVerdaderoFalso);
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}

    private HBox obtenerContenedorDeOpcionesVoF(VerdaderoFalso verdaderoFalso, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos, Timeline tiempo){

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
