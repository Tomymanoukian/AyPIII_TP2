package edu.fiuba.algo3.modelo;

public class Kahoot {
    Jugador jugador1;
    Jugador jugador2;
    ListaRespuestas respuestasJugador1;
    ListaRespuestas respuestasJugador2;

    public Kahoot(Jugador unJugador, Jugador otroJugador) {
        respuestasJugador1 = new ListaRespuestas();
        respuestasJugador2 = new ListaRespuestas();
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }

    public void setRespuestaJugador1(Respuesta respuestasJugador) {
        respuestasJugador1.limpiar();
        respuestasJugador1.agregar(respuestasJugador);
    }

    public void setRespuestaJugador2(Respuesta respuestasJugador) {
        respuestasJugador2.limpiar();
        respuestasJugador2.agregar(respuestasJugador);
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
