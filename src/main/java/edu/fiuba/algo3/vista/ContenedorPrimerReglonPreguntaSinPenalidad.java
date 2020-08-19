package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaConPenalidad;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaSinPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ContenedorPrimerReglonPreguntaSinPenalidad {

    private HBox layout;
    private EtiquetaTiempo etiquetaTiempo;
    private Button bonusX2;
    private Button bonusX3;
    private Button exclusividad;

    public ContenedorPrimerReglonPreguntaSinPenalidad(PreguntaSinPenalidad pregunta, Escena escena, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, Respuesta respuesta) {

        System.out.println("se crea un primer renglon sin penalidad 1");

        Label nombreJugador = new Label(jugador.getNombre());
        etiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);//Label tiempo = new Label("00:00");

        bonusX2 = new Button("X2");
        bonusX2.setDisable(true);

        bonusX3 = new Button("X3");
        bonusX3.setDisable(true);

        exclusividad = new Button("Ex");
        BotonExclusividadHandler exclusividadHandler = new BotonExclusividadHandler(pregunta, escena, jugador, manejadorDeTurnos, etiquetaTiempo);
        exclusividad.setOnAction(exclusividadHandler);

        VBox contenedorNombreJugador = new VBox(nombreJugador);
        VBox contenedorTiempo = new VBox(etiquetaTiempo.getLabel());
        HBox contenedorBonus = new HBox(bonusX2, bonusX3, exclusividad);
        contenedorBonus.setSpacing(3);

        this.habilitarExcepciones(jugador);

        layout = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);

        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-font-size: 1.25em;");
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setSpacing(40);
        layout.setPadding(new Insets(10));
    }

    public ContenedorPrimerReglonPreguntaSinPenalidad(PreguntaSinPenalidad pregunta, Escena escena, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, Respuesta respuesta, EtiquetaTiempo unaEtiquetaTiempo) {

        System.out.println("se crea un primer renglon sin penalidad 2");

        Label nombreJugador = new Label(jugador.getNombre());
        etiquetaTiempo = unaEtiquetaTiempo;//Label tiempo = new Label("00:00");

        bonusX2 = new Button("X2");
        bonusX2.setDisable(true);

        bonusX3 = new Button("X3");
        bonusX3.setDisable(true);

        exclusividad = new Button("Ex");
        BotonExclusividadHandler exclusividadHandler = new BotonExclusividadHandler(pregunta, escena, jugador, manejadorDeTurnos, etiquetaTiempo);
        exclusividad.setOnAction(exclusividadHandler);

        VBox contenedorNombreJugador = new VBox(nombreJugador);
        VBox contenedorTiempo = new VBox(etiquetaTiempo.getLabel());
        HBox contenedorBonus = new HBox(bonusX2, bonusX3, exclusividad);
        contenedorBonus.setSpacing(3);

        this.habilitarExcepciones(jugador);

        layout = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);

        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-font-size: 1.25em;");
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setSpacing(40);
        layout.setPadding(new Insets(10));
    }

    public HBox getLayout() {
        return layout;
    }

    public Timeline getTiempo() {
        return etiquetaTiempo.getTiempo();
    }

    private void habilitarExcepciones(Jugador jugador) {

        if (jugador.cantExclusividadesRestantes() == 0) {
            exclusividad.setDisable(true);
        }
    }
}
