package edu.fiuba.algo3.modelo;

public abstract class MultipleChoice extends Pregunta {

    protected ListaOpciones opcionesCorrectas;
    protected ListaOpciones opcionesIncorrectas;

    public ListaOpciones getOpcionesCorrectas() {return opcionesCorrectas;}

    public ListaOpciones getOpcionesIncorrectas() {return opcionesIncorrectas;}

    public ListaOpciones getTodasLasOpcionesMezcladas(){

        ListaOpciones todasLasOpciones = new ListaOpciones();
        todasLasOpciones.agregarTodo(opcionesCorrectas);
        todasLasOpciones.agregarTodo(opcionesIncorrectas);
        todasLasOpciones.desordenar();

        return todasLasOpciones;
    }
}
