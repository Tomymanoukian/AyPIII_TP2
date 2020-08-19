package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.Layouts.LayoutMenuBienvenida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Kahoot kahoot = new Kahoot();

        MockLecturaDeArchivoDePreguntas mockLecturaDeArchivoDePreguntas = new MockLecturaDeArchivoDePreguntas();

        Stack<Pregunta> pilaDePreguntas = mockLecturaDeArchivoDePreguntas.getPilaDePreguntas();

        ManejadorDeTurnos unManejadorDeTurnos = new ManejadorDeTurnos(pilaDePreguntas, kahoot.getJugador1(), kahoot.getJugador2(), kahoot, stage);

        stage.setScene(new Scene(new LayoutMenuBienvenida(unManejadorDeTurnos).getLayout()));

        stage.setHeight(700);
        stage.setWidth(600);
        stage.setTitle("Kahoot!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
