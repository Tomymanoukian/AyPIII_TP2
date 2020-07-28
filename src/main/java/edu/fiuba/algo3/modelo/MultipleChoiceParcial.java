package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceParcial extends Pregunta {
    private List<Respuesta> respuestasCorrectas;
    private List<Respuesta> respuestasIncorrectas;

    public MultipleChoiceParcial(String unaConsigna, List<Respuesta> unasRespuestasCorrectas, List<Respuesta> unaRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasCorrectas;
    }

    @Override
    public int calcularPuntajePara(List<Respuesta> respuestas){
        return 0;
    }

}
