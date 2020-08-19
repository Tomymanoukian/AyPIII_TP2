package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBienvenida;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBotonEmpezar;
import edu.fiuba.algo3.vista.Contenedores.ContenedorNombresJugadores;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LayoutMenuBienvenida {

    private Pane layout;

    public LayoutMenuBienvenida(ManejadorDeTurnos manejadorDeTurnos) {
        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida();

        ContenedorNombresJugadores contenedorNombresJugadores = new ContenedorNombresJugadores(manejadorDeTurnos.getJugador1(), manejadorDeTurnos.getJugador2());

        ContenedorBotonEmpezar contenedorBotonEmpezar = new ContenedorBotonEmpezar(contenedorNombresJugadores.nombreJugador1(),
                                                    contenedorNombresJugadores.nombreJugador2(), manejadorDeTurnos);
        VBox contenedorInicioDeKahoot = new VBox(contenedorBienvenida.getLayout(), contenedorNombresJugadores.getLayout(), contenedorBotonEmpezar.getLayout());

        contenedorInicioDeKahoot.setSpacing(20);
        contenedorInicioDeKahoot.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        layout = new VBox(contenedorInicioDeKahoot);
    }

    public Pane getLayout(){return layout;}
}
