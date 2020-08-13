package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonBajarRespuestaHandler;
import edu.fiuba.algo3.controlador.BotonEnviarOrderedChoiceHandler;
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

public class LayoutOrderedChoice extends VBox {

    private Pane layout;

    public LayoutOrderedChoice(Pregunta pregunta, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        OrderedChoice orderedChoice = (OrderedChoice) pregunta;

        //Comienza primer renglón
        Label nombreJugador = new Label(jugador.getNombre());
        Label tiempo = new Label("00:00");

        Button bonusX2 = new Button("X2");
        bonusX2.setDisable(true);

        Button bonusX3 = new Button("X3");
        bonusX3.setDisable(true);

        Button exclusividad = new Button("Ex");
        BotonExclusividadHandler exclusividadHandler = new BotonExclusividadHandler (orderedChoice, escenaOrderedChoice, jugador, manejadorDeTurnos);
        exclusividad.setOnAction(exclusividadHandler);
        if (jugador.getExclusividades().size()==0)
            exclusividad.setDisable(true);

        VBox contenedorNombreJugador = new VBox(nombreJugador);

        VBox contenedorTiempo = new VBox(tiempo);
        contenedorTiempo.setStyle("-fx-font-weight: bold");

        HBox contenedorBonus = new HBox(bonusX2, bonusX3, exclusividad);
        contenedorBonus.setSpacing(3);

        HBox contenedorPrimerRenglon = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);
        contenedorPrimerRenglon.setAlignment(Pos.CENTER);
        contenedorPrimerRenglon.setStyle("-fx-font-size: 1.25em;");
        contenedorPrimerRenglon.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorPrimerRenglon.setSpacing(40);
        contenedorPrimerRenglon.setPadding(new Insets(10));

        //Comienza cuadro de consigna

        Label consigna = new Label(orderedChoice.getConsigna());
        consigna.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 300, 100);
        rectanguloConsigna.setFill(Color.LAVENDER);

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(15));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        //Comienzan Opciones

        ArrayList<HBox> listaHBoxOpciones = new ArrayList<>();

        ListaOpciones opcionesMostradas = escenaOrderedChoice.getOpcionesMostradas();

        for (int i=0; i < opcionesMostradas.cantidadDeRespuestas(); i++) {

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
        listaHBoxOpciones.get(opcionesMostradas.cantidadDeRespuestas()-1).getChildren().get(0).setDisable(true);

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.getChildren().addAll(listaHBoxOpciones);

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesMostradas);

        Button botonEnviar = new Button ("Enviar");
        BotonEnviarOrderedChoiceHandler enviarHandler = new BotonEnviarOrderedChoiceHandler(jugador, respuesta, manejadorDeTurnos);
        botonEnviar.setOnAction(enviarHandler);

        HBox enviar = new HBox (botonEnviar);
        enviar.setAlignment(Pos.CENTER);

        contenedorOpciones.getChildren().add(enviar);
        contenedorOpciones.setAlignment(Pos.CENTER);

        layout = new VBox(contenedorPrimerRenglon, contenedorConsigna, contenedorOpciones);
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}
}
