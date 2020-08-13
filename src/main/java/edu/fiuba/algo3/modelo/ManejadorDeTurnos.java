package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.LayoutPuntuaciones;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class    ManejadorDeTurnos {
    private Stack<Pregunta> pilaDePreguntas ;
    private Jugador jugador1;
    private Jugador jugador2;
    private Boolean jugador2Respodio;
    private Boolean juegoTerminado;
    private Pregunta pregunta;
    private Kahoot kahoot;
    private Stage stage;

    public ManejadorDeTurnos(Stack<Pregunta> pilaDePreguntas, Jugador jugador1, Jugador jugador2, Kahoot kahoot, Stage stage){
        this.pilaDePreguntas = pilaDePreguntas;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.kahoot = kahoot;
        jugador2Respodio = true;
        juegoTerminado = false;
        this.stage = stage;
    }

    public void mostrarPrimeraPregunta () {

        if(pilaDePreguntas.isEmpty()){
            stage.setScene(new Scene(new LayoutPuntuaciones().getLayout()));
        }

        pregunta = pilaDePreguntas.pop();
        try {
            stage.setScene(CreadorDeVistas.crearSiguienteEscena(pregunta, jugador1, this));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            this.mostrarPrimeraPregunta();
        }

        jugador2Respodio = false;
    }

    public void mostrarSiguientePregunta(){

        if(pilaDePreguntas.isEmpty() && jugador2Respodio){
            juegoTerminado = true;
            stage.setScene(new Scene(new LayoutPuntuaciones().getLayout()));
        }

        if(jugador2Respodio && !juegoTerminado) {

            kahoot.evaluarRespuestas(pregunta);
            jugador2Respodio = false;

            pregunta = pilaDePreguntas.pop();

            try {
                stage.setScene(CreadorDeVistas.crearSiguienteEscena(pregunta, jugador1, this));
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
                System.err.println("ERROR: Una pregunta de la lista se encontraba corrupta y no pudo ser mostrada");
                this.mostrarSiguientePregunta();
            }
            jugador2Respodio = false;
        }
        else if (!juegoTerminado){

            jugador2Respodio = true;
            try {
                stage.setScene(CreadorDeVistas.crearSiguienteEscena(pregunta, jugador2, this));
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public Kahoot getKahoot() {return kahoot;}

    public Stage getStage() {return stage;}
}
