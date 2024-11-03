package org.magicEagle.plane;

import org.magicEagle.Main.Eurofighter;
import org.magicEagle.utils.SimLoop;
/**
 * @Author: CoderAnchel
 * SistemaSensores class represents the sensor system of the Eurofighter.
 */
public class SistemaSensores {
    Eurofighter eurofighter;
    Combustible combustible;
    Motor motor;

    double velocidad;
    double Altitud;
    double Presion;
    String Estado;
    double Temperatura;
    double pesoTotal;
    double resistenciaAereoDinamica;

    /**
     * Constructor for SistemaSensores.
     *
     * @Author: CoderAnchel
     *
     * @param Altitud Altitude of the Eurofighter.
     * @param Presion Pressure at the current altitude.
     * @param Estado Current state of the sensor system.
     * @param Temperatura Temperature at the current altitude.
     * @param eurofighter Instance of the Eurofighter.
     * @param combustible Instance of the Combustible.
     * @param resistenciaAereoDinamica Aerodynamic resistance.
     * @param motor Instance of the Motor.
     */
    public SistemaSensores(float Altitud, float Presion, String Estado, double Temperatura, Eurofighter eurofighter, Combustible combustible, double resistenciaAereoDinamica, Motor motor) {
        this.Altitud = Altitud;
        this.Presion = Presion;
        this.Estado = Estado;
        this.Temperatura = Temperatura;
        this.eurofighter = eurofighter;
        this.combustible = combustible;
        this.resistenciaAereoDinamica = resistenciaAereoDinamica;
        this.motor = motor;
    }

    public SistemaSensores(int altitud, int presion, String sensorDePesoEncendido, double temperatura, SimLoop simLoop, Combustible combustible, int resistenciaAereoDinamica, Motor motor) {
    }
    /**
     * Calculates and returns the total weight of the Eurofighter.
     * @Author: CoderAnchel
     * @return Total weight of the Eurofighter.
     */
    public double obtenerPesoTotal() {
        pesoTotal = eurofighter.PESO_DESCARGADO + combustible.getNivelActual();
        return pesoTotal;
    }
    /**
     * Adjusts and returns the speed of the Eurofighter.
     * @Author: CoderAnchel
     * @return Adjusted speed of the Eurofighter.
     */
    public double ajustarVelocidad() {
        double potencia = motor.nivelActualPotencia;
        double peso = obtenerPesoTotal();

        velocidad = Math.sqrt((2 * potencia) / (resistenciaAereoDinamica * peso));
        return velocidad;
    }
    /**
     * Returns the altitude of the Eurofighter.
     * @Author: CoderAnchel
     * @return Altitude of the Eurofighter.
     */
    public double getAltitud() {
        return Altitud;

    }
    /**
     * Returns the pressure at the current altitude.
     * @Author: CoderAnchel
     * @return Pressure at the current altitude.
     */
    public double getPresion() {
        return Presion;

    }
    /**
     * Returns the current state of the sensor system.
     * @Author: CoderAnchel
     * @return Current state of the sensor system.
     */
    public String getEstado() {
        return Estado;

    }


    /**
     * Returns the temperature at the current altitude.
     * @Author: CoderAnchel
     * @return Temperature at the current altitude.
     */
    public double getTemperatura() {
        return Temperatura;

    }
}
