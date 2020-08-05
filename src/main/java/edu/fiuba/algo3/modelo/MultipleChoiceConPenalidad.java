package edu.fiuba.algo3.modelo;

public class MultipleChoiceConPenalidad extends Pregunta {
    private final ListaOpciones opcionesCorrectas;
    private final ListaOpciones opcionesIncorrectas;

    public MultipleChoiceConPenalidad(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    @Override
    public int evaluarRespuestaPara(Respuesta unaRespuesta) {
        ListaOpciones opcionesSeleccionadas = unaRespuesta.getOpcionesSeleccionadas();
        return opcionesSeleccionadas.calcularPuntaje();
    }

    public ListaOpciones getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public ListaOpciones getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }
}

