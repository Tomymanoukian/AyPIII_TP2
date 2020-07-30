package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoClasico extends VerdaderoFalso {

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
        respuestaIncorrecta = new Respuesta("Verdadero", 0);
        respuestaCorrecta = new Respuesta("Falso", 1);
    }

    private void setRespuestaCorrectaVerdadero() {
        respuestaCorrecta = new Respuesta("Verdadero", 1);
        respuestaIncorrecta = new Respuesta("Falso", 0);
    }

    public int calcularPuntajePara(ListaRespuestas respuestas) {
        return respuestas.obtenerPrimero().getPuntaje();
    }



}
