package org.magicEagle.states;

public class EstadoEurofighter {

    private final String[] ESTADOS_TIERRA = {
            "Mantenimiento",
            "Checking",
            "Cargando Armas",
            "Pruebas de sistema",
            "Estacionado",
            "En espera"
    };

    public String[] getEstadosTierra() {
        return ESTADOS_TIERRA;
    }
}
