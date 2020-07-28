package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoClasico extends Pregunta {
    private Respuesta respuesCorrecta;
    private static final Respuesta verdadero = new Respuesta("Verdadero");
    private static final Respuesta falso = new Respuesta("Falso");


    public VerdaderoFalsoClasico(String unaConsigna) {
        consigna = unaConsigna;
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectaVerdadero(String unaConsigna) {
        VerdaderoFalsoClasico verdaderoFalsoClasico = new VerdaderoFalsoClasico(unaConsigna);
        verdaderoFalsoClasico.setRespuestaCorrectaVerdadero();
        return verdaderoFalsoClasico;
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {
        VerdaderoFalsoClasico verdaderoFalsoClasico = new VerdaderoFalsoClasico(unaConsigna);
        verdaderoFalsoClasico.setRespuestaCorrectaFalso();
        return verdaderoFalsoClasico;
    }

    private void setRespuestaCorrectaFalso() {
        respuesCorrecta = falso;
    }

    private void setRespuestaCorrectaVerdadero() {
        respuesCorrecta = verdadero;
    }

    public Respuesta getRespuestaCorrecta() {
        return respuesCorrecta;
    }

    @Override
    public int calcularPuntajePara(List<Respuesta> respuestas) {
        Respuesta respuesta = respuestas.get(0);

        if (!respuesta.esIgualA(verdadero) && !respuesta.esIgualA(falso)) {
            throw new RespuestaNoValidaException();
        }
        int puntaje = 0;
        if (respuesta.esIgualA(respuesCorrecta)) {
            puntaje = 1;
        }
        return puntaje;
    }
}
