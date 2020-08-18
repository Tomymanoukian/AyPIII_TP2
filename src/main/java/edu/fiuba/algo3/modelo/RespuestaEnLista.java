package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoValidaException;

public class RespuestaEnLista extends Respuesta {

    private ListaOpciones opcionesSeleccionadas;

    public RespuestaEnLista(ListaOpciones unasOpcionesSeleccionadas) {
        opcionesSeleccionadas = unasOpcionesSeleccionadas;
    }

    @Override
    public Puntaje calcularPuntaje() {
        return opcionesSeleccionadas.calcularPuntaje();
    }

    @Override
    public boolean contieneLoMismo(ListaOpciones opciones) {
        return opcionesSeleccionadas.contieneLoMismo(opciones);
    }

    public boolean contieneAlguna(ListaOpciones opciones) {
        return opcionesSeleccionadas.contieneAlguna(opciones);
    }

    @Override
    public boolean esIgual(ListaOpciones listaDeOpciones) {
        return opcionesSeleccionadas.esIgual(listaDeOpciones);
    }


    public ListaOpciones getOpcionesSeleccionadas() {
        return opcionesSeleccionadas;
    }
}
