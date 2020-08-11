package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.RespuestaNoValidaException;

public class RespuestaDeGrupos implements Respuesta{

    private ListaOpciones opcionesSeleccionadasGrupoA;
    private ListaOpciones opcionesSeleccionadasGrupoB;

    public RespuestaDeGrupos(ListaOpciones unasOpcionesSeleccionadasDelGrupoA, ListaOpciones unasOpcionesSeleccionadasDelGrupoB) {
        opcionesSeleccionadasGrupoA = unasOpcionesSeleccionadasDelGrupoA;
        opcionesSeleccionadasGrupoB = unasOpcionesSeleccionadasDelGrupoB;
    }

    /*public int calcularPuntaje(ListaOpciones unasOpcionesGrupoA, ListaOpciones unasOpcionesGrupoB){
        if(opcionesSeleccionadasGrupoA.contieneLoMismo(unasOpcionesGrupoA) && opcionesSeleccionadasGrupoB.contieneLoMismo(unasOpcionesGrupoB)){
            return 1;
        }return 0;
    }*/

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoA(){ return opcionesSeleccionadasGrupoA; }

    @Override
    public ListaOpciones getOpcionesSeleccionadasGrupoB(){ return opcionesSeleccionadasGrupoB; }

    @Override
    public Puntaje calcularPuntaje() {
        return null;
    }

    @Override
    public boolean contieneLoMismo(ListaOpciones opciones) {
        return false;
    }

    @Override
    public boolean contieneAlguna(ListaOpciones opcionesIncorrectas) {
        return false;
    }

    @Override
    public boolean esIgual(ListaOpciones listaDeOpciones) {
        return false;
    }

    @Override
    public ListaOpciones getOpcionesSeleccionadas() { throw new RespuestaNoValidaException(); }

    @Override
    public Opcion getOpcionSeleccionada() { throw new RespuestaNoValidaException(); }


}
