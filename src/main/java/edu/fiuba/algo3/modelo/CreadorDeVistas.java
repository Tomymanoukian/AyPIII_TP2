package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.EscenaVerdaderoFalsoClasico;
import javafx.scene.Scene;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class CreadorDeVistas {
    /*Stack<Pregunta> pilaDePreguntas;
    Jugador jugador1;
    Jugador jugador2;

    public CreadorDeVistas(Stack<Pregunta> unaPilaDePreguntas, Jugador jugador1, Jugador jugador2){
        pilaDePreguntas = unaPilaDePreguntas;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }*/

    public static Scene crearSiguienteEscena(Pregunta pregunta, Jugador jugador, Kahoot kahoot) {

        String tipoDePregunta = (pregunta.getClass()).getSimpleName();
        EscenaVerdaderoFalsoClasico escenaBorrar = new EscenaVerdaderoFalsoClasico(pregunta, jugador);

        Class<?> claseDeLaEscena = null;
        try {
            claseDeLaEscena = Class.forName("edu.fiuba.algo3.vista.Escena" + tipoDePregunta);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.err.println("error 0");
            System.exit(1);
        }

        System.out.println(claseDeLaEscena.getSimpleName());
        System.out.println(escenaBorrar.getClass().getName() == claseDeLaEscena.getName());

        Constructor<Escena> constructor = null;
        try {
            constructor = (Constructor<Escena>)claseDeLaEscena.getConstructor(Pregunta.class, Jugador.class);
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
            System.err.println("ERROR 1");
            System.exit(1);
        }

        Escena escena = null;
        try {
            escena = (Escena)constructor.newInstance(pregunta, jugador);
        } catch (InstantiationException e) {
            //e.printStackTrace();
            System.err.println("error 2");
            System.exit(1);
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
            System.err.println("error 3");
            System.exit(1);
        } catch (InvocationTargetException e) {
            //e.printStackTrace();
            System.err.println("error 4");
            System.exit(1);
        }

        return escena.getEscena();
    }


    /*public Scene SiguienteEscena(pregunta){
        Pregunta pregunta = pilaDePreguntas.pop();


        try {
            scene = crearSiguienteEscena(pregunta, jugador1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("outROOORR1");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("outROOORR2");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("outROOORR3");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("outROOORR4");
            e.printStackTrace();
        }

        return scene;
    }*/

}
