package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoClasico extends Pregunta {
    private Respuesta respuesCorrecta;
    private static final Respuesta verdadero = new Respuesta("Verdadero");
    private static final Respuesta falso = new Respuesta("Falso");



    public VerdaderoFalsoClasico(String unaConsigna){
        consigna = unaConsigna;
    }
    public static VerdaderoFalsoClasico crearVerdaderoFalsoVerdadera(String unaConsigna){
        VerdaderoFalsoClasico verdaderoFalsoClasico = new VerdaderoFalsoClasico(unaConsigna);
        verdaderoFalsoClasico.setRespuestaCorrectaVerdadero();
        return verdaderoFalsoClasico;
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoFalsa(String unaConsigna) {
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
}
