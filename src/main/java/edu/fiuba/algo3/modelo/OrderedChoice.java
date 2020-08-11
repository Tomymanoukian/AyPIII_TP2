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

    public Puntaje calcularPuntajePara(Respuesta respuestaEnLista) {
        Puntaje puntaje = new Puntaje(0);
        if(respuestaEnLista.esIgual(listaDeOpciones)){
            puntaje.establecerPuntos(1);
        }
        return puntaje;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuestaEnLista) {
        return this.calcularPuntajePara(respuestaEnLista);
    }

    @Override
    public Boolean aceptaMultiplicador() {return false;}

    @Override
    public Boolean aceptaExclusividad() {return true;}
}
