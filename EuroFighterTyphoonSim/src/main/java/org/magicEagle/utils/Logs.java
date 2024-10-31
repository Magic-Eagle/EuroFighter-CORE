package org.magicEagle.utils;

import org.magicEagle.plane.Combustible;
import org.magicEagle.plane.Motor;

public class Logs {

    Motor motor;
    Combustible combustible;

    public Logs(Motor motor, Combustible combustible) {
        this.motor = motor;
        this.combustible = combustible;
    }

    public void logMotor() {
        System.out.println("Nivel Actual de Potencia: " + motor.getnivelActualPotencia());
        System.out.println("Estado: " + motor.getEstado());
        System.out.println("Consumo por Segundo: " + motor.getConmsumoCombustible());
    }

    public void logsCombustible() {
        System.out.println("Nivel Actual de Combustible: " + combustible.getNivelActual());
    }
}
