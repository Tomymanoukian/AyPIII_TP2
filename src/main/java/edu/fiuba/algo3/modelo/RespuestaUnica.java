package edu.fiuba.algo3.modelo;

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
}
