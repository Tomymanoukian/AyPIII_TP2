package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonSubirRespuestaHandler implements EventHandler<ActionEvent> {

    private int posicion;
    private EscenaOrderedChoice escena;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonSubirRespuestaHandler (int unaPosicion, EscenaOrderedChoice unaEscena, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos) {
        posicion = unaPosicion;
        escena = unaEscena;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Opcion opcionVaso = new Opcion(escena.getOpcionesMostradas().obtener(posicion).getOpcion());
        escena.getOpcionesMostradas().establecer(posicion, escena.getOpcionesMostradas().obtener(posicion-1));
        escena.getOpcionesMostradas().establecer(posicion-1, opcionVaso);

        escena.actualizar(jugador, manejadorDeTurnos);
    }
}
