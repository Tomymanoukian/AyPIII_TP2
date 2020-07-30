package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoConPenalidad extends VerdaderoFalso {
    public VerdaderoFalsoConPenalidad(String unaConsigna) {
        super();
        consigna = unaConsigna;
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(unaConsigna);
        verdaderoFalsoConPenalidad.setRespuestaCorrectaFalso();

        return verdaderoFalsoConPenalidad;
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoVerdadero(String unaConsigna) {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(unaConsigna);
        verdaderoFalsoConPenalidad.setRespuestaCorrectaVerdadero();

        return verdaderoFalsoConPenalidad;
    }


    private void setRespuestaCorrectaFalso() {
        respuestaIncorrecta = new Respuesta("Verdadero", -1);
        respuestaCorrecta = new Respuesta("Falso", 1);
    }

    private void setRespuestaCorrectaVerdadero() {
        respuestaCorrecta = new Respuesta("Verdadero", 1);
        respuestaIncorrecta = new Respuesta("Falso", -1);
    }




}
