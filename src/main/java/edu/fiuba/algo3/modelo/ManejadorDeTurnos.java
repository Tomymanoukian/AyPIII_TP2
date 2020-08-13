package edu.fiuba.algo3.modelo;

import javafx.scene.Scene;

import java.util.Stack;

public class ManejadorDeTurnos {
    Stack<Pregunta> pilaDePreguntas ;
    Jugador jugador1;
    Jugador jugador2;
    Boolean jugador2Respodio;
    Pregunta pregunta;
    Kahoot kahoot;

    public ManejadorDeTurnos(Stack<Pregunta> pilaDePreguntas, Jugador jugador1, Jugador jugador2, Kahoot kahoot){
        this.pilaDePreguntas = pilaDePreguntas;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.kahoot = kahoot;
        jugador2Respodio = true;
    }

    public Scene mostrarSiguientePregunta(){

        if(pilaDePreguntas.isEmpty() && jugador2Respodio){
            //return vista de puntos
        }

        if(jugador2Respodio) {
            jugador2Respodio = false;
            pregunta = pilaDePreguntas.pop();
            return CreadorDeVistas.crearSiguienteEscena(pregunta, jugador1, kahoot);
        }
        else{
            jugador2Respodio = true;
            return CreadorDeVistas.crearSiguienteEscena(pregunta, jugador2, kahoot);
        }
    }
}
