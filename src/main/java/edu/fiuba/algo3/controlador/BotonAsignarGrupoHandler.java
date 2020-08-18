package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAsignarGrupoHandler implements EventHandler<ActionEvent> {

    private Opcion opcion;
    private ListaOpciones origen;
    private ListaOpciones destino;

    public BotonAsignarGrupoHandler (Opcion unaOpcion, ListaOpciones unOrigen, ListaOpciones unDestino) {

        opcion = unaOpcion;
        origen = unOrigen;
        destino = unDestino;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        origen.quitarOpcion(opcion);
        destino.agregar(opcion);
    }
}
