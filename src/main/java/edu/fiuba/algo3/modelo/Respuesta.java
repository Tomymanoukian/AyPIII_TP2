package edu.fiuba.algo3.modelo;

public interface Respuesta {
    ListaOpciones getOpcionesSeleccionadas();

    Opcion getOpcionSeleccionada();

    ListaOpciones getOpcionesSeleccionadasGrupoA();

    ListaOpciones getOpcionesSeleccionadasGrupoB();

    Puntaje calcularPuntaje();

    boolean contieneLoMismo(ListaOpciones opciones);

    boolean contieneAlguna(ListaOpciones opcionesIncorrectas);
    
    boolean esIgual(ListaOpciones listaDeOpciones);
}
