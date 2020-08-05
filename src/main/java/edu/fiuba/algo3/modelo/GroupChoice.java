package edu.fiuba.algo3.modelo;

public class GroupChoice extends Pregunta{

    private ListaOpciones opcionesGrupoA;
    private ListaOpciones opcionesGrupoB;

    public GroupChoice(String unaConsigna, ListaOpciones unasOpcionesGrupoA, ListaOpciones unasOpcionesGrupoB) {
        super();
        consigna = unaConsigna;
        opcionesGrupoA = unasOpcionesGrupoA;
        opcionesGrupoB = unasOpcionesGrupoB;
    }

    @Override
    public int evaluarRespuestaPara(Respuesta unaRespuesta) {
        ListaOpciones opcionesSeleccionadasGrupoA = unaRespuesta.getOpcionesSeleccionadasGrupoA();
        ListaOpciones opcionesSeleccionadasGrupoB = unaRespuesta.getOpcionesSeleccionadasGrupoB();

        if(opcionesSeleccionadasGrupoA.contieneLoMismo(opcionesGrupoA) && opcionesSeleccionadasGrupoB.contieneLoMismo(opcionesGrupoB)){
            return 1;
        }
        return 0;

        //unJugador.modificarPuntos(unaRespuesta.calcularPuntaje(opcionesGrupoA, opcionesGrupoB));
    }

    public ListaOpciones getOpcionesGrupoA() { return opcionesGrupoA; }

    public ListaOpciones getOpcionesGrupoB() { return opcionesGrupoB; }
}
