package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Bonus.BonusDePuntaje;
import edu.fiuba.algo3.modelo.Bonus.ListaDeExclusividades;
import edu.fiuba.algo3.modelo.Bonus.ListaDeMultiplicadores;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoValidoException;
import edu.fiuba.algo3.modelo.excepciones.EstaPreguntaNoAceptaExclusividadesException;
import edu.fiuba.algo3.modelo.excepciones.EstaPreguntaNoAceptaMultiplicadoresException;

public class Kahoot{

    private Jugador jugador1;
    private Jugador jugador2;
    private Respuesta respuestaJugador1;
    private Respuesta respuestaJugador2;
    private ListaDeExclusividades exclusividades;
    private ListaDeMultiplicadores multiplicadoresJ1;
    private ListaDeMultiplicadores multiplicadoresJ2;

    public Kahoot(Jugador unJugador, Jugador otroJugador) {

        jugador1 = unJugador;
        jugador2 = otroJugador;
        exclusividades = new ListaDeExclusividades();
        multiplicadoresJ1 = new ListaDeMultiplicadores();
        multiplicadoresJ2 = new ListaDeMultiplicadores();
    }

    public void setRespuestaJugador(Respuesta unaRespuesta, Jugador jugador) {

        if(jugador == jugador1) {
            respuestaJugador1 = unaRespuesta;
        }
        else if(jugador == jugador2) {
            respuestaJugador2 = unaRespuesta;
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void setRespuestaJugador1(Respuesta unaRespuesta) {
        respuestaJugador1 = unaRespuesta;
    }

    public void setRespuestaJugador2(Respuesta unaRespuesta) {
        respuestaJugador2 = unaRespuesta;
    }

    public void agregarExclusividad(Pregunta unaPregunta, Jugador jugador){

        if (!unaPregunta.aceptaExclusividad())
            throw new EstaPreguntaNoAceptaExclusividadesException();

        if(jugador == jugador1 || jugador == jugador2) {
            exclusividades.agregarExclusividad(jugador.utilizarExclusividad());
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void agregarMultiplicadorX2(Pregunta unaPregunta, Jugador jugador){

        if (!unaPregunta.aceptaMultiplicador())
            throw new EstaPreguntaNoAceptaMultiplicadoresException();

        if(jugador == jugador1) {
            multiplicadoresJ1.agregarMultiplicador(jugador.utilizarMultiplicadorX2());
        }
        else if(jugador == jugador2) {
            multiplicadoresJ2.agregarMultiplicador(jugador.utilizarMultiplicadorX2());
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void agregarMultiplicadorX3(Pregunta unaPregunta, Jugador jugador){

        if (!unaPregunta.aceptaMultiplicador())
            throw new EstaPreguntaNoAceptaMultiplicadoresException();

        if(jugador == jugador1) {
            multiplicadoresJ1.agregarMultiplicador(jugador.utilizarMultiplicadorX3());
        }
        else if(jugador == jugador2) {
            multiplicadoresJ2.agregarMultiplicador(jugador.utilizarMultiplicadorX3());
        }
        else{
            throw new JugadorNoValidoException();
        }
    }

    public void evaluarRespuestas(Pregunta unaPregunta) {

        Puntaje puntajeJ1 = new Puntaje();
        Puntaje puntajeJ2 = new Puntaje();

        puntajeJ1.sumarPuntos(unaPregunta.evaluarRespuestaPara(respuestaJugador1));
        puntajeJ2.sumarPuntos(unaPregunta.evaluarRespuestaPara(respuestaJugador2));

        BonusDePuntaje.aplicarbonus(puntajeJ1, multiplicadoresJ1, puntajeJ2, multiplicadoresJ2, exclusividades);

        jugador1.sumarPuntos(puntajeJ1);
        jugador2.sumarPuntos(puntajeJ2);

        exclusividades.limpiarExclusividades();
        multiplicadoresJ1.limpiarMultiplicadores();
        multiplicadoresJ2.limpiarMultiplicadores();

    }

    public Jugador getJugadorGanador(){

        if( jugador1.getPuntaje().esMenorQue(jugador2.getPuntaje())){
            return jugador2;
        }
        return jugador1;
    }

    public Jugador getJugadorPerdedor(){

        if( jugador1.getPuntaje().esMenorQue(jugador2.getPuntaje())){
            return jugador1;
        }
        return jugador2;
    }


    public Puntaje getPuntajeJugador1() {
        return jugador1.getPuntaje();
    }

    public Puntaje getPuntajeJugador2() {
        return jugador2.getPuntaje();
    }

    public Jugador getJugador1() {return jugador1;}

    public Jugador getJugador2() {return jugador2;}
}
