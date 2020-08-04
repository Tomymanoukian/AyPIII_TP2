package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.OpcionNoValidaException;

public class VerdaderoFalso extends Pregunta {
    protected static Opcion opcionCorrecta;
    protected static Opcion opcionIncorrecta;

    public Opcion getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public Opcion getOpcionIncorrecta() {
        return opcionIncorrecta;
    }

    @Override
    public void evaluarRespuestaPara(Respuesta respuesta, Jugador jugador) {
        Opcion opcionSeleccionada = respuesta.getOpcionSeleccionada();

        if (!opcionSeleccionada.esIgualA(opcionCorrecta) && !opcionSeleccionada.esIgualA(opcionIncorrecta)) {
            throw new OpcionNoValidaException();
        }

        opcionSeleccionada.aplicarPuntajeA(jugador);
    }
}
