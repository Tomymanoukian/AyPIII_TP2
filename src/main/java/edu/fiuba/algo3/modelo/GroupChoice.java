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
    public void evaluarRespuestaPara(Respuesta unaRespuesta, Jugador unJugador) {
        ListaOpciones opcionesSeleccionadasGrupoA = unaRespuesta.getOpcionesSeleccionadasGrupoA();
        ListaOpciones opcionesSeleccionadasGrupoB = unaRespuesta.getOpcionesSeleccionadasGrupoB();

        if(opcionesSeleccionadasGrupoA.contieneLoMismo(opcionesGrupoA) && opcionesSeleccionadasGrupoB.contieneLoMismo(opcionesGrupoB)){
            unJugador.modificarPuntos(1);
        }
        unJugador.modificarPuntos(0);

        //unJugador.modificarPuntos(unaRespuesta.calcularPuntaje(opcionesGrupoA, opcionesGrupoB));
    }

    public ListaOpciones getOpcionesGrupoA() { return opcionesGrupoA; }

    public ListaOpciones getOpcionesGrupoB() { return opcionesGrupoB; }
}
