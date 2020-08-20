package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBotonEnviar;
import edu.fiuba.algo3.vista.Contenedores.ContenedorConsigna;
import edu.fiuba.algo3.vista.Contenedores.ContenedorPrimerReglonPreguntaConPenalidad;
import edu.fiuba.algo3.vista.Escenas.EscenaMultipleChoice;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class LayoutMultipleChoiceConPenalidad extends LayoutMultipleChoice{

    public LayoutMultipleChoiceConPenalidad(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        listaRespuestas = new ListaOpciones();
        respuesta = new RespuestaEnLista(listaRespuestas);

        EtiquetaTiempo unaEtiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);

        this.crearLayout(pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    public LayoutMultipleChoiceConPenalidad(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        listaRespuestas = new ListaOpciones();
        respuesta = new RespuestaEnLista(listaRespuestas);

        this.crearLayout(pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    private void crearLayout(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        ContenedorPrimerReglonPreguntaConPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaConPenalidad((PreguntaConPenalidad) pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);
        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());
        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(escenaMultipleChoice.getOpcionesMostradas(), listaRespuestas);

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.TOP_CENTER);
    }
}
