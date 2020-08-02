package edu.fiuba.algo3.modelo;

public class MultipleChoiceParcial extends Pregunta {
    private final ListaOpciones respuestasCorrectas;
    private final ListaOpciones respuestasIncorrectas;

    public MultipleChoiceParcial(String unaConsigna, ListaOpciones unasRespuestasCorrectas, ListaOpciones unasRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasIncorrectas;
    }

    @Override
    public void evaluarRespuestaPara(ListaOpciones respuestas, Jugador jugador) {
        if (respuestas.obtenerCoincidencias(respuestasIncorrectas) == 0) {
            this.aplicarPuntajePara(respuestas, jugador);
        }
    }

    public void aplicarPuntajePara(ListaOpciones respuestas, Jugador jugador) {
        respuestas.aplicarPuntajesA(jugador);
    }

    public ListaOpciones getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public ListaOpciones getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }
}
