package org.magicEagle.plane;

import org.magicEagle.utils.KeyHandler;

public class Motor {
    //utilidades
    KeyHandler keyHandler;
    double potenciaIntervalo = 0.0001;

    //Variables
    float potenciaMaxima;
    float nivelActualPotencia;
    String Estado;
    float Temperatura;
    float conmsumoCombustible;

    //Constructor
    public Motor(float potenciaMaxima, float nivelActualPotencia, String Estado, float conmsumoCombustible, KeyHandler keyHandler) {
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
    public float getpotenciaMaxima() {
        return potenciaMaxima;
    }

    //obtener nivel actual de potencia
    public float getnivelActualPotencia() {
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
    public float getConmsumoCombustible() {
        return conmsumoCombustible;
    }
}
