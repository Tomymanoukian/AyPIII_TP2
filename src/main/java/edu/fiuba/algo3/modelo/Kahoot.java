package edu.fiuba.algo3.modelo;

public class Kahoot {
    Jugador jugador1;
    Jugador jugador2;
    Respuesta respuestaJugador1;
    Respuesta respuestaJugador2;

    public Kahoot(Jugador unJugador, Jugador otroJugador) {
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }

    public void setRespuestaJugador1(Respuesta unaRespuesta) {
        respuestaJugador1 = unaRespuesta;
    }

    public void setRespuestaJugador2(Respuesta unaRespuesta) {
        respuestaJugador2 = unaRespuesta;
    }

    public void evaluarRespuestas(Pregunta unaPregunta) {
        unaPregunta.evaluarRespuestaPara(respuestaJugador1, jugador1);
        unaPregunta.evaluarRespuestaPara(respuestaJugador2, jugador2);
    }

    public int getPuntajeJugador1() {
        return jugador1.getPuntos();
    }

    public int getPuntajeJugador2() {
        return jugador2.getPuntos();
    }


}
