package org.magicEagle.Main;

import org.magicEagle.plane.Radar;
import org.magicEagle.plane.SistemaCombustible;
import org.magicEagle.plane.Motor;
import org.magicEagle.plane.SistemaSensores;
import org.magicEagle.states.EstadoEurofighter;

public class Main {
    public static void main(String[] args) {
        EstadoEurofighter estadoEurofighter = new EstadoEurofighter();;

        SistemaSensores sistemasensores = new SistemaSensores(0.0F,0.0F,0.0F,"Activo",0.0F);

        SistemaCombustible sistemacombustible = new SistemaCombustible(0.0F,0.0F,"Gasolina",0.0F);

        Motor sistemamotor = new Motor(0.0F,0.0F,"Encendido",0.0F);

        Eurofighter eurofighter = new Eurofighter("Plane2",estadoEurofighter.getEstadosTierra()[0]);

        Radar radar = new Radar(4,true);

        radar.addObjetivo(eurofighter);

        System.out.println(radar.getObjetivo(0).name);
    }
}