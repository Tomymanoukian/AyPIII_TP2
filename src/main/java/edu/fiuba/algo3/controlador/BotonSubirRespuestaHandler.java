package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonSubirRespuestaHandler implements EventHandler<ActionEvent> {

    private int posicion;
    private ListaOpciones listaDeOpciones;
    private LayoutOrderedChoice layout;
    private Stage stage;

    public BotonSubirRespuestaHandler (int unaPosicion, ListaOpciones unaListaOpciones, Stage unStage) {
        posicion = unaPosicion;
        stage = unStage;
        listaDeOpciones = unaListaOpciones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Opcion opcionVaso = new Opcion(listaDeOpciones.obtener(posicion).getOpcion());
        listaDeOpciones.establecer(posicion, listaDeOpciones.obtener(posicion-1));
        listaDeOpciones.establecer(posicion-1, opcionVaso);

        Scene scene = new Scene(new LayoutOrderedChoice(listaDeOpciones, stage).getLayout(), 390, 375);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();
    }
}
