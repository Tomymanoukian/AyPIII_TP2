package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonBajarRespuestaHandler;
import edu.fiuba.algo3.controlador.BotonEnviarHandler;
import edu.fiuba.algo3.controlador.BotonExclusividadHandler;
import edu.fiuba.algo3.controlador.BotonSubirRespuestaHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class LayoutOrderedChoice {

    private Pane layout;

    public LayoutOrderedChoice(Pregunta pregunta, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        OrderedChoice orderedChoice = (OrderedChoice) pregunta;

        //Comienzan Opciones

        ListaOpciones opcionesMostradas = escenaOrderedChoice.getOpcionesMostradas();

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(opcionesMostradas, escenaOrderedChoice, jugador, manejadorDeTurnos);

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesMostradas);

        ContenedorPrimerReglon contenedorPrimerRenglon = new ContenedorPrimerReglon(pregunta, escenaOrderedChoice, jugador, manejadorDeTurnos, respuesta);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}

    private VBox obtenerContenedorDeOpciones(ListaOpciones opcionesMostradas, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos){

        ArrayList<HBox> listaHBoxOpciones = new ArrayList<>();

        for (int i = 0; i < opcionesMostradas.cantidadDeOpciones(); i++) {

            Button botonBajar = new Button ("▼");
            Button botonSubir = new Button ("▲");

            listaHBoxOpciones.add(new HBox (botonBajar, new Label (opcionesMostradas.obtener(i).getOpcion()), botonSubir));
            listaHBoxOpciones.get(i).setAlignment(Pos.CENTER);

            BotonBajarRespuestaHandler botonHandlerBajar = new BotonBajarRespuestaHandler(i, escenaOrderedChoice, jugador, manejadorDeTurnos);
            botonBajar.setOnAction(botonHandlerBajar);

            BotonSubirRespuestaHandler botonHandlerSubir = new BotonSubirRespuestaHandler(i, escenaOrderedChoice, jugador, manejadorDeTurnos);
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
