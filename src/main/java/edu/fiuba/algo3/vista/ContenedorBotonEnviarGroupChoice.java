package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEnviarGroupChoiceHandler;
import edu.fiuba.algo3.controlador.BotonEnviarHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ContenedorBotonEnviarGroupChoice {

    private HBox layout;

    public ContenedorBotonEnviarGroupChoice(Jugador jugador, ListaOpciones listaOpciones, ArrayList<HBox> listaHBox, ManejadorDeTurnos manejadorDeTurnos, Timeline tiempo) {
        Button enviar = new Button("Enviar");
        enviar.setStyle("-fx-border-color: #A8E3E7; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");

        BotonEnviarGroupChoiceHandler botonEnviarGroupChoiceHandler = new BotonEnviarGroupChoiceHandler(jugador, listaOpciones, listaHBox, manejadorDeTurnos, tiempo);
        enviar.setOnAction(botonEnviarGroupChoiceHandler);

        layout = new HBox(enviar);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.BOTTOM_CENTER);
    }

    public HBox getLayout() {
        return layout;
    }
}
