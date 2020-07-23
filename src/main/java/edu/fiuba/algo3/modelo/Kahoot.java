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

    public void setRespuestaJugador1(Respuesta respuestaDelJugador1) {
        respuestaJugador1 = respuestaDelJugador1;
    }

    public void setRespuestaJugador2(Respuesta respuestaDelJugador2) {
        respuestaJugador2 = respuestaDelJugador2;
    }

    public void evaluarRespuestas(Pregunta unaPregunta) {
        jugador1.aumentarPuntos(unaPregunta.calcularPuntajePara(respuestaJugador1));
        jugador2.aumentarPuntos(unaPregunta.calcularPuntajePara(respuestaJugador2));
    }

    public int getPuntajeJugador1() {
        return  jugador1.getPuntos();
    }

    public int getPuntajeJugador2() {
        return  jugador2.getPuntos();
    }
}
