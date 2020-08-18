package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.scene.Scene;

public interface Escena {

    public abstract Scene getEscena();

    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo);
}
