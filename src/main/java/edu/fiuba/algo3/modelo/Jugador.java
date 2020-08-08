package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorSinNombreException;

public class Jugador {
    private Puntaje puntaje;
    private String nombre;

    public Jugador(String unNombre) {
        if (unNombre.equals("")) {
            throw new JugadorSinNombreException();
        }
        nombre = unNombre;
        puntaje = new Puntaje();
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }


    public void sumarPuntos(Puntaje unPuntaje) {
        puntaje.sumarPuntos(unPuntaje);
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
}
