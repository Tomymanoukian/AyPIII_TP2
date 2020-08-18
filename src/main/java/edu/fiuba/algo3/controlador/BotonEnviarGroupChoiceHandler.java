package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonEnviarGroupChoiceHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private ListaOpciones listaOpciones;
    ArrayList<HBox> listaHbox;
    private ManejadorDeTurnos manejadorDeTurnos;
    private Timeline tiempo;

    public BotonEnviarGroupChoiceHandler(Jugador unJugador, ListaOpciones unaListaOpciones, ArrayList<HBox> unaListaHbox, ManejadorDeTurnos unManejadorDeTurnos, Timeline unTiempo) {

        jugador = unJugador;
        listaOpciones = unaListaOpciones;
        listaHbox = unaListaHbox;
        manejadorDeTurnos = unManejadorDeTurnos;
        tiempo = unTiempo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tiempo.stop();
        manejadorDeTurnos.getKahoot().setRespuestaJugador(calcularRespuesta(listaOpciones, listaHbox), jugador);
        manejadorDeTurnos.mostrarSiguientePregunta();
    }

    private Respuesta calcularRespuesta(ListaOpciones listaOpciones, ArrayList<HBox> listaHBox) {

        ListaOpciones respuestaGrupoA = new ListaOpciones();
        ListaOpciones respuestaGrupoB = new ListaOpciones();

        for (int i = 0; i < listaOpciones.cantidadDeOpciones(); i++) {

            if (((RadioButton) listaHBox.get(i).getChildren().get(1)).isSelected())
                respuestaGrupoA.agregar(listaOpciones.obtener(i));

            else if (((RadioButton) listaHBox.get(i).getChildren().get(2)).isSelected())
                respuestaGrupoB.agregar(listaOpciones.obtener(i));
        }

        return new RespuestaDeGrupos(respuestaGrupoA, respuestaGrupoB);
    }
}