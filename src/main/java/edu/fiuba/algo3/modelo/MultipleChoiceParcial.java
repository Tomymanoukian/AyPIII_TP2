package edu.fiuba.algo3.modelo;

public class MultipleChoiceParcial extends Pregunta {
    private final ListaOpciones opcionesCorrectas;
    private final ListaOpciones opcionesIncorrectas;

    public MultipleChoiceParcial(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    @Override
    public void evaluarRespuestaPara(Respuesta unaRespuesta, Jugador unJugador) {
        ListaOpciones opcionesSeleccionadas = unaRespuesta.getOpcionesSeleccionadas();
        if (opcionesSeleccionadas.obtenerCoincidencias(opcionesIncorrectas) == 0) {
            opcionesSeleccionadas.aplicarPuntajesA(unJugador);
        }
    }

    public ListaOpciones getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public ListaOpciones getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }
}
