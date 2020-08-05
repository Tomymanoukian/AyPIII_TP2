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
        opcionIncorrecta = new Opcion("Verdadero", -1);
        opcionCorrecta = new Opcion("Falso", 1);
    }

    private void setRespuestaCorrectaVerdadero() {
        opcionCorrecta = new Opcion("Verdadero", 1);
        opcionIncorrecta = new Opcion("Falso", -1);
    }




}
