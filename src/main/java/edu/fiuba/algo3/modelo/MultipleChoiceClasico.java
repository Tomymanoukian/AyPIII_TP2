package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta{
    private ListaRespuestas respuestasCorrectas;
    private ListaRespuestas respuestasIncorrectas;

    public MultipleChoiceClasico(String unaConsigna, ListaRespuestas unasRespuestasCorrectas, ListaRespuestas unasRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasIncorrectas;
    }

    @Override
    public int calcularPuntajePara(ListaRespuestas unasRespuestas) {
        return 0;
    }
}
