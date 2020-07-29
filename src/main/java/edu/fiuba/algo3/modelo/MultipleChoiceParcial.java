package edu.fiuba.algo3.modelo;

import java.util.Collection;
import java.util.List;

public class MultipleChoiceParcial extends Pregunta {
    private ListaRespuestas respuestasCorrectas;
    private ListaRespuestas respuestasIncorrectas;

    public MultipleChoiceParcial(String unaConsigna, ListaRespuestas unasRespuestasCorrectas, ListaRespuestas unasRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasIncorrectas;
    }

    @Override
    public int calcularPuntajePara(ListaRespuestas respuestas){
        if(respuestas.obtenerCoincidencias(respuestasIncorrectas) > 0) {
            return 0;
        }else {
            return respuestas.obtenerCoincidencias(respuestasCorrectas);
        }
    }

    public ListaRespuestas getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public ListaRespuestas getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }
}
