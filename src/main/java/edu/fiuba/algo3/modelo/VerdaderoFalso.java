package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso extends Pregunta {

    private List<Respuesta> respuestas;

    public VerdaderoFalso(String unaConsigna, List<Respuesta> unasRespuestas){
        consigna = unaConsigna;
        respuestas = unasRespuestas;
    }

}
