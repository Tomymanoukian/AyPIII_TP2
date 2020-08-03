package edu.fiuba.algo3.modelo;

public class MultipleChoiceClasico extends Pregunta {
    private final ListaOpciones opcionesCorrectas;
    private final ListaOpciones opcionesIncorrectas;

    public MultipleChoiceClasico(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    public String getConsigna() {
        return super.getConsigna();
    }

    public ListaOpciones getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public ListaOpciones getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }

    public int calcularPuntajePara(ListaOpciones opcionesSeleccionadas) {
        if (opcionesSeleccionadas.contieneLoMismo(opcionesCorrectas)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void evaluarRespuestaPara(Respuesta respuesta, Jugador jugador) {
        ListaOpciones opcionesSeleccionadas = respuesta.getOpcionesSeleccionadas();
        jugador.modificarPuntos(this.calcularPuntajePara(opcionesSeleccionadas));
    }



}
