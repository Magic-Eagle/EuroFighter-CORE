package org.magicEagle.Main;

import org.magicEagle.plane.Radar;
import org.magicEagle.plane.Combustible;
import org.magicEagle.plane.Motor;
import org.magicEagle.plane.SistemaSensores;
import org.magicEagle.states.EstadoEurofighter;
import org.magicEagle.utils.SimLoop;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        EstadoEurofighter estadoEurofighter = new EstadoEurofighter();;
//
//        SistemaSensores sistemasensores = new SistemaSensores(0.0F,0.0F,0.0F,"Activo",0.0F);
//
//        Combustible sistemacombustible = new Combustible(0.0F,0.0F,"Gasolina",0.0F);
//
//        Motor sistemamotor = new Motor(0.0F,0.0F,"Encendido",0.0F);
//
//        Eurofighter eurofighter = new Eurofighter("Plane2",estadoEurofighter.getEstadosTierra()[0]);
//
//        Radar radar = new Radar(4,true);
//
//        radar.addObjetivo(eurofighter);
//
//        System.out.println(radar.getObjetivo(0).name);
//
            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLocationRelativeTo(null);

            window.setResizable(false);
            window.setTitle("Magic Eagle - Eurofighter Typhoon 1.0");
            window.setVisible(true);

            SimLoop simLoop = new SimLoop();
            window.add(simLoop);
            window.pack();
            Thread simThread = new Thread(simLoop);
            simThread.start();

            simLoop.requestFocus();
    }
}