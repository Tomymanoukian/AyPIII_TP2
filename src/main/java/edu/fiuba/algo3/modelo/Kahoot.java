package edu.fiuba.algo3.modelo;

public class Kahoot {
    Jugador jugador1;
    Jugador jugador2;
    Respuesta respuestaJugador1;
    Respuesta respuestaJugador2;
    ListaDeExclusividades exclusividadesJ1;
    ListaDeExclusividades exclusividadesJ2;
    ListaDeMultiplicadores multiplicadoresJ1;
    ListaDeMultiplicadores multiplicadoresJ2;

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

    public void agregarExclusividadJugador1(Exclusividad unaExclusividad){exclusividadesJ1.agregarExclusividad(unaExclusividad);}

    public void agregarExclusividadJugador2(Exclusividad unaExclusividad){exclusividadesJ2.agregarExclusividad(unaExclusividad);}

    public void agregarMultiplicadorJugador1(Multiplicador unMultiplicador){ multiplicadoresJ1.agregarMultiplicador(unMultiplicador);}

    public void agregarMultiplicadorJugador2(Multiplicador unMultiplicador){ multiplicadoresJ2.agregarMultiplicador(unMultiplicador);}

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


}
