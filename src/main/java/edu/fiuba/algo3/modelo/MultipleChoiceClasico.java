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

    public Puntaje calcularPuntajePara(ListaOpciones opcionesSeleccionadas) {
        Puntaje puntaje = new Puntaje();
        if (opcionesSeleccionadas.contieneLoMismo(opcionesCorrectas)) {
            puntaje.establecerPuntos(1);
        }
        return puntaje;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {
        ListaOpciones opcionesSeleccionadas = respuesta.getOpcionesSeleccionadas();
        return(this.calcularPuntajePara(opcionesSeleccionadas));
    }



}
