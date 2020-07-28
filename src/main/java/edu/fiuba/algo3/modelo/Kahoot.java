package edu.fiuba.algo3.modelo;

import java.util.List;

public class Kahoot {
    Jugador jugador1;
    Jugador jugador2;
    List<Respuesta> respuestasJugador1;
    List<Respuesta> respuestasJugador2;

    public Kahoot(Jugador unJugador, Jugador otroJugador) {
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }

    public void setRespuestaJugador1(Respuesta respuestaDelJugador1) {
        respuestasJugador1.clear();
        respuestasJugador1.add(respuestaDelJugador1);
    }

    public void setRespuestaJugador2(Respuesta respuestaDelJugador2) {
        respuestasJugador2.clear();
        respuestasJugador2.add(respuestaDelJugador2);
    }

    public void setRespuestaJugador1(List<Respuesta> respuestasJugador) {
        respuestasJugador1.clear();
        respuestasJugador1.addAll(respuestasJugador);
    }

    public void setRespuestaJugador2(List<Respuesta> respuestasJugador) {
        respuestasJugador2.clear();
        respuestasJugador2.addAll(respuestasJugador);
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
