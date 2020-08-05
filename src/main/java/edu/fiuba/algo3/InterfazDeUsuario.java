package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class InterfazDeUsuario extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kahoot!");


        Label nombreJugador = new Label("Jugador1");
        Label tiempo = new Label("00:00");
        Label bonusX2 = new Label("X2");
        Label bonusX3 = new Label("X3");
        Label exclusividad = new Label("Exclusividad");
        //HBox contenedorNombreJugador = new HBox(nombreJugador);

        HBox contenedorBonus = new HBox(bonusX2, bonusX3, exclusividad);
        contenedorBonus.setSpacing(3);

        HBox contenedorPrimerRenglon = new HBox(nombreJugador, tiempo, contenedorBonus);
        contenedorPrimerRenglon.setSpacing(25);
        contenedorPrimerRenglon.setPadding(new Insets(20));

        Label consigna = new Label("Texto de la consigna");
        HBox contenedorConsigna = new HBox((consigna));
        contenedorConsigna.setPadding(new Insets(15));

        ToggleGroup grupoDeOpciones = new ToggleGroup();
        RadioButton verdadero = new RadioButton("Verdadero");
        RadioButton falso = new RadioButton("Falso");
        verdadero.setToggleGroup(grupoDeOpciones);
        falso.setToggleGroup(grupoDeOpciones);

        HBox contenedorHorizontal = new HBox(verdadero, falso);
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(15));

        VBox contendorPrincipal = new VBox(contenedorPrimerRenglon, contenedorConsigna, contenedorHorizontal);
        //contendorPrincipal.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(contendorPrincipal, 400, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
