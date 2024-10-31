package org.magicEagle.plane;

import org.magicEagle.utils.KeyHandler;

public class Motor {
    //utilidades
    KeyHandler keyHandler;
    double potenciaIntervalo = 05.0;

    //Variables
    double potenciaMaxima;
    double nivelActualPotencia;
    String Estado;
    float Temperatura;
    double conmsumoCombustible;

    //Constructor
    public Motor(double potenciaMaxima, double nivelActualPotencia, String Estado, double conmsumoCombustible, KeyHandler keyHandler) {
        this.potenciaMaxima = potenciaMaxima;
        this.nivelActualPotencia = nivelActualPotencia;
        this.Estado = Estado;
        this.Temperatura = Temperatura;
        this.conmsumoCombustible = conmsumoCombustible;
        this.keyHandler = keyHandler;
    }

    public void ajustarPotencia() {

        if (nivelActualPotencia <= potenciaMaxima) {

            if (keyHandler.upPressed) {
                nivelActualPotencia = (float) (nivelActualPotencia + potenciaIntervalo);
            }

            if (keyHandler.downPressed) {
                nivelActualPotencia = (float) (nivelActualPotencia - potenciaIntervalo);
            }
        }
    }
    //Getters y Setters

    //obtener maxima potencia
    public double getpotenciaMaxima() {
        return potenciaMaxima;
    }

    //obtener nivel actual de potencia
    public double getnivelActualPotencia() {
        return nivelActualPotencia;
    }

    //obtener estado
    public String getEstado() {
        return Estado;
    }

    //obtener temperatura
    public float getTemperatura() {
        return Temperatura;

    }
    public double getConmsumoCombustible() {
        return conmsumoCombustible;
    }

    public void ajustarConsumo() {
        this.conmsumoCombustible = (nivelActualPotencia / 300) / 325;
    }
}
