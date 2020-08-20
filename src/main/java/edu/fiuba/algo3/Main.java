package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Layouts.LayoutMenuBienvenida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

import static edu.fiuba.algo3.vista.Constantes.ALTO_VENTANA;
import static edu.fiuba.algo3.vista.Constantes.ANCHO_VENTANA;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Kahoot kahoot = new Kahoot();

        MockLecturaDeArchivoDePreguntas mockLecturaDeArchivoDePreguntas = new MockLecturaDeArchivoDePreguntas();

        Stack<Pregunta> pilaDePreguntas = mockLecturaDeArchivoDePreguntas.getPilaDePreguntas();

        ManejadorDeTurnos unManejadorDeTurnos = new ManejadorDeTurnos(pilaDePreguntas, kahoot.getJugador1(), kahoot.getJugador2(), kahoot, stage);

        stage.setScene(new Scene( new VBox(new BarraDeMenu(), new LayoutMenuBienvenida(unManejadorDeTurnos).getLayout())));

        stage.setWidth(ANCHO_VENTANA);
        stage.setHeight(ALTO_VENTANA);
        stage.setTitle("Kahoot!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
