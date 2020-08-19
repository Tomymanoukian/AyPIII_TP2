package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Kahoot kahoot = new Kahoot(jugador1, jugador2);

        MockLecturaDeArchivoDePreguntas mockLecturaDeArchivoDePreguntas = new MockLecturaDeArchivoDePreguntas();

        Stack<Pregunta> pilaDePreguntas = mockLecturaDeArchivoDePreguntas.getPilaDePreguntas();

        ManejadorDeTurnos unManejadorDeTurnos = new ManejadorDeTurnos(pilaDePreguntas, jugador1, jugador2, kahoot, stage);

        stage.setScene(new Scene(new LayoutMenuBienvenida(unManejadorDeTurnos).getLayout()));
        //unManejadorDeTurnos.mostrarPrimeraPregunta();

        stage.setTitle("Kahoot!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
