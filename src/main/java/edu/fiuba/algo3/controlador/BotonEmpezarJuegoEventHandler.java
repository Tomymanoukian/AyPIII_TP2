package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.InterfazDeUsuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonEmpezarJuegoEventHandler implements EventHandler<ActionEvent> {

    private TextField nombreJugador1;
    private TextField nombreJugador2;

    public BotonEmpezarJuegoEventHandler(TextField unNombreJugador1, TextField unNombreJugador2) {
        nombreJugador1 = unNombreJugador1;
        nombreJugador2 = unNombreJugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador1 = new Jugador(nombreJugador1.getText());
        Jugador jugador2 = new Jugador(nombreJugador2.getText());
        Kahoot kahoot = new Kahoot(jugador1,jugador2);
        kahoot.iniciarJuego();
    }
}
