package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class GroupChoice extends Pregunta{

    private ListaOpciones opcionesGrupoA;
    private ListaOpciones opcionesGrupoB;

    public GroupChoice(String unaConsigna, ListaOpciones unasOpcionesGrupoA, ListaOpciones unasOpcionesGrupoB) {
        super();
        if ((unasOpcionesGrupoA.cantidadDeRespuestas() + unasOpcionesGrupoB.cantidadDeRespuestas()) < 2 ||
                (unasOpcionesGrupoA.cantidadDeRespuestas() + unasOpcionesGrupoB.cantidadDeRespuestas()) > 6) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesGrupoA = unasOpcionesGrupoA;
        opcionesGrupoB = unasOpcionesGrupoB;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {
        Puntaje puntaje = new Puntaje(0);

        if(respuesta.grupoAContieneLoMismo(opcionesGrupoA) && respuesta.grupoBContieneLoMismo(opcionesGrupoB)){
            puntaje.establecerPuntos(1);
        }
        return puntaje;

        //unJugador.modificarPuntos(unaRespuesta.calcularPuntaje(opcionesGrupoA, opcionesGrupoB));
    }

    public ListaOpciones getOpcionesGrupoA() { return opcionesGrupoA; }

    public ListaOpciones getOpcionesGrupoB() { return opcionesGrupoB; }

    @Override
    public Boolean aceptaMultiplicador() {return false;}

    @Override
    public Boolean aceptaExclusividad() {return true;}
}
