package edu.fiuba.algo3.modelo;

public abstract class MultipleChoice extends Pregunta {

    public abstract ListaOpciones getOpcionesCorrectas();

    public abstract ListaOpciones getOpcionesIncorrectas();

    public abstract ListaOpciones getTodasLasOpcionesMezcladas();
}
