package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaOpciones {

    private final List<Opcion> listaOpciones;

    public ListaOpciones() {
        listaOpciones = new ArrayList<>();
    }

    public ListaOpciones(List<Opcion> unaLista) {
        listaOpciones = new ArrayList<>();
        listaOpciones.addAll(unaLista);
    }
    public ListaOpciones(ListaOpciones unaListaDeRespuestas) {
        listaOpciones = new ArrayList<>();
        listaOpciones.addAll(unaListaDeRespuestas.obtenerLista());
    }

    public void agregar(Opcion opcion) {
        listaOpciones.add(opcion);
    }

    public void agregarTodo(ListaOpciones otraListaOpciones) {
        listaOpciones.addAll(otraListaOpciones.obtenerLista());
    }

    public boolean contieneTodo(ListaOpciones otraLista) {
        return listaOpciones.containsAll(otraLista.obtenerLista());
    }

    public boolean contieneLoMismo(ListaOpciones otraLista) {

        //System.out.println(this.obtenerCoincidencias(otraLista));
        //System.out.println(otraLista.cantidadDeRespuestas());

        return (this.cantidadDeRespuestas() == otraLista.cantidadDeRespuestas() &&
                this.obtenerCoincidencias(otraLista) == otraLista.cantidadDeRespuestas());
        /*return listaOpciones.size() == otraLista.obtenerLista().size() &&
                listaOpciones.containsAll(otraLista.obtenerLista());*/
    }

    public Opcion obtener(int posicion) {
        return listaOpciones.get(posicion);
    }

    public List<Opcion> obtenerLista() {
        return listaOpciones;
    }

    public int obtenerCoincidencias(ListaOpciones otraLista) {
        return otraLista.calculoDeCoincidencias(listaOpciones);
    }

    public int calculoDeCoincidencias(List<Opcion> otraLista) {
        int coincidencias = 0;
        Iterator<Opcion> iterador1 = otraLista.iterator();
        Iterator<Opcion> iterador2 = listaOpciones.iterator();

        for (int i = 0; i < otraLista.size(); i++) {
            Opcion otraOpcion = iterador1.next();

            for (int j = 0; j < listaOpciones.size(); j++) {
                Opcion opcion = iterador2.next();
                if (opcion.getOpcion().equals(otraOpcion.getOpcion())) {
                    coincidencias++;
                }
            }
            iterador2 = listaOpciones.iterator();
        }
        return coincidencias;
    }


    public int cantidadDeRespuestas() {
        return listaOpciones.size();
    }

    public boolean esIgual(ListaOpciones otraLista){
        Iterator<Opcion> iterador1 = listaOpciones.iterator();
        Iterator<Opcion> iterador2 = otraLista.obtenerLista().iterator();

        if(this.cantidadDeRespuestas() != otraLista.cantidadDeRespuestas()){
            return false;
        }

        for (int i = 0; i < otraLista.cantidadDeRespuestas(); i++) {
            Opcion unaOpcion = iterador1.next();
            Opcion otraOpcion = iterador2.next();

            if(unaOpcion != otraOpcion){
                return false;
            }
        }
        return true;
    }

    public Puntaje calcularPuntaje() {
        Puntaje puntaje = new Puntaje();

        for (Opcion opcion : listaOpciones) {
            puntaje.sumarPuntos(opcion.getPuntaje());
        }
        return puntaje;
    }
}
