package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class OrderedChoice extends Pregunta {

    private final ListaOpciones listaDeOpciones;

    public OrderedChoice(String unaConsigna, ListaOpciones unaListaDeOpciones) {
        super();
        if (unaListaDeOpciones.cantidadDeRespuestas() < 2 || unaListaDeOpciones.cantidadDeRespuestas() > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        listaDeOpciones = unaListaDeOpciones;
    }

    public ListaOpciones getOpciones() {return listaDeOpciones;}

    public String getConsigna() {
        return super.getConsigna();
    }

    public int calcularPuntajePara(ListaOpciones opcionesElegidas) {
        if(listaDeOpciones.esIgual(opcionesElegidas)){
            return 1;
        }
        return 0;
    }

    @Override
    public int evaluarRespuestaPara(Respuesta unaRespuesta, Jugador unJugador) {
        return this.calcularPuntajePara(unaRespuesta.getOpcionesSeleccionadas()));
    }
}
