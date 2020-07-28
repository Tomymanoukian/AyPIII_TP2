package edu.fiuba.algo3.modelo;

import java.util.Collection;
import java.util.List;

public class MultipleChoiceParcial extends Pregunta {
    private List<Respuesta> respuestasCorrectas;
    private List<Respuesta> respuestasIncorrectas;

    public MultipleChoiceParcial(String unaConsigna, List<Respuesta> unasRespuestasCorrectas, List<Respuesta> unasRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasIncorrectas;
    }

    @Override
    public int calcularPuntajePara(List<Respuesta> respuestas){
        /*if(respuestas.obtenerCoincidencias(respuestasIncorrectas) > 0) {
            return 0;
        }else {
            return respuestas.obtenerCoincidencias(respuestasCorrectas);
        }*/
        return 0;
    }

    public List<Respuesta> getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public List<Respuesta> getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }
}
