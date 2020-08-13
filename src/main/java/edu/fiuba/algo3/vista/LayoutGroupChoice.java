package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LayoutGroupChoice extends VBox {

    private Pane layout;

    public LayoutGroupChoice (Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) pregunta;

        //Comienza primer renglón
        Label nombreJugador = new Label(jugador.getNombre());
        Label tiempo = new Label("00:00");

        Button bonusX2 = new Button("X2");
        bonusX2.setDisable(true);

        Button bonusX3 = new Button("X3");
        bonusX3.setDisable(true);

        Button exclusividad = new Button("Ex");
        /*BotonExclusividadHandlerGroupChoice exclusividadHandler = new BotonExclusividadHandlerGroupChoice(groupChoice, jugador, kahoot, unStage);
        exclusividad.setOnAction(exclusividadHandler);*/
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

        Label consigna = new Label(groupChoice.getConsigna());
        consigna.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 300, 100);
        rectanguloConsigna.setFill(Color.LAVENDER);

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(15));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        //Comienzan Opciones

        ListaOpciones listaOpcionesCentro = new ListaOpciones();
        listaOpcionesCentro.agregarTodo(groupChoice.getOpcionesGrupoA());
        listaOpcionesCentro.agregarTodo(groupChoice.getOpcionesGrupoB());
        listaOpcionesCentro.desordenar();

        VBox contenedorListaHBoxA = new VBox(10);
        ArrayList<HBox> listaHBoxA = new ArrayList<>();

        VBox contenedorListaHBoxCentro = new VBox(10);
        ArrayList<HBox> listaHBoxCentro = new ArrayList<>();

        VBox contenedorListaHBoxB = new VBox(10);
        ArrayList<HBox> listaHBoxB = new ArrayList<>();

        listaHBoxA.add(new HBox (new Label ("Grupo A")));
        listaHBoxCentro.add(new HBox (new Label ("Sin grupo")));
        listaHBoxB.add(new HBox (new Label ("Grupo B")));

        for (int i=0; i < listaOpcionesCentro.cantidadDeRespuestas(); i++) {

            Button botonDerechaA = new Button ("▶");
            Button botonIzquierdaCentro = new Button ("◀");
            Button botonDerechaCentro = new Button ("▶");
            Button botonIzquierdaB = new Button ("◀");

            listaHBoxA.add(new HBox (10, new Label (listaOpcionesCentro.obtener(i).getOpcion()), botonDerechaA));
            listaHBoxCentro.add(new HBox (10, botonIzquierdaCentro, new Label (listaOpcionesCentro.obtener(i).getOpcion()), botonDerechaCentro));
            listaHBoxB.add(new HBox (10, botonIzquierdaB, new Label (listaOpcionesCentro.obtener(i).getOpcion())));
/*
            BotonMoverAlCostadoHandler botonHandlerCentroaA = new BotonMoverAlCostadoHandler(listaOpcionesInicial, listaOpcionesObjetivo, jugador, kahoot, unStage);
            botonBajar.setOnAction(botonHandlerBajar);

            BotonSubirRespuestaHandler botonHandlerSubir = new BotonSubirRespuestaHandler(i, orderedChoice, jugador, kahoot, unStage);
            botonSubir.setOnAction(botonHandlerSubir);*/
        }

        contenedorListaHBoxA.getChildren().addAll(listaHBoxA);
        contenedorListaHBoxCentro.getChildren().addAll(listaHBoxCentro);
        contenedorListaHBoxB.getChildren().addAll(listaHBoxB);

        HBox contenedorOpciones = new HBox(50);
        contenedorOpciones.getChildren().addAll(contenedorListaHBoxA);
        contenedorOpciones.getChildren().addAll(contenedorListaHBoxCentro);
        contenedorOpciones.getChildren().addAll(contenedorListaHBoxB);
        contenedorOpciones.setAlignment(Pos.CENTER);

        Button botonEnviar = new Button ("Enviar");
        /*BotonEnviarOrderedChoiceHandler enviarHandler = new BotonEnviarOrderedChoiceHandler (orderedChoice, jugador, kahoot, unStage);
        botonEnviar.setOnAction(enviarHandler);*/

        HBox enviar = new HBox (botonEnviar);
        enviar.setAlignment(Pos.CENTER);

        //Se crea el layout final

        layout = new VBox(20,contenedorPrimerRenglon, contenedorConsigna, contenedorOpciones, enviar);
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}
}

