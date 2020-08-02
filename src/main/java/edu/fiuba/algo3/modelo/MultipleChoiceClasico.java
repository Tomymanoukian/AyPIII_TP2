package edu.fiuba.algo3.modelo;

public class MultipleChoiceClasico extends Pregunta {
    private final ListaOpciones respuestasCorrectas;
    private final ListaOpciones respuestasIncorrectas;

    public MultipleChoiceClasico(String unaConsigna, ListaOpciones unasRespuestasCorrectas, ListaOpciones unasRespuestasIncorrectas) {
        super();
        consigna = unaConsigna;
        respuestasCorrectas = unasRespuestasCorrectas;
        respuestasIncorrectas = unasRespuestasIncorrectas;
    }

    public String getConsigna() {
        return super.getConsigna();
    }

    public ListaOpciones getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public ListaOpciones getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }

    public int calcularPuntajePara(ListaOpciones unasRespuestas) {
        if (unasRespuestas.contieneLoMismo(respuestasCorrectas)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void evaluarRespuestaPara(ListaOpciones unasRespuestas, Jugador jugador) {
        jugador.modificarPuntos(this.calcularPuntajePara(unasRespuestas));
    }



}
