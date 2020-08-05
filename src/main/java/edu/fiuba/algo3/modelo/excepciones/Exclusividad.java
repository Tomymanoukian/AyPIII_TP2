package edu.fiuba.algo3.modelo.excepciones;

import edu.fiuba.algo3.modelo.Jugador;

public class Exclusividad {

    public void aplicarExclusividad(Jugador jugador1, int puntosJ1, Jugador jugador2, int puntosJ2){
        if(puntosJ1 == 0 || puntosJ2 ==0){
            jugador1.modificarPuntos(puntosJ1 * 2);
            jugador2.modificarPuntos(puntosJ2 * 2);
        }
    }
}
