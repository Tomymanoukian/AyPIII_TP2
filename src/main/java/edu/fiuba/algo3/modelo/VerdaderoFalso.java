package edu.fiuba.algo3.modelo;

public class VerdaderoFalso extends Pregunta {
    protected static Opcion opcionCorrecta;
    protected static Opcion opcionIncorrecta;

    public Opcion getRespuestaCorrecta() {
        return opcionCorrecta;
    }

    public Opcion getRespuestaIncorrecta() {
        return opcionIncorrecta;
    }

    @Override
    public void evaluarRespuestaPara(ListaOpciones respuestas, Jugador jugador) {
        if (respuestas.cantidadDeRespuestas() != 1) {
            throw new CantidadDeRespuestasInvalidaException();
        }

        Opcion opcion = respuestas.obtenerPrimero();
        if (!opcion.esIgualA(opcionCorrecta) && !opcion.esIgualA(opcionIncorrecta)) {
            throw new RespuestaNoValidaException();
        }

        respuestas.obtenerPrimero().aplicarPuntajeA(jugador);
    }
}
