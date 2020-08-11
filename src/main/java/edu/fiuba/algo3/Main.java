package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Kahoot kahoot = new Kahoot(jugador1, jugador2);

        LayoutVerdaderoFalso vistaVerdaderoFalso = new LayoutVerdaderoFalso();
        LayoutMenuBienvenida vistaBienvenida = new LayoutMenuBienvenida();
        LayoutOrderedChoice vistaOrderedChoice = new LayoutOrderedChoice();
        LayoutPuntuaciones vistaPuntuaciones = new LayoutPuntuaciones();
        LayoutMultipleChoice vistaMultipleChoice = new LayoutMultipleChoice();

        Pane layout = new Pane();

        layout.getChildren().addAll(vistaBienvenida.getLayout(), vistaVerdaderoFalso.getLayout(), vistaOrderedChoice.getLayout(), vistaPuntuaciones.getLayout(), vistaMultipleChoice.getLayout());

        vistaBienvenida.mostrarVista(layout);

        stage.setTitle("Kahoot!");

        Scene scene = new Scene(layout, 390, 375);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
