package org.magicEagle.plane;

/**
 * @Author: CoderAnchel
 * SistemaRefrigeracion is responsible for managing the cooling system of the plane.
 */
public class SistemaRefrigeracion {
    Motor motor;
    SistemaSensores sensores;

    double refrigeracion;
    double refriAuxiliar = 100;

    /**
     * Constructor for SistemaRefrigeracion.
     *
     * @param motor the motor of the plane
     * @param sensores the sensor system of the plane
     */
    public SistemaRefrigeracion(Motor motor, SistemaSensores sensores) {
        this.motor = motor;
        this.sensores = sensores;
    }
    /**
     * @Author: CoderAnchel
     * Calculates the cooling based on the speed of the plane.
     */
    public void calculaRefrigeracion() {
        if (sensores.velocidad > 0) {
            refrigeracion = sensores.velocidad / 2;
        }
    }
    /**
     * @Author: CoderAnchel
     * Performs the cooling process based on the motor's temperature.
     * Uses auxiliary cooling if the main cooling is insufficient.
     */
    public void refrigerar() {
        if (motor.temperatura > 400) {
           double exceso = motor.temperatura - 400;
           if (refrigeracion > 0) {
               refrigeracion = refrigeracion - exceso;
               motor.temperatura = motor.temperatura - exceso;
           } else {
                refriAuxiliar = refriAuxiliar - exceso;
                motor.temperatura = motor.temperatura - exceso;
                refriAuxiliar = refriAuxiliar + exceso;
            }
        }
    }
    /**
     * Gets the current temperature of the motor.
     *
     * @Author: CoderAnchel
     * @return the temperature of the motor
     */
    public double getTemperatura() {
        return motor.temperatura;
    }
    /**
     * Gets the current cooling value.
     *
     * @Author: CoderAnchel
     * @return the cooling value
     */
    public double getRefrigeracion() {
        return refrigeracion;
    }
}
