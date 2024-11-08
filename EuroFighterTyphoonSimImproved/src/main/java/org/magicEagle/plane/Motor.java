package org.magicEagle.plane;

import org.magicEagle.utils.KeyHandler;
/**
 * @Author: CoderAnchel
 * Represents the motor of a plane with various attributes and methods to control its power, temperature, and fuel consumption.
 */
public class Motor {
    KeyHandler keyHandler;
    SistemaElectrico sistemaElectrico;

    double potenciaIntervalo = 90;
    double potenciaMaxima;
    double nivelActualPotencia;
    String Estado;
    double temperatura;
    double conmsumoCombustible;

    public boolean startEngine = false;
    public boolean startGenerator = false;
    public boolean genMode = false;
    /**
     * Constructor to initialize the Motor object.
     *
     * @param potenciaMaxima       the maximum power of the motor
     * @param nivelActualPotencia  the current power level of the motor
     * @param Estado               the state of the motor
     * @param conmsumoCombustible  the fuel consumption of the motor
     * @param keyHandler           the key handler for controlling the motor
     */
    public Motor(double potenciaMaxima, double nivelActualPotencia, String Estado, double conmsumoCombustible, KeyHandler keyHandler, SistemaElectrico sistemaElectrico) {
        this.potenciaMaxima = potenciaMaxima;
        this.nivelActualPotencia = nivelActualPotencia;
        this.Estado = Estado;
        this.conmsumoCombustible = conmsumoCombustible;
        this.keyHandler = keyHandler;
        this.sistemaElectrico = sistemaElectrico;
    }
    /**
     * @Author: CoderAnchel
     * Resets the current power level of the motor to zero.
     */
    public void reset() {
        this.nivelActualPotencia = 0;
    }
    /**
     * @Author: CoderAnchel
     * Adjusts the power level of the motor based on key inputs.
     */
    public void ajustarPotencia() {

        if (genMode) {
            nivelActualPotencia = 100;
        }

        if (nivelActualPotencia <= potenciaMaxima && startEngine) {

            if (keyHandler.upPressed) {
                nivelActualPotencia =nivelActualPotencia + potenciaIntervalo;
            }
        }

        if (nivelActualPotencia >= 0 && startEngine) {
            if(keyHandler.downPressed) {
                nivelActualPotencia = nivelActualPotencia - potenciaIntervalo;
            }
        }

        if (!this.startEngine) {
            nivelActualPotencia = 0;
        }
    }
    /**
     * Gets the maximum power of the motor.
     *
     * @Author: CoderAnchel
     * @return the maximum power of the motor
     */
    public double getpotenciaMaxima() {
        return potenciaMaxima;
    }
    /**
     * Gets the current power level of the motor.
     *
     * @Author: CoderAnchel
     * @return the current power level of the motor
     */
    public double getnivelActualPotencia() {
        return nivelActualPotencia;
    }

    /**
     * Gets the state of the motor.
     *
     * @Author: CoderAnchel
     * @return the state of the motor
     */
    public String getEstado() {
        return Estado;
    }
    /**
     * @Author: CoderAnchel
     * Adjusts the temperature of the motor based on the current power level.
     */
    public void ajustarTemperatura() {
        if(nivelActualPotencia > 0) {
            temperatura = nivelActualPotencia / 200;
        }

        if (nivelActualPotencia == 0) {
            temperatura = 0;
        }
    }

    /**
     * Gets the temperature of the motor.
     *
     * @Author: CoderAnchel
     * @return the temperature of the motor
     */
    public double  getTemperatura() {
        return temperatura;

    }
    /**
     * Gets the fuel consumption of the motor.
     *
     * @Author: CoderAnchel
     * @return the fuel consumption of the motor
     */
    public double getConmsumoCombustible() {
        return conmsumoCombustible;
    }
    /**
     * @Author: CoderAnchel
     * Adjusts the fuel consumption of the motor based on the current power level.
     */
    public void ajustarConsumo() {
        this.conmsumoCombustible = (nivelActualPotencia / 300) / 7225;
    }

    public void StartEngine() {
            startEngine = !startEngine;

            if (!startEngine) {
                nivelActualPotencia = 0;
                startGenerator = false;
                genMode = false;
            }
    }

    public void StartGenerator() {
        if (startEngine && this.nivelActualPotencia > 99) {
            startGenerator = !startGenerator;
        }
    }

    public void GenMode() {
        //ajustar modo de generacion inicial para sistemas
        if (startEngine) {
            genMode = !genMode;
        }
    }

}
