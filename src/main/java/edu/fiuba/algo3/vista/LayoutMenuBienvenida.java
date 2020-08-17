package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEmpezarJuegoEventHandler;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LayoutMenuBienvenida {

    private Pane layout;

    public LayoutMenuBienvenida(ManejadorDeTurnos manejadorDeTurnos) {
        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida();

        ContenedorNombresJugadores contenedorNombresJugadores = new ContenedorNombresJugadores();

        ContenedorBotonEmpezar contenedorBotonEmpezar = new ContenedorBotonEmpezar(contenedorNombresJugadores.nombreJugador1(),
                                                    contenedorNombresJugadores.nombreJugador2(), manejadorDeTurnos);

        VBox contenedorInicioDeKahoot = new VBox(contenedorBienvenida.getLayout(), contenedorNombresJugadores.getLayout(), contenedorBotonEmpezar.getLayout());

        contenedorInicioDeKahoot.setSpacing(20);
        contenedorInicioDeKahoot.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        layout = new VBox(contenedorInicioDeKahoot);
    }

    public Pane getLayout(){return layout;}

    public void mostrarVista(Pane unosLayouts) {

        unosLayouts.getChildren().forEach(element -> element.setVisible(false));
        layout.setVisible(true);
    }
}
