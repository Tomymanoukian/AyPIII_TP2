package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.EscenaVerdaderoFalsoClasico;
import javafx.scene.Scene;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class CreadorDeVistas {

    public static Scene crearSiguienteEscena(Pregunta pregunta, Jugador jugador, Kahoot kahoot) {

        String tipoDePregunta = (pregunta.getClass()).getSimpleName();
        
        Class<?> claseDeLaEscena = null;
        try {
            claseDeLaEscena = Class.forName("edu.fiuba.algo3.vista.Escena" + tipoDePregunta);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }


        Constructor<Escena> constructor = null;
        try {
            constructor = (Constructor<Escena>)claseDeLaEscena.getConstructor(Pregunta.class, Jugador.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Escena escena = null;
        try {
            escena = (Escena)constructor.newInstance(pregunta, jugador);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return escena.getEscena();
    }
}
