package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.OpcionNoValidaException;

public abstract class VerdaderoFalso extends Pregunta {
    protected Opcion opcionCorrecta;
    protected Opcion opcionIncorrecta;

    public Opcion getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public Opcion getOpcionIncorrecta() {
        return opcionIncorrecta;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {
        Opcion opcionSeleccionada = respuesta.getOpcionSeleccionada();

        if (!opcionSeleccionada.esIgualA(opcionCorrecta) && !opcionSeleccionada.esIgualA(opcionIncorrecta)) {
            throw new OpcionNoValidaException();
        }

        return opcionSeleccionada.getPuntaje();
    }
}
