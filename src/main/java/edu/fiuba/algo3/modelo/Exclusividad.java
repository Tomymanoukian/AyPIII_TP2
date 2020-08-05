package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador;

public class Exclusividad {

    public void aplicarExclusividad(Puntaje puntajeJ1, Puntaje puntajeJ2){
        if(puntajeJ1.getPuntos() == 0 || puntajeJ2.getPuntos() ==0){
            puntajeJ1.multiplicarPuntos(2);
            puntajeJ2.multiplicarPuntos(2);
        }
        else{
            puntajeJ1.establecerPuntos(0);
            puntajeJ2.establecerPuntos(0);
        }
    }
}
