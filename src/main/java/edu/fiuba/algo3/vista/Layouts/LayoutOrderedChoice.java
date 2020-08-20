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

import static edu.fiuba.algo3.vista.Constantes.*;

public class LayoutOrderedChoice {

    private VBox layout;
    private ListaOpciones opcionesMostradas;
    private RespuestaEnLista respuesta;

    public LayoutOrderedChoice(Pregunta pregunta, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        this.obtenerRespuesta(escenaOrderedChoice);

        EtiquetaTiempo unaEtiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);

        this.crearLayout(pregunta, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    public LayoutOrderedChoice(Pregunta pregunta, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        this.obtenerRespuesta(escenaOrderedChoice);

        this.crearLayout(pregunta, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }


    public Pane getLayout() {return layout;}

    private void obtenerRespuesta(EscenaOrderedChoice escenaOrderedChoice) {

        opcionesMostradas = escenaOrderedChoice.getOpcionesMostradas();

        respuesta = new RespuestaEnLista(opcionesMostradas);
    }

    private VBox obtenerContenedorDeOpciones(EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        ArrayList<HBox> listaHBoxOpciones = new ArrayList<>();

        for (int i = 0; i < opcionesMostradas.cantidadDeOpciones(); i++) {

            Button botonBajar = new Button ("▼");

            Label opcionMostrada = new Label (opcionesMostradas.obtener(i).getOpcion());
            opcionMostrada.setPrefWidth(ANCHO_OPCION-70);
            opcionMostrada.setAlignment(Pos.CENTER);

            Button botonSubir = new Button ("▲");

            HBox linea = new HBox (botonBajar, opcionMostrada, botonSubir);
            linea.setBackground(new Background(new BackgroundFill(Color.web(COLOR_OPCIONES), CornerRadii.EMPTY, Insets.EMPTY)));
            linea.setMinSize(ANCHO_OPCION, 40);
            linea.setMaxSize(ANCHO_OPCION, 40);
            linea.setAlignment(Pos.CENTER);

            listaHBoxOpciones.add(linea);

            BotonBajarRespuestaHandler botonHandlerBajar = new BotonBajarRespuestaHandler(i, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
            botonBajar.setOnAction(botonHandlerBajar);

            BotonSubirRespuestaHandler botonHandlerSubir = new BotonSubirRespuestaHandler(i, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
            botonSubir.setOnAction(botonHandlerSubir);
        }

        listaHBoxOpciones.get(0).getChildren().get(2).setDisable(true);
        listaHBoxOpciones.get(opcionesMostradas.cantidadDeOpciones()-1).getChildren().get(0).setDisable(true);

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.getChildren().addAll(listaHBoxOpciones);

        contenedorOpciones.setBackground(new Background(new BackgroundFill(Color.web(COLOR_CONTENEDOR_CONSIGNA), CornerRadii.EMPTY, new Insets(-20))));
        contenedorOpciones.setMaxWidth(ANCHO_OPCION);
        contenedorOpciones.setAlignment(Pos.CENTER);

        return contenedorOpciones;
    }

    private void crearLayout(Pregunta pregunta, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);

        ContenedorPrimerReglonPreguntaSinPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaSinPenalidad((PreguntaSinPenalidad) pregunta, escenaOrderedChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.TOP_CENTER);
    }
}
