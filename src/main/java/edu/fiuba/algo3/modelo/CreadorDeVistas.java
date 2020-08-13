package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.EscenaVerdaderoFalsoClasico;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class CreadorDeVistas {

    public static Scene crearSiguienteEscena(Pregunta pregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String tipoDePregunta = (pregunta.getClass()).getSimpleName();

        Class<?> claseDeLaEscena = Class.forName("edu.fiuba.algo3.vista.Escena" + tipoDePregunta);
        Constructor<Escena> constructor = (Constructor<Escena>)claseDeLaEscena.getConstructor(Pregunta.class, Jugador.class, ManejadorDeTurnos.class);
        Escena escena = /*(Escena)*/constructor.newInstance(pregunta, jugador, manejadorDeTurnos);

        return escena.getEscena();
    }
}
