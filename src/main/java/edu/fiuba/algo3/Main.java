package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.LayoutMenuBienvenida;
import edu.fiuba.algo3.vista.LayoutVerdaderoFalso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        LayoutVerdaderoFalso vistaVerdaderoFalso = new LayoutVerdaderoFalso();
        LayoutMenuBienvenida vistaBienvenida = new LayoutMenuBienvenida();

        stage.setTitle("Kahoot!");

        Scene scene = new Scene(vistaVerdaderoFalso.getLayout(), 400, 275);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
