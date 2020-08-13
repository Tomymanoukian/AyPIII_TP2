package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.LayoutPuntuaciones;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class ManejadorDeTurnos {
    Stack<Pregunta> pilaDePreguntas ;
    Jugador jugador1;
    Jugador jugador2;
    Boolean jugador2Respodio;
    Pregunta pregunta;
    Kahoot kahoot;
    Stage stage;

    public ManejadorDeTurnos(Stack<Pregunta> pilaDePreguntas, Jugador jugador1, Jugador jugador2, Kahoot kahoot, Stage stage){
        this.pilaDePreguntas = pilaDePreguntas;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.kahoot = kahoot;
        jugador2Respodio = true;
        this.stage = stage;
    }

    public Scene mostrarSiguientePregunta(){

        if(pilaDePreguntas.isEmpty() && jugador2Respodio){
            return new Scene(new LayoutPuntuaciones().getLayout());
        }

        if(jugador2Respodio) {
            jugador2Respodio = false;
            pregunta = pilaDePreguntas.pop();
            return CreadorDeVistas.crearSiguienteEscena(pregunta, jugador1, kahoot, stage);
        }
        else{
            jugador2Respodio = true;
            return CreadorDeVistas.crearSiguienteEscena(pregunta, jugador2, kahoot, stage);
        }
    }
}
