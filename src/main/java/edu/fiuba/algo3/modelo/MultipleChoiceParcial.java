package edu.fiuba.algo3.modelo;

public class MultipleChoiceParcial extends Pregunta {
    private final ListaRespuestas respuestasCorrectas;
    private final ListaRespuestas respuestasIncorrectas;

    public MultipleChoiceParcial(String unaConsigna, ListaRespuestas unasRespuestasCorrectas, ListaRespuestas unasRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasIncorrectas;
    }

    @Override
    public void evaluarRespuestaPara(ListaRespuestas respuestas, Jugador jugador) {
        if (respuestas.obtenerCoincidencias(respuestasIncorrectas) == 0) {
            this.aplicarPuntajePara(respuestas, jugador);
        }
    }

    public void aplicarPuntajePara(ListaRespuestas respuestas, Jugador jugador) {
        respuestas.aplicarPuntajesA(jugador);
    }

    public ListaRespuestas getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public ListaRespuestas getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }
}
