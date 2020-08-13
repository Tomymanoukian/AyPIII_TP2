package edu.fiuba.algo3.modelo;

public class Opcion {
    private final String opcion;
    private final Puntaje puntaje;

    public Opcion(String unaRespuesta) {
        opcion = unaRespuesta;
        puntaje = new Puntaje();
    }

    public Opcion(String unaRespuesta, Puntaje unPuntaje) {
        opcion = unaRespuesta;
        puntaje = unPuntaje;
    }

    public Opcion (Opcion unaOpcion) {
        opcion = unaOpcion.getOpcion();
        puntaje = unaOpcion.getPuntaje();
    }

    public boolean esIgualA(Opcion unaOpcion) {
        return this.getOpcion().equals(unaOpcion.getOpcion());
    }

    public String getOpcion() {
        return opcion;
    }

    public void aplicarPuntajeA(Jugador unJugador) {
        unJugador.sumarPuntos(puntaje);
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }
}
