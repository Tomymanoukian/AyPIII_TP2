package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta{
    private List<Respuesta> respuestasCorrectas;
    private List<Respuesta> respuestasIncorrectas;

    public MultipleChoiceClasico(String unaConsigna, List<Respuesta> unasRespuestasCorrectas, List<Respuesta> unasRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasIncorrectas;
    }

    @Override
    public int calcularPuntajePara(List<Respuesta> unasRespuestas) {
        return 0;
    }
}
