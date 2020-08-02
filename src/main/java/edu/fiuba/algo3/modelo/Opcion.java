package edu.fiuba.algo3.modelo;

public class Opcion {
    private final String opcion;
    private final int puntaje;

    public Opcion(String unaRespuesta) {
        opcion = unaRespuesta;
        puntaje = 0;
    }

    public Opcion(String unaRespuesta, int unPuntaje) {
        opcion = unaRespuesta;
        puntaje = unPuntaje;
    }

    public boolean esIgualA(Opcion unaOpcion) {
        return this.getOpcion().equals(unaOpcion.getOpcion());
    }

    public String getOpcion() {
        return opcion;
    }

    public void aplicarPuntajeA(Jugador unJugador) {
        unJugador.modificarPuntos(puntaje);
    }

    public int getPuntaje() {
        return puntaje;
    }
}
