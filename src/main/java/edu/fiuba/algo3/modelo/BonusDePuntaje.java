package edu.fiuba.algo3.modelo;

public class BonusDePuntaje {
    public void aplicarbonus(Jugador jugador1, int puntosJ1, Multiplicador multiplicadorJ1, Exclusividad exclusividadJ1, Jugador jugador2, int puntosJ2, Multiplicador multiplicadorJ2, Exclusividad exclusividadJ2){
        multiplicadorJ1.aplicarMultiplicador(jugador1, puntosJ1);
        multiplicadorJ2.aplicarMultiplicador(jugador2, puntosJ2);
        exclusividadJ1.aplicarExclusividad(jugador1, puntosJ1, jugador2, puntosJ2);
        exclusividadJ2.aplicarExclusividad(jugador1, puntosJ1, jugador2, puntosJ2);
    }
}
