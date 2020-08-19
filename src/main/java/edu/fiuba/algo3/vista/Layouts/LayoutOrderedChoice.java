package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.BotonBajarRespuestaHandler;
import edu.fiuba.algo3.controlador.BotonSubirRespuestaHandler;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaSinPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBotonEnviar;
import edu.fiuba.algo3.vista.Contenedores.ContenedorConsigna;
import edu.fiuba.algo3.vista.Contenedores.ContenedorPrimerReglonPreguntaSinPenalidad;
import edu.fiuba.algo3.vista.Escenas.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class LayoutOrderedChoice {

    private Pane layout;

    public LayoutOrderedChoice(Pregunta pregunta, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        ListaOpciones opcionesMostradas = escenaOrderedChoice.getOpcionesMostradas();

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesMostradas);

        EtiquetaTiempo unaEtiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(opcionesMostradas, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);

        ContenedorPrimerReglonPreguntaSinPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaSinPenalidad((PreguntaSinPenalidad) pregunta, escenaOrderedChoice, jugador, manejadorDeTurnos, respuesta, unaEtiquetaTiempo);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public LayoutOrderedChoice(Pregunta pregunta, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        ListaOpciones opcionesMostradas = escenaOrderedChoice.getOpcionesMostradas();

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(opcionesMostradas, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesMostradas);

        ContenedorPrimerReglonPreguntaSinPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaSinPenalidad((PreguntaSinPenalidad) pregunta, escenaOrderedChoice, jugador, manejadorDeTurnos, respuesta, unaEtiquetaTiempo);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}

    private VBox obtenerContenedorDeOpciones(ListaOpciones opcionesMostradas, EscenaOrderedChoice escenaOrderedChoice,
                                             Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        ArrayList<HBox> listaHBoxOpciones = new ArrayList<>();

        for (int i = 0; i < opcionesMostradas.cantidadDeOpciones(); i++) {

            Button botonBajar = new Button ("▼");
            Button botonSubir = new Button ("▲");

            listaHBoxOpciones.add(new HBox (botonBajar, new Label (opcionesMostradas.obtener(i).getOpcion()), botonSubir));
            listaHBoxOpciones.get(i).setAlignment(Pos.CENTER);

            BotonBajarRespuestaHandler botonHandlerBajar = new BotonBajarRespuestaHandler(i, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
            botonBajar.setOnAction(botonHandlerBajar);

            BotonSubirRespuestaHandler botonHandlerSubir = new BotonSubirRespuestaHandler(i, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
            botonSubir.setOnAction(botonHandlerSubir);
        }

        listaHBoxOpciones.get(0).getChildren().get(2).setDisable(true);
        listaHBoxOpciones.get(opcionesMostradas.cantidadDeOpciones()-1).getChildren().get(0).setDisable(true);

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.getChildren().addAll(listaHBoxOpciones);
        contenedorOpciones.setAlignment(Pos.CENTER);

        return contenedorOpciones;
    }
}
