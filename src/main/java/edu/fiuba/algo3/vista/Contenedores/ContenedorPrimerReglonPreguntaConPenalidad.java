package edu.fiuba.algo3.vista.Contenedores;

import edu.fiuba.algo3.controlador.BotonMultiplicadorX2EventHandler;
import edu.fiuba.algo3.controlador.BotonMultiplicadorx3EventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.Escenas.Escena;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.COLOR_CINTA;

public class ContenedorPrimerReglonPreguntaConPenalidad {

    private HBox layout;
    private EtiquetaTiempo etiquetaTiempo;
    private Button bonusX2;
    private Button bonusX3;
    private Button exclusividad;

    public ContenedorPrimerReglonPreguntaConPenalidad(PreguntaConPenalidad pregunta, Escena escena, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, Respuesta respuesta){

        Label nombreJugador = new Label(jugador.getNombre());
        etiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);//Label tiempo = new Label("00:00");

        bonusX2 = new Button("X2");
        BotonMultiplicadorX2EventHandler multiplicX2Handler = new BotonMultiplicadorX2EventHandler(pregunta, escena, jugador, manejadorDeTurnos, etiquetaTiempo);
        bonusX2.setOnAction(multiplicX2Handler);
        ContenedorBonus contenedorBonusX2 = new ContenedorBonus(bonusX2, jugador.cantMultiplicadoresX2Restantes());

        bonusX3 = new Button("X3");
        BotonMultiplicadorx3EventHandler multiplicX3Handler = new BotonMultiplicadorx3EventHandler(pregunta, escena, jugador, manejadorDeTurnos, etiquetaTiempo);
        bonusX3.setOnAction(multiplicX3Handler);
        ContenedorBonus contenedorBonusX3 = new ContenedorBonus(bonusX3, jugador.cantMultiplicadoresX3Restantes());

        exclusividad = new Button("Ex");
        exclusividad.setDisable(true);
        ContenedorBonus contenedorExclusividad = new ContenedorBonus(exclusividad, jugador.cantExclusividadesRestantes());

        VBox contenedorNombreJugador = new VBox(nombreJugador);
        VBox contenedorTiempo = new VBox(etiquetaTiempo.getLabel());
        HBox contenedorBonus = new HBox(contenedorBonusX2.getLayout(), contenedorBonusX3.getLayout(), contenedorExclusividad.getLayout());
        contenedorBonus.setSpacing(3);

        this.habilitarMultiplicadores(jugador);

        layout = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);

        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-font-size: 1.25em;");
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_CINTA), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setSpacing(40);
        layout.setPadding(new Insets(10));
    }

    public ContenedorPrimerReglonPreguntaConPenalidad(PreguntaConPenalidad pregunta, Escena escena, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, Respuesta respuesta, EtiquetaTiempo unaEtiquetaTiempo){

        Label nombreJugador = new Label(jugador.getNombre());
        etiquetaTiempo = unaEtiquetaTiempo;//Label tiempo = new Label("00:00");

        bonusX2 = new Button("X2");
        BotonMultiplicadorX2EventHandler multiplicX2Handler = new BotonMultiplicadorX2EventHandler(pregunta, escena, jugador, manejadorDeTurnos, etiquetaTiempo);
        bonusX2.setOnAction(multiplicX2Handler);
        ContenedorBonus contenedorBonusX2 = new ContenedorBonus(bonusX2, jugador.cantMultiplicadoresX2Restantes());

        bonusX3 = new Button("X3");
        BotonMultiplicadorx3EventHandler multiplicX3Handler = new BotonMultiplicadorx3EventHandler(pregunta, escena, jugador, manejadorDeTurnos, etiquetaTiempo);
        bonusX3.setOnAction(multiplicX3Handler);
        ContenedorBonus contenedorBonusX3 = new ContenedorBonus(bonusX3, jugador.cantMultiplicadoresX3Restantes());

        exclusividad = new Button("Ex");
        exclusividad.setDisable(true);
        ContenedorBonus contenedorExclusividad = new ContenedorBonus(exclusividad, jugador.cantExclusividadesRestantes());

        VBox contenedorNombreJugador = new VBox(nombreJugador);
        VBox contenedorTiempo = new VBox(etiquetaTiempo.getLabel());
        HBox contenedorBonus = new HBox(contenedorBonusX2.getLayout(), contenedorBonusX3.getLayout(), contenedorExclusividad.getLayout());
        contenedorBonus.setSpacing(3);

        this.habilitarMultiplicadores(jugador);

        layout = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);

        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-font-size: 1.25em;");
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_CINTA), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setSpacing(40);
        layout.setPadding(new Insets(10));
    }

    public HBox getLayout() {return layout;}

    public Timeline getTiempo(){
        return etiquetaTiempo.getTiempo();
    }

    private void habilitarMultiplicadores(Jugador jugador){

        if(jugador.cantMultiplicadoresX2Restantes() == 0){
            bonusX2.setDisable(true);
        }
        if(jugador.cantMultiplicadoresX3Restantes() == 0){
            bonusX3.setDisable(true);
        }
    }
}
