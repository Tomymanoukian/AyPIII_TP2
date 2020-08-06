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
    public Puntaje evaluarRespuestaPara(Respuesta unaRespuesta) {
        Puntaje puntaje = new Puntaje();
        ListaOpciones opcionesSeleccionadasGrupoA = unaRespuesta.getOpcionesSeleccionadasGrupoA();
        ListaOpciones opcionesSeleccionadasGrupoB = unaRespuesta.getOpcionesSeleccionadasGrupoB();

        if(opcionesSeleccionadasGrupoA.contieneLoMismo(opcionesGrupoA) && opcionesSeleccionadasGrupoB.contieneLoMismo(opcionesGrupoB)){
            puntaje.establecerPuntos(1);
        }
        return puntaje;

        //unJugador.modificarPuntos(unaRespuesta.calcularPuntaje(opcionesGrupoA, opcionesGrupoB));
    }

    public ListaOpciones getOpcionesGrupoA() { return opcionesGrupoA; }

    public ListaOpciones getOpcionesGrupoB() { return opcionesGrupoB; }
}
