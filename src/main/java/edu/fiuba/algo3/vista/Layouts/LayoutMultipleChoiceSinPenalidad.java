package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaSinPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBotonEnviar;
import edu.fiuba.algo3.vista.Contenedores.ContenedorConsigna;
import edu.fiuba.algo3.vista.Contenedores.ContenedorPrimerReglonPreguntaSinPenalidad;
import edu.fiuba.algo3.vista.Escenas.EscenaMultipleChoice;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LayoutMultipleChoiceSinPenalidad {

    private Pane layout;
    private ListaOpciones listaRespuestas;
    private RespuestaEnLista respuesta;

    public LayoutMultipleChoiceSinPenalidad(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        listaRespuestas = new ListaOpciones();
        respuesta = new RespuestaEnLista(listaRespuestas);

        EtiquetaTiempo unaEtiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);

        this.crearLayout(pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);

    }

    public LayoutMultipleChoiceSinPenalidad(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

         listaRespuestas = new ListaOpciones();
         respuesta = new RespuestaEnLista(listaRespuestas);

        this.crearLayout(pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    public Pane getLayout() {return layout;}

    private StackPane obtenerContenedorDeOpciones(ListaOpciones opcionesMostradas, ListaOpciones listaRespuestas){

        VBox checkBoxDeOpciones = new VBox();
        checkBoxDeOpciones.setAlignment(Pos.CENTER);

        int cantidadDeOpcionesAMostrar = opcionesMostradas.cantidadDeOpciones();

        for (int i = 0; i < cantidadDeOpcionesAMostrar; i++) {

            CheckBox checkBox = new CheckBox(opcionesMostradas.obtener(i).getOpcion());
            checkBox.setPadding(new Insets(5));

            checkBoxDeOpciones.getChildren().add(checkBox);

            checkBox.setIndeterminate(false);
            String opcion = opcionesMostradas.obtener(i).getOpcion();
            Puntaje puntaje = opcionesMostradas.obtener(i).getPuntaje();

            EventHandler<ActionEvent> event = e -> {

                if (checkBox.isSelected())
                    listaRespuestas.agregar(new Opcion(opcion, puntaje));
                else
                    listaRespuestas.eliminar(opcion);
            };

            checkBox.setOnAction(event);
        }

        Rectangle rectanguloOpciones = new Rectangle(20, 20, 250, 150);
        rectanguloOpciones.setFill(Color.LIGHTGRAY);

        StackPane contenedorOpciones = new StackPane(rectanguloOpciones, checkBoxDeOpciones);
        contenedorOpciones.setStyle("-fx-font-size: 1.2em;");

        return contenedorOpciones;
    }

    private void crearLayout(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        ContenedorPrimerReglonPreguntaSinPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaSinPenalidad((PreguntaSinPenalidad) pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);
        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());
        StackPane contenedorOpciones = this.obtenerContenedorDeOpciones(escenaMultipleChoice.getOpcionesMostradas(), listaRespuestas);

        VBox contendorPrincipal = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        contendorPrincipal.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout = new VBox(contendorPrincipal);
    }
}
