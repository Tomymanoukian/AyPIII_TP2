package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutMultipleChoice {

    private Pane layout;

    public LayoutMultipleChoice(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        ListaOpciones listaRespuestas = new ListaOpciones();
        StackPane contenedorOpciones = this.obtenerContenedorDeOpciones(escenaMultipleChoice.getOpcionesMostradas(), listaRespuestas);
        RespuestaEnLista respuesta = new RespuestaEnLista(listaRespuestas);

        ContenedorPrimerReglon contenedorPrimerRenglon = new ContenedorPrimerReglon(pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, respuesta);
        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);
        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        VBox contendorPrincipal = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        contendorPrincipal.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout = new VBox(contendorPrincipal);
    }

    public LayoutMultipleChoice(Pregunta pregunta, EscenaMultipleChoice escenaMultipleChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        MultipleChoice unMultipleChoice = (MultipleChoice) pregunta;
        ListaOpciones listaRespuestas = new ListaOpciones();
        StackPane contenedorOpciones = this.obtenerContenedorDeOpciones(escenaMultipleChoice.getOpcionesMostradas(), listaRespuestas);
        RespuestaEnLista respuesta = new RespuestaEnLista(listaRespuestas);

        ContenedorPrimerReglon contenedorPrimerRenglon = new ContenedorPrimerReglon(pregunta, escenaMultipleChoice, jugador, manejadorDeTurnos, respuesta, unaEtiquetaTiempo);
        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);
        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        VBox contendorPrincipal = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        contendorPrincipal.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout = new VBox(contendorPrincipal);
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
}
