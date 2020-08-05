package edu.fiuba.algo3.modelo;

public class BonusDePuntaje {
    public static void aplicarbonus(Puntaje puntajeJ1, ListaDeMultiplicadores multiplicadoresJ1, ListaDeExclusividades exclusividadJ1, Puntaje puntajeJ2, ListaDeMultiplicadores multiplicadoresJ2, ListaDeExclusividades exclusividadJ2){
        multiplicadoresJ1.aplicarMultiplicadores(puntajeJ1);
        multiplicadoresJ2.aplicarMultiplicadores(puntajeJ2);
        exclusividadJ1.aplicarExclusividades(puntajeJ1, puntajeJ2);
        exclusividadJ2.aplicarExclusividades(puntajeJ1, puntajeJ2);
    }
}
