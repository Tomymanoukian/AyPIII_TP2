package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonBajarRespuestaHandler implements EventHandler<ActionEvent> {

    private int posicion;
    private EscenaOrderedChoice escena;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;
    private EtiquetaTiempo etiquetaTiempo;

    public BotonBajarRespuestaHandler (int unaPosicion, EscenaOrderedChoice unaEscenaOrderedChoice, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos, EtiquetaTiempo unaEtiquetaTimepo) {
        posicion = unaPosicion;
        escena = unaEscenaOrderedChoice;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
        etiquetaTiempo = unaEtiquetaTimepo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Opcion opcionVaso = new Opcion(escena.getOpcionesMostradas().obtener(posicion).getOpcion());
        escena.getOpcionesMostradas().establecer(posicion, escena.getOpcionesMostradas().obtener(posicion+1));
        escena.getOpcionesMostradas().establecer(posicion+1, opcionVaso);

        escena.actualizar(jugador, manejadorDeTurnos, etiquetaTiempo);
    }
}
