package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoValidaException;

public class RespuestaEnLista implements Respuesta {

    private ListaOpciones opcionesSeleccionadas;

    public RespuestaEnLista(ListaOpciones unasOpcionesSeleccionadas) {
        opcionesSeleccionadas = unasOpcionesSeleccionadas;
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadas() {
        return opcionesSeleccionadas;
    }

    @Override
    public Opcion getOpcionSeleccionada() {
        throw new RespuestaNoValidaException();
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoA() {
        throw new RespuestaNoValidaException();
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoB() {
        throw new RespuestaNoValidaException();
    }

    @Override
    public Puntaje calcularPuntaje() {
        return opcionesSeleccionadas.calcularPuntaje();
    }

    @Override
    public boolean contieneLoMismo(ListaOpciones opciones) {
        return opcionesSeleccionadas.contieneLoMismo(opciones);
    }

    @Override
    public boolean contieneAlguna(ListaOpciones opciones) {
        return opcionesSeleccionadas.contieneAlguna(opciones);
    }

    @Override
    public boolean esIgual(ListaOpciones listaDeOpciones) {
        return listaDeOpciones.esIgual(listaDeOpciones);
    }


}
