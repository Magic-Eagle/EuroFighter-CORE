package org.magicEagle.utils;

import org.magicEagle.plane.Combustible;
import org.magicEagle.plane.Motor;
import org.magicEagle.plane.SistemaSensores;

public class Logs {

    Motor motor;
    Combustible combustible;
    SistemaSensores sistemaSensores;

    public Logs(Motor motor, Combustible combustible, SistemaSensores sistemaSensores) {
        this.motor = motor;
        this.combustible = combustible;
        this.sistemaSensores = sistemaSensores;
    }

    public void logMotor() {
//        System.out.printf("Potencia Maxima: %.3f\n", motor.getpotenciaMaxima());
//        System.out.println("Estado: " + motor.getEstado());
        System.out.printf("Nivel Actual de Potencia: \u001B[35m %.3f \u001B[0m \n", motor.getnivelActualPotencia());
    }

    public void logsCombustible() {
        System.out.printf("Nivel Actual de Combustible: \u001B[31m %.3f  \u001B[0m \n", combustible.getNivelActual());
    }

    public void logsPeso() {
        System.out.printf("Peso Total: \u001B[36m %.3f \u001B[0m \n", sistemaSensores.obtenerPesoTotal());
    }

    public void logsVelocidad() {
        System.out.printf("Velocidad: \u001B[32m  %.3f \u001B[0m \n", sistemaSensores.ajustarVelocidad());
    }
}
