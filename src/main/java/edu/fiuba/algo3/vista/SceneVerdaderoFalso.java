package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonFalsoEventHandler;
import edu.fiuba.algo3.controlador.BotonVerdaderoEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;

public class SceneVerdaderoFalso extends VBox{

    private Pane layout;

    public SceneVerdaderoFalso(Jugador unJugador, Opcion opcionVerdadero, Opcion opcionFalso, Kahoot kahoot) {

        Label nombreJugador = new Label(unJugador.getNombre());
        Label tiempo = new Label("00:00");
        Label bonusX2 = new Label("X2");
        Label bonusX3 = new Label("X3");
        Label exclusividad = new Label("Exclusividad");

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
        contenedorPrimerRenglon.setPadding(new Insets(20));

        Label consigna = new Label("Kahoot es lo mejor que hay?");
        consigna.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 350, 125);
        rectanguloConsigna.setFill(Color.LAVENDER);

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(20));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        Button botonVerdadero = new Button(opcionVerdadero.getOpcion());
        botonVerdadero.setOnAction(new BotonVerdaderoEventHandler(opcionVerdadero,kahoot));
        HBox contenedroVerdadero = new HBox(botonVerdadero);
        contenedroVerdadero.setPadding(new Insets(10));
        contenedroVerdadero.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button botonFalso = new Button(opcionFalso.getOpcion());
        botonFalso.setOnAction(new BotonFalsoEventHandler(opcionFalso,kahoot));
        HBox contenedorFalso = new HBox(botonFalso);
        contenedorFalso.setPadding(new Insets(10));
        contenedorFalso.setBackground(new Background(new BackgroundFill(Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY)));


        HBox contenedorHorizontal = new HBox(contenedroVerdadero, contenedorFalso);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setStyle("-fx-font-weight: bold");
        contenedorHorizontal.setStyle("-fx-font-size: 1.5em;");

        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(15));

        layout = new VBox(contenedorPrimerRenglon, contenedorConsigna, contenedorHorizontal);
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}

    public void mostrarVista(Pane unosLayouts) {

        unosLayouts.getChildren().forEach(element -> element.setVisible(false));
        layout.setVisible(true);
    }
}