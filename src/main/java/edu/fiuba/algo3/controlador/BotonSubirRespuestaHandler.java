package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class BotonSubirRespuestaHandler implements EventHandler<ActionEvent> {

    private int posicion;
    private ListaOpciones listaDeOpciones;

    public BotonSubirRespuestaHandler (int unaPosicion, ListaOpciones unaListaOpciones) {
        posicion = unaPosicion;
        listaDeOpciones = unaListaOpciones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println(listaDeOpciones.obtener(posicion).getOpcion());

        Opcion opcionVaso = new Opcion(listaDeOpciones.obtener(posicion).getOpcion());

        listaDeOpciones.establecer(posicion, listaDeOpciones.obtener(posicion-1));
        listaDeOpciones.establecer(posicion-1, opcionVaso);

        System.out.println(listaDeOpciones.obtener(posicion).getOpcion());
    }
}
