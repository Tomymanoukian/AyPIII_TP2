package edu.fiuba.algo3.modelo;

public class Respuesta {
    protected String respuesta;

    public Respuesta(String unaRespuesta) {
        respuesta = unaRespuesta;
    }

    public boolean esIgualA(Respuesta unaRespuesta) {
        return this.getRespuesta().equals(unaRespuesta.getRespuesta());
    }

    private String getRespuesta() {
        return respuesta;
    }
}
