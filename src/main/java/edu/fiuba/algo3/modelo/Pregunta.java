package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Pregunta {
    protected String consigna;

    public String getConsigna() {
        return  consigna;
    }

    public abstract void evaluarRespuestaPara(ListaRespuestas respuestas , Jugador jugador);
}
