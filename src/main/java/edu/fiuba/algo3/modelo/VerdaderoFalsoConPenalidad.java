package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoConPenalidad extends Pregunta{
    private Respuesta respuesCorrecta;
    private static final Respuesta verdadero = new Respuesta("Verdadero");
    private static final Respuesta falso = new Respuesta("Falso");

    public VerdaderoFalsoConPenalidad(String unaConsigna) {
        super();
        consigna = unaConsigna;
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {
        return new VerdaderoFalsoConPenalidad(unaConsigna);
    }

    @Override
    public int calcularPuntajePara(ListaRespuestas respuestas) {
        return 0;
    }
}
