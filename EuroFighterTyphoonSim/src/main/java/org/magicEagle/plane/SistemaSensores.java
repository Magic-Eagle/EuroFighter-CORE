package org.magicEagle.plane;

import org.magicEagle.Main.Eurofighter;

public class SistemaSensores {
    Eurofighter eurofighter;
    Combustible combustible;
    Motor motor;

    // variables
    double velocidad;
    double Altitud;
    double Presion;
    String Estado;
    double Temperatura;
    double pesoTotal;
    double resistenciaAereoDinamica;

    // Constructor
    public SistemaSensores(float Altitud, float Presion, String Estado, double Temperatura, Eurofighter eurofighter,
            Combustible combustible, double resistenciaAereoDinamica, Motor motor) {
        this.Altitud = Altitud;
        this.Presion = Presion;
        this.Estado = Estado;
        this.Temperatura = Temperatura;
        this.eurofighter = eurofighter;
        this.combustible = combustible;
        this.resistenciaAereoDinamica = resistenciaAereoDinamica;
        this.motor = motor;
    }

    public double obtenerPesoTotal() {
        pesoTotal = eurofighter.PESO_DESCARGADO + combustible.getNivelActual();
        return pesoTotal;
    }

    public double ajustarVelocidad() {
        double potencia = motor.nivelActualPotencia;
        double peso = obtenerPesoTotal();

        velocidad = Math.sqrt((2 * potencia) / (resistenciaAereoDinamica * peso));
        return velocidad;
    }

    public double getAltitud() {
        return Altitud;

    }

    public double getPresion() {
        return Presion;

    }

    public String getEstado() {
        return Estado;

    }

    public double getTemperatura() {
        return Temperatura;

    }
}
