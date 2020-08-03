package edu.fiuba.algo3.modelo;

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
    public ListaOpciones getOpcionesSeleccionadas() { throw new RespuestaNoValidaException(); }

    @Override
    public Opcion getOpcionSeleccionada() { throw new RespuestaNoValidaException(); }


}
