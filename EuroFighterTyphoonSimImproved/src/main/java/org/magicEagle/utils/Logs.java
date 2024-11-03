package org.magicEagle.utils;

import org.magicEagle.plane.Combustible;
import org.magicEagle.plane.Motor;
import org.magicEagle.plane.SistemaRefrigeracion;
import org.magicEagle.plane.SistemaSensores;
/**
 * @Author: CoderAnchel
 * The Logs class provides methods to log various parameters of the plane's systems.
 */
public class Logs {

    Motor motor;
    Combustible combustible;
    SistemaSensores sistemaSensores;
    SistemaRefrigeracion sistemaRefrigeracion;

    /**
     * Constructs a Logs object with the specified systems.
     *
     * @param motor the motor system
     * @param combustible the combustible system
     * @param sistemaSensores the sensor system
     * @param sistemaRefrigeracion the refrigeration system
     */
    public Logs(Motor motor, Combustible combustible, SistemaSensores sistemaSensores, SistemaRefrigeracion sistemaRefrigeracion) {
        this.motor = motor;
        this.combustible = combustible;
        this.sistemaSensores = sistemaSensores;
        this.sistemaRefrigeracion = sistemaRefrigeracion;
    }
    /**
     * Logs the current power level of the motor.
     */
    public void logMotor() {
        System.out.printf("Nivel Actual de Potencia: \u001B[35m %.3f \u001B[0m \n", motor.getnivelActualPotencia());
    }
    /**
     * Logs the current fuel level.
     */
    public void logsCombustible() {
        System.out.printf("Nivel Actual de Combustible: \u001B[31m %.3f  \u001B[0m \n", combustible.getNivelActual());
    }
    /**
     * Logs the total weight.
     */
    public void logsPeso() {
        System.out.printf("Peso Total: \u001B[36m %.3f \u001B[0m \n", sistemaSensores.obtenerPesoTotal());
    }
    /**
     * Logs the current speed.
     */
    public void logsVelocidad() {
        System.out.printf("Velocidad: \u001B[32m  %.3f \u001B[0m \n", sistemaSensores.ajustarVelocidad());
    }
    /**
     * Logs the current temperature.
     */
    public void logsTemperatura() {
        System.out.printf("Temperatura: \u001B[32m  %.2f \u001B[0m \n", sistemaRefrigeracion.getTemperatura());
    }
    /**
     * Logs the current refrigeration level.
     */
    public void logsRefrigeracion() {
        System.out.printf("Refrigeracion: \u001B[32m  %.3f \u001B[0m \n",sistemaRefrigeracion.getRefrigeracion());
    }
}
