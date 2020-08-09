package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoConPenalidad extends VerdaderoFalso {

    private VerdaderoFalsoConPenalidad(String unaConsigna, Opcion unaOpcionCorrecta, Opcion unaOpcionIncorrecta) {

        consigna = unaConsigna;
        opcionCorrecta = unaOpcionCorrecta;
        opcionIncorrecta = unaOpcionIncorrecta;
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoVerdadero(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(-1));
        return new VerdaderoFalsoConPenalidad(unaConsigna, opcionVerdadera, opcionFalsa);
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(-1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(1));
        return new VerdaderoFalsoConPenalidad(unaConsigna, opcionFalsa, opcionVerdadera);
    }

    @Override
    public Boolean aceptaMultiplicador() {return true;}

    @Override
    public Boolean aceptaExclusividad() {return false;}
}
