package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.OpcionNoValidaException;

public class VerdaderoFalsoConPenalidad extends Pregunta {

    protected Opcion opcionCorrecta;
    protected Opcion opcionIncorrecta;

    public VerdaderoFalsoConPenalidad(String unaConsigna) {
        super();
        consigna = unaConsigna;
    }

    public Opcion getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public Opcion getOpcionIncorrecta() {
        return opcionIncorrecta;
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
        opcionIncorrecta = new Opcion("Verdadero", new Puntaje(-1));
        opcionCorrecta = new Opcion("Falso", new Puntaje(1));
    }

    private void setRespuestaCorrectaVerdadero() {
        opcionCorrecta = new Opcion("Verdadero", new Puntaje(1));
        opcionIncorrecta = new Opcion("Falso", new Puntaje(-1));
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {
        Opcion opcionSeleccionada = respuesta.getOpcionSeleccionada();

        if (!opcionSeleccionada.esIgualA(opcionCorrecta) && !opcionSeleccionada.esIgualA(opcionIncorrecta)) {
            throw new OpcionNoValidaException();
        }

        return opcionSeleccionada.getPuntaje();
    }
}
