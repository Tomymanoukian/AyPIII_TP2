package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoValidaException;

public class RespuestaUnica implements Respuesta {

    private Opcion opcionSeleccionada;

    public RespuestaUnica(Opcion unaOpcionSeleccionada) {
        opcionSeleccionada = unaOpcionSeleccionada;
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadas() {
        throw new RespuestaNoValidaException();
    }

    @Override
    public Opcion getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoA() { throw new RespuestaNoValidaException(); }

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoB() { throw new RespuestaNoValidaException(); }
}
