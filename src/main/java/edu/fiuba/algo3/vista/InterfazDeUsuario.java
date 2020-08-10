package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEmpezarJuegoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InterfazDeUsuario {
    private Stage stage;

    public  InterfazDeUsuario(Stage unaStage) {
        stage = unaStage;
    }

    public void vistaDeInicioDelKahoot() {
        stage.setTitle("Kahoot!");

        Label bienvenida = new Label("Bienvenidos a Kahoot");


        Label pedirNombreJugador1 = new Label("Ingrese nombre del Jugador 1");
        TextField nombreJugador1 = new TextField();
        Label pedirNombreJugador2 = new Label("Ingrese nombre del Jugador 2");
        TextField nombreJugador2 = new TextField();

        Button iniciarJuego = new Button("Iniciar Kahoot");

        BotonEmpezarJuegoEventHandler botonComienzoDeJuego = new BotonEmpezarJuegoEventHandler(nombreJugador1, nombreJugador2, this);
        iniciarJuego.setOnAction(botonComienzoDeJuego);


        VBox contenedorBienvenida = new VBox(bienvenida);
        VBox contenedorInsertarNombreJugador1 = new VBox(pedirNombreJugador1, nombreJugador1);
        VBox contenedorInsertarNombreJugador2 = new VBox(pedirNombreJugador2, nombreJugador2);

        VBox contenedorInicioDeKahoot = new VBox(contenedorBienvenida, contenedorInsertarNombreJugador1, contenedorInsertarNombreJugador2, iniciarJuego);

        Scene scene = new Scene(contenedorInicioDeKahoot, 400, 275);

        stage.setScene(scene);
        stage.show();
    }

    public void vistaVerdaderoFalso() {


        Label nombreJugador = new Label("Jugador1");
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
        contenedorPrimerRenglon.setPadding(new Insets(10));

        Label consigna = new Label("Kahoot es lo mejor que hay?");
        consigna.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 300, 100);
        rectanguloConsigna.setFill(Color.LAVENDER);

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(15));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");


        ToggleGroup grupoDeOpciones = new ToggleGroup();

        RadioButton verdadero = new RadioButton("Verdadero");
        HBox contenedroVerdadero = new HBox(verdadero);
        contenedroVerdadero.setPadding(new Insets(10));
        contenedroVerdadero.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        RadioButton falso = new RadioButton("Falso");
        HBox contenedorFalso = new HBox(falso);
        contenedorFalso.setPadding(new Insets(10));
        contenedorFalso.setBackground(new Background(new BackgroundFill(Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY)));

        verdadero.setToggleGroup(grupoDeOpciones);
        falso.setToggleGroup(grupoDeOpciones);

        HBox contenedorHorizontal = new HBox(contenedroVerdadero, contenedorFalso);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setStyle("-fx-font-weight: bold");
        contenedorHorizontal.setStyle("-fx-font-size: 1.5em;");

        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.setPadding(new Insets(15));

        VBox contendorPrincipal = new VBox(contenedorPrimerRenglon, contenedorConsigna, contenedorHorizontal);
        contendorPrincipal.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(contendorPrincipal, 400, 275);

        stage.setScene(scene);
        stage.show();

    }
}