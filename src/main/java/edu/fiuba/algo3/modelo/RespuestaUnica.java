package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoValidaException;

public class RespuestaUnica extends Respuesta {

    private Opcion opcionSeleccionada;

    public RespuestaUnica(Opcion unaOpcionSeleccionada) {
        opcionSeleccionada = unaOpcionSeleccionada;
    }

    public Opcion getOpcionSeleccionada(){
        return opcionSeleccionada;
    }

    @Override
    public boolean esIgualA(Opcion opcion) {
        return opcionSeleccionada.esIgualA(opcion);
    }

    @Override
    public Puntaje getPuntaje() {
        return opcionSeleccionada.getPuntaje();
    }
}
