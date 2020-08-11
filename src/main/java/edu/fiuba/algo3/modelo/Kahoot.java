package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.InterfazDeUsuario;
import edu.fiuba.algo3.modelo.excepciones.EstaPreguntaNoAceptaExclusividadesException;
import edu.fiuba.algo3.modelo.excepciones.EstaPreguntaNoAceptaMultiplicadoresException;

import java.util.Observable;
import java.util.Observer;

public class Kahoot{

    private Jugador jugador1;
    private Jugador jugador2;
    private Respuesta respuestaJugador1;
    private Respuesta respuestaJugador2;
    private ListaDeExclusividades exclusividadesJ1;
    private ListaDeExclusividades exclusividadesJ2;
    private ListaDeMultiplicadores multiplicadoresJ1;
    private ListaDeMultiplicadores multiplicadoresJ2;
    private InterfazDeUsuario interfazDeUsuario;

    public Kahoot(Jugador unJugador, Jugador otroJugador) {
        jugador1 = unJugador;
        jugador2 = otroJugador;
        exclusividadesJ1 = new ListaDeExclusividades();
        exclusividadesJ2 = new ListaDeExclusividades();
        multiplicadoresJ1 = new ListaDeMultiplicadores();
        multiplicadoresJ2 = new ListaDeMultiplicadores();
    }

    public void setRespuestaJugador1(Respuesta unaRespuesta) {
        respuestaJugador1 = unaRespuesta;
    }

    public void setRespuestaJugador2(Respuesta unaRespuesta) {
        respuestaJugador2 = unaRespuesta;
    }

    public void agregarExclusividadJugador1(Pregunta unaPregunta){

        if (!unaPregunta.aceptaExclusividad())
            throw new EstaPreguntaNoAceptaExclusividadesException();

        exclusividadesJ1.agregarExclusividad(jugador1.utilizarExclusividad());
    }

    public void agregarExclusividadJugador2(Pregunta unaPregunta){

        if (!unaPregunta.aceptaExclusividad())
            throw new EstaPreguntaNoAceptaExclusividadesException();

        exclusividadesJ2.agregarExclusividad(jugador2.utilizarExclusividad());
    }

    public void agregarMultiplicadorX2Jugador1(Pregunta unaPregunta){

        if (!unaPregunta.aceptaMultiplicador())
            throw new EstaPreguntaNoAceptaMultiplicadoresException();

        multiplicadoresJ1.agregarMultiplicador(jugador1.utilizarMultiplicadorX2());
    }

    public void agregarMultiplicadorX2Jugador2(Pregunta unaPregunta){

        if (!unaPregunta.aceptaMultiplicador())
            throw new EstaPreguntaNoAceptaMultiplicadoresException();

        multiplicadoresJ2.agregarMultiplicador(jugador2.utilizarMultiplicadorX2());
    }

    public void agregarMultiplicadorX3Jugador1(Pregunta unaPregunta){

        if (!unaPregunta.aceptaMultiplicador())
            throw new EstaPreguntaNoAceptaMultiplicadoresException();

        multiplicadoresJ1.agregarMultiplicador(jugador1.utilizarMultiplicadorX3());
    }

    public void agregarMultiplicadorX3Jugador2(Pregunta unaPregunta){

        if (!unaPregunta.aceptaMultiplicador())
            throw new EstaPreguntaNoAceptaMultiplicadoresException();

        multiplicadoresJ2.agregarMultiplicador(jugador2.utilizarMultiplicadorX3());
    }

    public void evaluarRespuestas(Pregunta unaPregunta) {
        Puntaje puntajeJ1 = new Puntaje();
        Puntaje puntajeJ2 = new Puntaje();

        puntajeJ1.sumarPuntos(unaPregunta.evaluarRespuestaPara(respuestaJugador1));
        puntajeJ2.sumarPuntos(unaPregunta.evaluarRespuestaPara(respuestaJugador2));

        BonusDePuntaje.aplicarbonus(puntajeJ1, multiplicadoresJ1, exclusividadesJ1, puntajeJ2, multiplicadoresJ2, exclusividadesJ2);

        jugador1.sumarPuntos(puntajeJ1);
        jugador2.sumarPuntos(puntajeJ2);
    }

    public Puntaje getPuntajeJugador1() {
        return jugador1.getPuntaje();
    }

    public Puntaje getPuntajeJugador2() {
        return jugador2.getPuntaje();
    }

    public void iniciarJuego() {

        VerdaderoFalsoClasico pregunta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("Elegi:");

        pregunta.mostrarseEn(interfazDeUsuario);
    }

    public void setInterfazVisual(InterfazDeUsuario unaInterfazDeUsuario) {
        interfazDeUsuario = unaInterfazDeUsuario;
    }
}
