package edu.fiuba.algo3.modelo;

import java.util.List;

public class Kahoot {
    Jugador jugador1;
    Jugador jugador2;
    ListaRespuestas respuestasJugador1;
    ListaRespuestas respuestasJugador2;

    public Kahoot(Jugador unJugador, Jugador otroJugador) {
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }

    public void setRespuestaJugador1(Respuesta respuestaDelJugador1) {
        respuestasJugador1.limpiar();
        respuestasJugador1.agregar(respuestaDelJugador1);
    }

    public void setRespuestaJugador2(Respuesta respuestaDelJugador2) {
        respuestasJugador2.limpiar();
        respuestasJugador2.agregar(respuestaDelJugador2);
    }

    public void setRespuestaJugador1(ListaRespuestas respuestasJugador) {
        respuestasJugador1.limpiar();
        respuestasJugador1.agregarTodo(respuestasJugador);
    }

    public void setRespuestaJugador2(ListaRespuestas respuestasJugador) {
        respuestasJugador2.limpiar();
        respuestasJugador2.agregarTodo(respuestasJugador);
    }

    public void evaluarRespuestas(Pregunta unaPregunta) {
        jugador1.aumentarPuntos(unaPregunta.calcularPuntajePara(respuestasJugador1));
        jugador2.aumentarPuntos(unaPregunta.calcularPuntajePara(respuestasJugador2));
    }

    public int getPuntajeJugador1() {
        return jugador1.getPuntos();
    }

    public int getPuntajeJugador2() {
        return jugador2.getPuntos();
    }


}
