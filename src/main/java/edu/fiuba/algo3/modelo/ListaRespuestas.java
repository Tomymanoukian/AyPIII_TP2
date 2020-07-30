package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaRespuestas {

    private List<Respuesta>  listaRespuestas = new ArrayList<>();

    public void limpiar(){
        listaRespuestas.clear();
    }

    public void agregar(Respuesta respuesta){
        listaRespuestas.add(respuesta);
    }

    public void agregarTodo(ListaRespuestas otraListaRespuestas){
        listaRespuestas.addAll(otraListaRespuestas.obtenerLista());
    }

    public boolean contieneTodo(ListaRespuestas otraLista){
        return  listaRespuestas.containsAll(otraLista.obtenerLista());
    }

    public Respuesta obtener(int posicion){
        return listaRespuestas.get(posicion);
    }

    public List<Respuesta> obtenerLista(){
        return listaRespuestas;
    }

    public int obtenerCoincidencias(ListaRespuestas otraLista){
        return otraLista.calculoDeCoincidencias(listaRespuestas);
    }

    public int calculoDeCoincidencias(List<Respuesta> otraLista){
        int coincidencias = 0;
        Iterator<Respuesta> iterador1 = otraLista.iterator();
        Iterator<Respuesta> iterador2 = listaRespuestas.iterator();

        for(int i = 0; i < otraLista.size(); i++){
            Respuesta otraRespuesta = iterador1.next();

            for(int j = 0; j < listaRespuestas.size(); j++) {
                Respuesta respuesta = iterador2.next();
                if(respuesta.getRespuesta() == otraRespuesta.getRespuesta()){
                    coincidencias ++;
                }
            }
            iterador2 = listaRespuestas.iterator();
        }
        return coincidencias;
    }
}
