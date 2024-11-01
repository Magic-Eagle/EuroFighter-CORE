package org.magicEagle.plane;

public class SistemaRefrigeracion {
    double varemoRefrigeracion;
    double refriAuxiliar = 1000;

    Motor motor;
    SistemaSensores sensores;

    public SistemaRefrigeracion(Motor motor, SistemaSensores sensores) {
        this.motor = motor;
    }

    public void calcularVaremoRefrigeracion(double temperatura) {

    }
}
