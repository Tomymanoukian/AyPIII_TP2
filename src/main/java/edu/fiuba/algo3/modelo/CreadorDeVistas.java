package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaCorruptaException;
import edu.fiuba.algo3.vista.Escenas.*;
import javafx.scene.Scene;

public class CreadorDeVistas {

    public static Scene crearSiguienteEscena(Pregunta pregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) throws PreguntaCorruptaException{

        Escena escena;

        if(pregunta.getClass().getSimpleName().equals(VerdaderoFalsoClasico.class.getSimpleName())){

            escena = new EscenaVerdaderoFalso(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.getClass().getSimpleName().equals(VerdaderoFalsoConPenalidad.class.getSimpleName())){

            escena = new EscenaVerdaderoFalso(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.getClass().getSimpleName().equals(MultipleChoiceClasico.class.getSimpleName())){

            escena = new EscenaMultipleChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.getClass().getSimpleName().equals(MultipleChoiceParcial.class.getSimpleName())){

            escena = new EscenaMultipleChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.getClass().getSimpleName().equals(MultipleChoiceConPenalidad.class.getSimpleName())){

            escena = new EscenaMultipleChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.getClass().getSimpleName().equals(OrderedChoice.class.getSimpleName())){

            escena = new EscenaOrderedChoice(pregunta, jugador, manejadorDeTurnos);

        }else if (pregunta.getClass().getSimpleName().equals(GroupChoice.class.getSimpleName())) {

            escena = new EscenaGroupChoice(pregunta, jugador, manejadorDeTurnos);
        }
        else
            throw new PreguntaCorruptaException();

        return escena.getEscena();
    }
}