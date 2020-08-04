package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorSinNombreException;

public class Jugador {
    private int puntos;
    private String nombre;

    public Jugador(String unNombre) {
        if (unNombre.equals("")) {
            throw new JugadorSinNombreException();
        }
        nombre = unNombre;
        puntos = 0;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }


    public void modificarPuntos(int unPuntaje) {
        puntos += unPuntaje;
    }
}
