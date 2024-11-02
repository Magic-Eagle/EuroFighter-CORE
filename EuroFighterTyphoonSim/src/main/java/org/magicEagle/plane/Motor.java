package org.magicEagle.plane;

import org.magicEagle.utils.KeyHandler;

public class Motor {
    // utilidades
    KeyHandler keyHandler;
    double potenciaIntervalo = 90;

    // Variables
    double potenciaMaxima;
    double nivelActualPotencia;
    String Estado;
    double temperatura;
    double conmsumoCombustible;

    // Constructor
    public Motor(double potenciaMaxima, double nivelActualPotencia, String Estado, double conmsumoCombustible,
            KeyHandler keyHandler) {
        this.potenciaMaxima = potenciaMaxima;
        this.nivelActualPotencia = nivelActualPotencia;
        this.Estado = Estado;
        this.conmsumoCombustible = conmsumoCombustible;
        this.keyHandler = keyHandler;
    }

    public void ajustarPotencia() {

        if (nivelActualPotencia <= potenciaMaxima) {

            if (keyHandler.upPressed) {
                nivelActualPotencia =nivelActualPotencia + potenciaIntervalo;
            }
        }

        if (nivelActualPotencia >= 0) {
            if(keyHandler.downPressed) {
                nivelActualPotencia = nivelActualPotencia - potenciaIntervalo;
            }
        }
    }

    public double getpotenciaMaxima() {
        return potenciaMaxima;
    }

    public double getnivelActualPotencia() {
        return nivelActualPotencia;
    }


    public String getEstado() {
        return Estado;
    }

    public void ajustarTemperatura() {
        if(nivelActualPotencia > 0) {
            temperatura = nivelActualPotencia / 200;
        }
    }


    public double  getTemperatura() {
        return temperatura;

    }

    public double getConmsumoCombustible() {
        return conmsumoCombustible;
    }

    public void ajustarConsumo() {
        this.conmsumoCombustible = (nivelActualPotencia / 300) / 7225;
    }
}
