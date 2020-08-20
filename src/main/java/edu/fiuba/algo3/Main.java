package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Layouts.LayoutMenuBienvenida;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Stack;

import static edu.fiuba.algo3.vista.Constantes.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Kahoot kahoot = new Kahoot();

        MockLecturaDeArchivoDePreguntas mockLecturaDeArchivoDePreguntas = new MockLecturaDeArchivoDePreguntas();

        Stack<Pregunta> pilaDePreguntas = mockLecturaDeArchivoDePreguntas.getPilaDePreguntas();

        ManejadorDeTurnos unManejadorDeTurnos = new ManejadorDeTurnos(pilaDePreguntas, kahoot.getJugador1(), kahoot.getJugador2(), kahoot, stage);

        VBox vBox = new VBox();
        stage.setScene(new Scene(vBox));
        vBox.getChildren().addAll(new BarraDeMenu(stage), new LayoutMenuBienvenida(unManejadorDeTurnos).getLayout());
        vBox.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));

        stage.setWidth(ANCHO_VENTANA);
        stage.setHeight(ALTO_VENTANA);
        stage.setTitle("Kahoot!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
