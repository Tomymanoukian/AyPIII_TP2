package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LayoutVerdaderoFalso extends VBox{

    private Pane layout;

    public LayoutVerdaderoFalso(Pregunta pregunta, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos) {

        VerdaderoFalso verdaderoFalso = (VerdaderoFalso)pregunta;
        Kahoot kahoot = manejadorDeTurnos.getKahoot();
        Stage stage = manejadorDeTurnos.getStage();

        Label nombreJugador = new Label(unJugador.getNombre());
        Label tiempo = new Label("00:00");

        Button bonusX2 = new Button("X2");
        BotonMultipX2VoFEventHandler multiplicX2Handler = new BotonMultipX2VoFEventHandler(pregunta, unJugador, manejadorDeTurnos);
        bonusX2.setOnAction(multiplicX2Handler);

        Button bonusX3 = new Button("X3");
        BotonMultipX3VoFEventHandler multiplicX3Handler = new BotonMultipX3VoFEventHandler(pregunta, unJugador, manejadorDeTurnos);
        bonusX3.setOnAction(multiplicX3Handler);

        Button exclusividad = new Button("Ex");
        BotonExclusividadVoFEventHandler exclusividadHandler = new BotonExclusividadVoFEventHandler (pregunta, unJugador, manejadorDeTurnos);
        exclusividad.setOnAction(exclusividadHandler);

        if(verdaderoFalso.getClass() == VerdaderoFalsoConPenalidad.class){
            exclusividad.setDisable(true);

            if (unJugador.getMultiplicadoresX2().size()==0)
                bonusX2.setDisable(true);
            if (unJugador.getMultiplicadoresX3().size()==0)
                bonusX3.setDisable(true);

        }else if(verdaderoFalso.getClass() != VerdaderoFalsoConPenalidad.class ){
            bonusX2.setDisable(true);
            bonusX3.setDisable(true);

            if(unJugador.getExclusividades().size()==0)
                exclusividad.setDisable(true);
        }

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


        Button botonVerdadero = new Button(verdaderoFalso.getOpcionCorrecta().getOpcion());
        botonVerdadero.setOnAction(new BotonVerdaderoEventHandler(verdaderoFalso.getOpcionCorrecta(), unJugador,kahoot, stage));
        HBox contenedroVerdadero = new HBox(botonVerdadero);
        contenedroVerdadero.setPadding(new Insets(10));
        contenedroVerdadero.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button botonFalso = new Button(verdaderoFalso.getOpcionIncorrecta().getOpcion());
        botonFalso.setOnAction(new BotonFalsoEventHandler(verdaderoFalso.getOpcionIncorrecta(), unJugador, kahoot, stage));
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
