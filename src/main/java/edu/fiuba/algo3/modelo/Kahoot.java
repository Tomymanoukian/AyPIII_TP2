package edu.fiuba.algo3.modelo;

public class Kahoot {
    Jugador jugador1;
    Jugador jugador2;
    ListaOpciones respuestasJugador1;
    ListaOpciones respuestasJugador2;

    public Kahoot(Jugador unJugador, Jugador otroJugador) {
        respuestasJugador1 = new ListaOpciones();
        respuestasJugador2 = new ListaOpciones();
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }

    public void setRespuestaJugador1(Opcion respuestasJugador) {
        respuestasJugador1.limpiar();
        respuestasJugador1.agregar(respuestasJugador);
    }

    public void setRespuestaJugador2(Opcion respuestasJugador) {
        respuestasJugador2.limpiar();
        respuestasJugador2.agregar(respuestasJugador);
    }

    public void setRespuestaJugador1(ListaOpciones respuestasJugador) {
        respuestasJugador1.limpiar();
        respuestasJugador1.agregarTodo(respuestasJugador);
    }

    public void setRespuestaJugador2(ListaOpciones respuestasJugador) {
        respuestasJugador2.limpiar();
        respuestasJugador2.agregarTodo(respuestasJugador);
    }

    public void evaluarRespuestas(Pregunta unaPregunta) {
        unaPregunta.evaluarRespuestaPara(respuestasJugador1, jugador1);
        unaPregunta.evaluarRespuestaPara(respuestasJugador2, jugador2);
    }

    public int getPuntajeJugador1() {
        return jugador1.getPuntos();
    }

    public int getPuntajeJugador2() {
        return jugador2.getPuntos();
    }


}
