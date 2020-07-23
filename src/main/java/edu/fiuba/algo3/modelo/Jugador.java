package edu.fiuba.algo3.modelo;

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

    public void aumentarPuntos(int unPuntaje) {
        if (unPuntaje < 0) {
            throw new PuntosNegativoException();
        }
        puntos += unPuntaje;
    }

    public void disminuirPuntos(int unPuntaje) {
        if (unPuntaje < 0) {
            throw new PuntosNegativoException();
        }
        if (puntos <= 0) {
            puntos = 0;
        } else {
            puntos -= unPuntaje;
        }
    }
}
