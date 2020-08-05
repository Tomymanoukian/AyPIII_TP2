package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int puntos;

    public Puntaje(){
        puntos = 0;
    }
    public Puntaje(int cantPuntos){
        puntos = cantPuntos;
    }

    public int getPuntos(){
        return puntos;
    }

    public void establecerPuntos(int cantPuntos){puntos = cantPuntos;}

    public void sumarPuntos(int cantPuntos){
        puntos += cantPuntos;
    }

    public void sumarPuntos(Puntaje unPuntaje){
        puntos += unPuntaje.getPuntos();
    }

    public void multiplicarPuntos(int factorDeMultiplicacion){
        puntos *= factorDeMultiplicacion;
    }
}
