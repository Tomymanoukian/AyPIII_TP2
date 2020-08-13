package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonEmpezarJuegoEventHandler implements EventHandler<ActionEvent> {

    private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Kahoot kahoot;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonEmpezarJuegoEventHandler(TextField unNombreJugador1, TextField unNombreJugador2, ManejadorDeTurnos unManejadorDeTurnos) {
        nombreJugador1 = unNombreJugador1;
        nombreJugador2 = unNombreJugador2;
        kahoot = unManejadorDeTurnos.getKahoot();
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador1 = new Jugador(nombreJugador1.getText());
        Jugador jugador2 = new Jugador(nombreJugador2.getText());
        kahoot = new Kahoot(jugador1,jugador2);
        manejadorDeTurnos.mostrarPrimeraPregunta();
    }
}
