package org.magicEagle.utils;

import org.magicEagle.plane.Motor;

public class Logs {

    Motor motor;

    public Logs(Motor motor) {
        this.motor = motor;
    }

    public void logMotor() {
        System.out.println("Nivel Actual de Potencia: " + motor.getnivelActualPotencia());
        System.out.println("Estado: " + motor.getEstado());
    }

}
