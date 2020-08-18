package edu.fiuba.algo3.modelo;

public abstract class MultipleChoice extends Pregunta {

    protected ListaOpciones opcionesCorrectas;
    protected ListaOpciones opcionesIncorrectas;

    public ListaOpciones getOpcionesCorrectas() {return opcionesCorrectas;}

    public ListaOpciones getOpcionesIncorrectas() {return opcionesIncorrectas;}
}
