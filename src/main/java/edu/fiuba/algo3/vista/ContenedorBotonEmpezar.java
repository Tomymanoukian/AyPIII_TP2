package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEmpezarJuegoEventHandler;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ContenedorBotonEmpezar {

    private HBox contenedorBoton;

    public ContenedorBotonEmpezar(TextField nombreJugador1, TextField nombreJugador2, ManejadorDeTurnos manejadorDeTurnos) {
        Button iniciarJuego = new Button("Iniciar Kahoot");
        iniciarJuego.setStyle("-fx-border-color: #000000; -fx-font-size: 1.4em; -fx-background-color: #A8E3E7");

        BotonEmpezarJuegoEventHandler botonComienzoDeJuego = new BotonEmpezarJuegoEventHandler(nombreJugador1,
                nombreJugador2, manejadorDeTurnos);

        iniciarJuego.setOnAction(botonComienzoDeJuego);

        contenedorBoton = new HBox(iniciarJuego);
        contenedorBoton.setAlignment(Pos.BOTTOM_RIGHT);
        contenedorBoton.setPadding(new Insets(20));

    }

    public HBox getLayout(){
        return contenedorBoton;
    }
}