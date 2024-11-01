package org.magicEagle.Main;

public class Eurofighter {

    public String name;
    public String estadoTierra;
    public String estadoMotor;

    public final double PESO_DESCARGADO = 11500;
    public final double VELOCIDAD_MAXIMA = 2.495;

    public Eurofighter(String name, String estadoTierra) {
        this.name = name;
        this.estadoTierra = estadoTierra;
    }

}
