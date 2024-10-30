package org.magicEagle.plane;

public class Motor {

    //Variables
    float potenciaMaxima;
    float nivelActualPotencia;
    String Estado;
    float Temperatura;
    float conmsumoCombustible;

    //Constructor
    public Motor(float potenciaMaxima, float nivelActualPotencia, String Estado, float conmsumoCombustible) {
        this.potenciaMaxima = potenciaMaxima;
        this.nivelActualPotencia = nivelActualPotencia;
        this.Estado = Estado;
        this.Temperatura = Temperatura;
        this.conmsumoCombustible = conmsumoCombustible;
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
