package org.magicEagle.Main;

import org.magicEagle.states.EstadoEurofighter;

public class Eurofighter {

    public String name ;
    public String estadoTierra;
    public String estadoMotor;

    final double PESO = 11.000;
    final double VELOCIDAD_MAXIMA  = 2.495;

    public Eurofighter(String name, String estadoTierra) {
        this.name = name;
        this.estadoTierra = estadoTierra;
    }


}
