package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.InterfazDeUsuario;

public class VerdaderoFalsoClasico extends VerdaderoFalso {

    private VerdaderoFalsoClasico(String unaConsigna, Opcion unaOpcionCorrecta, Opcion unaOpcionIncorrecta) {

        consigna = unaConsigna;
        opcionCorrecta = unaOpcionCorrecta;
        opcionIncorrecta = unaOpcionIncorrecta;
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectaVerdadero(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(0));
        return new VerdaderoFalsoClasico(unaConsigna, opcionVerdadera, opcionFalsa);
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(0));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(1));
        return new VerdaderoFalsoClasico(unaConsigna, opcionFalsa, opcionVerdadera);
    }

    @Override
    public Boolean aceptaMultiplicador() {return false;}

    @Override
    public Boolean aceptaExclusividad() {return true;}
    private void setRespuestaCorrectaVerdadero() {
        opcionCorrecta = new Opcion("Verdadero", new Puntaje(1));
        opcionIncorrecta = new Opcion("Falso", new Puntaje(0));
    }

    public void mostrarseEn(InterfazDeUsuario unaInterfazDeUsuario) {
        unaInterfazDeUsuario.vistaVerdaderoFalso();
    }
}
