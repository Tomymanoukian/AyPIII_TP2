package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ContenedorPrimerReglon {

    private HBox layout;
    private EtiquetaTiempo etiquetaTiempo;
    private Button bonusX2;
    private Button bonusX3;
    private Button exclusividad;

    public ContenedorPrimerReglon(Pregunta pregunta, Escena escena, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, Respuesta respuesta){

        Label nombreJugador = new Label(jugador.getNombre());
        etiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);//Label tiempo = new Label("00:00");

        bonusX2 = new Button("X2");
        BotonMultiplicadorX2EventHandler multiplicX2Handler = new BotonMultiplicadorX2EventHandler(pregunta, escena, jugador, manejadorDeTurnos);
        bonusX2.setOnAction(multiplicX2Handler);

        bonusX3 = new Button("X3");
        BotonMultiplicadorx3EventHandler multiplicX3Handler = new BotonMultiplicadorx3EventHandler(pregunta, escena, jugador, manejadorDeTurnos);
        bonusX3.setOnAction(multiplicX3Handler);

        exclusividad = new Button("Ex");
        BotonExclusividadHandler exclusividadHandler = new BotonExclusividadHandler (pregunta, escena, jugador, manejadorDeTurnos);
        exclusividad.setOnAction(exclusividadHandler);

        VBox contenedorNombreJugador = new VBox(nombreJugador);
        VBox contenedorTiempo = new VBox(etiquetaTiempo.getLabel());
        HBox contenedorBonus = new HBox(bonusX2, bonusX3, exclusividad);
        contenedorBonus.setSpacing(3);

        this.habilitarBonusPosibles(pregunta, jugador);

        layout = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);

        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-font-size: 1.25em;");
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setSpacing(40);
        layout.setPadding(new Insets(10));
    }

    public HBox getLayout() {return layout;}

    public Timeline getTiempo(){
        return etiquetaTiempo.getTiempo();
    }

    private void habilitarBonusPosibles(Pregunta pregunta, Jugador jugador){

        if(pregunta.aceptaMultiplicador()){

            exclusividad.setDisable(true);

            if (jugador.getMultiplicadoresX2().size()==0)
                bonusX2.setDisable(true);
            if (jugador.getMultiplicadoresX3().size()==0)
                bonusX3.setDisable(true);

        }else if(pregunta.aceptaExclusividad()){

            bonusX2.setDisable(true);
            bonusX3.setDisable(true);

            if(jugador.getExclusividades().size()==0)
                exclusividad.setDisable(true);
        }
    }
}
