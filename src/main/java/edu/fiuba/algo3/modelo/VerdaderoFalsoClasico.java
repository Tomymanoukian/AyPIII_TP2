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
        opcionIncorrecta = new Opcion("Verdadero", new Puntaje(0));
        opcionCorrecta = new Opcion("Falso", new Puntaje(1));
    }

    private void setRespuestaCorrectaVerdadero() {
        opcionCorrecta = new Opcion("Verdadero", new Puntaje(1));
        opcionIncorrecta = new Opcion("Falso", new Puntaje(0));
    }

}
