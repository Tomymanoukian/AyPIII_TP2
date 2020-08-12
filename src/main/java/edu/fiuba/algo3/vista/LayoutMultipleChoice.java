package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSubirRespuestaHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class LayoutMultipleChoice extends VBox {

    private Pane layout;

    public LayoutMultipleChoice() {
        List<String> listaRespuestas = new ArrayList<>();

        Label nombreJugador = new Label("Jugador1");
        Label tiempo = new Label("00:00");
        //tiempo.setStyle("-fx-font-weight: bold");
        Label bonusX2 = new Label("X2");
        Label bonusX3 = new Label("X3");
        Label exclusividad = new Label("Exclusividad");

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

        Label consigna = new Label("Seleccione las opciones multiples");
        consigna.setStyle("-fx-font-weight: bold");

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(15));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        VBox checkBoxDeOpciones = new VBox();
        checkBoxDeOpciones.setAlignment(Pos.CENTER);
        String opciones[] = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5"};


        String opcionMostrarLabel="";
        for (int i = 0; i < opciones.length; i++) {
            // create a checkbox
            CheckBox checkBox = new CheckBox(opciones[i]);
            checkBox.setPadding(new Insets(5));
            // add label
            checkBoxDeOpciones.getChildren().add(checkBox);
            // set IndeterMinate
            checkBox.setIndeterminate(false);
            String opcion = opciones[i];

            // create a event handler
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e)
                {   String opcionMostrarLabel="";
                    if (checkBox.isSelected()) {
                        listaRespuestas.add(opcion);
                    }else {
                        listaRespuestas.remove(opcion);
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
        //BotonSiguienteHandler botonSiguiente = new BotonSiguienteHandler(listaRespuestas, this);
        //siguiente.setOnAction(botonSiguiente);

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
