package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        InterfazDeUsuario interfazDelJuego = new InterfazDeUsuario(stage);
        interfazDelJuego.vistaDeInicioDelKahoot();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
