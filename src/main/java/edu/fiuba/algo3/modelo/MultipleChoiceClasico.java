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

    public String getConsigna() {
        return super.getConsigna();
    }

    public ListaRespuestas getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public ListaRespuestas getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }


    @Override
    public int calcularPuntajePara(ListaRespuestas unasRespuestas) {
        if(unasRespuestas.contieneLoMismo(respuestasCorrectas)) {
            return 1;
        }
        return 0;
    }
}
