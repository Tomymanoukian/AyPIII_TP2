package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

class BotonEmpezarJuegoEventHandler implements EventHandler<ActionEvent> {

    private InterfazDeUsuario interfazDeUsuario;
    private TextField nombreJugador1;
    private TextField nombreJugador2;


    public BotonEmpezarJuegoEventHandler(TextField unNombreJugador1, TextField unNombreJugador2,InterfazDeUsuario unaInterfazDeUsuario) {
        nombreJugador1 = unNombreJugador1;
        nombreJugador2 = unNombreJugador2;
        interfazDeUsuario = unaInterfazDeUsuario;

    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador1 = new Jugador(nombreJugador1.getText());
        Jugador jugador2 = new Jugador(nombreJugador2.getText());
        Kahoot kahoot = new Kahoot(jugador1,jugador2);
        kahoot.setInterfazVisual(interfazDeUsuario);
        kahoot.iniciarJuego();
    }
}
