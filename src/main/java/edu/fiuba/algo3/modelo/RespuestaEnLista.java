package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoValidaException;

public class RespuestaEnLista implements Respuesta {

    private ListaOpciones respuestasSeleccionadas;

    public RespuestaEnLista(ListaOpciones unasOpcionesSeleccionadas) {
        respuestasSeleccionadas = unasOpcionesSeleccionadas;
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadas() {
        return respuestasSeleccionadas;
    }

    @Override
    public Opcion getOpcionSeleccionada() {
        throw new RespuestaNoValidaException();
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoA() { throw new RespuestaNoValidaException(); }

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoB() { throw new RespuestaNoValidaException(); }


}
