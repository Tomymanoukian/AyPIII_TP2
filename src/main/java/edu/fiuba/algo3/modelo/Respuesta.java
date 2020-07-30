package edu.fiuba.algo3.modelo;

public class Respuesta {
    private final String respuesta;
    private final int puntaje;

    public Respuesta(String unaRespuesta) {
        respuesta = unaRespuesta;
        puntaje = 0;
    }

    public Respuesta(String unaRespuesta, int unPuntaje) {
        respuesta = unaRespuesta;
        puntaje = unPuntaje;
    }

    public boolean esIgualA(Respuesta unaRespuesta) {
        return this.getRespuesta().equals(unaRespuesta.getRespuesta());
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void aplicarPuntajeA(Jugador unJugador) {
        unJugador.modificarPuntos(puntaje);
    }

    public int getPuntaje() {
        return puntaje;
    }
}
