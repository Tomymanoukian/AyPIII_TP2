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

import java.util.ArrayList;
import java.util.List;

public class LayoutMultipleChoice extends VBox {

    private Pane layout;

    public LayoutMultipleChoice(Pregunta pregunta, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos) {

        MultipleChoice unMultipleChoice = (MultipleChoice) pregunta;
        Kahoot kahoot = manejadorDeTurnos.getKahoot();
        Stage unStage = manejadorDeTurnos.getStage();

        ListaOpciones listaRespuestas = new ListaOpciones();

        Label nombreJugador = new Label(unJugador.getNombre());
        Label tiempo = new Label("00:00");
        //tiempo.setStyle("-fx-font-weight: bold");

        Button bonusX2 = new Button("X2");
        BotonMultipX2MultipleChoiceEventHandler multiplicX2Handler = new BotonMultipX2MultipleChoiceEventHandler(unMultipleChoice, unJugador, kahoot, unStage, manejadorDeTurnos);
        bonusX2.setOnAction(multiplicX2Handler);

        Button bonusX3 = new Button("X3");
        BotonMultipX3MultipleChoiceEventHandler multiplicX3Handler = new BotonMultipX3MultipleChoiceEventHandler(unMultipleChoice, unJugador, kahoot, unStage, manejadorDeTurnos);
        bonusX3.setOnAction(multiplicX3Handler);

        Button exclusividad = new Button("Ex");
        BotonExclusividadMultipleChoiceEventHandler exclusividadHandler = new BotonExclusividadMultipleChoiceEventHandler (unMultipleChoice, unJugador, kahoot, unStage, manejadorDeTurnos);
        exclusividad.setOnAction(exclusividadHandler);

        if(unMultipleChoice.getClass() == MultipleChoiceClasico.class){
            exclusividad.setDisable(true);

            if (unJugador.getMultiplicadoresX2().size()==0)
                bonusX2.setDisable(true);
            if (unJugador.getMultiplicadoresX3().size()==0)
                bonusX3.setDisable(true);

        }else if(unMultipleChoice.getClass() != MultipleChoiceClasico.class ){
            bonusX2.setDisable(true);
            bonusX3.setDisable(true);

            if(unJugador.getExclusividades().size()==0)
                exclusividad.setDisable(true);
        }

        VBox contenedorNombreJugador = new VBox(nombreJugador);
        VBox contenedorTiempo = new VBox(tiempo);
        HBox contenedorBonus = new HBox(bonusX2, bonusX3, exclusividad);
        contenedorBonus.setSpacing(3);

        HBox contenedorPrimerRenglon = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);
        contenedorPrimerRenglon.setAlignment(Pos.CENTER);
        contenedorPrimerRenglon.setStyle("-fx-font-size: 1.25em;");
        contenedorPrimerRenglon.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorPrimerRenglon.setSpacing(40);
        contenedorPrimerRenglon.setPadding(new Insets(10));

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 350, 60);
        rectanguloConsigna.setFill(Color.LAVENDER);

        Label consigna = new Label("Seleccione las opciones multiples"); //UTILIZAR LA CONSIGNA DE LA PREGUNTA
        consigna.setStyle("-fx-font-weight: bold");

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(15));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        VBox checkBoxDeOpciones = new VBox();
        checkBoxDeOpciones.setAlignment(Pos.CENTER);

        int cantidadDeOpcionesAMostrar = unMultipleChoice.getOpcionesCorrectas().cantidadDeRespuestas() + unMultipleChoice.getOpcionesIncorrectas().cantidadDeRespuestas();

        ListaOpciones opciones = unMultipleChoice.getTodasLasOpcionesMezcladas();

        for (int i = 0; i < cantidadDeOpcionesAMostrar; i++) {
            // create a checkbox
            CheckBox checkBox = new CheckBox(opciones.obtener(i).getOpcion());
            checkBox.setPadding(new Insets(5));
            // add label
            checkBoxDeOpciones.getChildren().add(checkBox);
            // set IndeterMinate
            checkBox.setIndeterminate(false);
            String opcion = opciones.obtener(i).getOpcion();

            // create a event handler
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e)
                {
                    if (checkBox.isSelected()) {
                        listaRespuestas.agregar(new Opcion(opcion));
                    }else {
                        listaRespuestas.eliminar(opcion);
                    }
                }
            };
            checkBox.setOnAction(event);
        }

        Rectangle rectanguloOpciones = new Rectangle(20, 20, 250, 150);
        rectanguloOpciones.setFill(Color.LIGHTGRAY);

        StackPane contenedorOpciones = new StackPane(rectanguloOpciones, checkBoxDeOpciones);
        contenedorConsigna.setStyle("-fx-font-size: 1.2em;");

        Button siguiente = new Button("Siguiente");
        siguiente.setStyle("-fx-border-color: #000000; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");
        HBox contenedorBoton = new HBox(siguiente);

        BotonEnviarMultipleChoiceHandler botonEnviar = new BotonEnviarMultipleChoiceHandler(unMultipleChoice, unJugador, listaRespuestas, kahoot, unStage);
        siguiente.setOnAction(botonEnviar);

        VBox contendorPrincipal = new VBox(contenedorPrimerRenglon, contenedorConsigna, contenedorOpciones, contenedorBoton);

        contenedorBoton.setAlignment(Pos.BOTTOM_RIGHT);
        contenedorBoton.setPadding(new Insets(40));

        contendorPrincipal.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        layout = new VBox(contendorPrincipal);
    }

    public Pane getLayout() {return layout;}

    public void mostrarVista(Pane unosLayouts) {

        unosLayouts.getChildren().forEach(element -> element.setVisible(false));
        layout.setVisible(true);
    }

}
