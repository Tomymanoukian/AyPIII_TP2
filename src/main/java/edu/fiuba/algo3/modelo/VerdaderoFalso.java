package edu.fiuba.algo3.modelo;

public class VerdaderoFalso extends Pregunta {
    protected static Respuesta respuestaCorrecta;
    protected static Respuesta respuestaIncorrecta;

    public Respuesta getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public Respuesta getRespuestaIncorrecta() {
        return respuestaIncorrecta;
    }

    @Override
    public void evaluarRespuestaPara(ListaRespuestas respuestas, Jugador jugador) {
        if (respuestas.cantidadDeRespuestas() != 1) {
            throw new CantidadDeRespuestasInvalidaException();
        }

        Respuesta respuesta = respuestas.obtenerPrimero();
        if (!respuesta.esIgualA(respuestaCorrecta) && !respuesta.esIgualA(respuestaIncorrecta)) {
            throw new RespuestaNoValidaException();
        }

        respuestas.obtenerPrimero().aplicarPuntajeA(jugador);
    }
}
