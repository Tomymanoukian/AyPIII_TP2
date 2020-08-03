package edu.fiuba.algo3.modelo;

public abstract class Pregunta {
    protected String consigna;

    public String getConsigna() {
        return  consigna;
    }

    public abstract void evaluarRespuestaPara(Respuesta respuesta , Jugador jugador);
}
