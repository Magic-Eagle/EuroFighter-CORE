package org.magicEagle.plane;

public class SistemaRefrigeracion {
    double refrigeracion;
    double refriAuxiliar = 100;

    Motor motor;
    SistemaSensores sensores;

    public SistemaRefrigeracion(Motor motor, SistemaSensores sensores) {
        this.motor = motor;
        this.sensores = sensores;
    }

    public void calculaRefrigeracion() {
        if (sensores.velocidad > 0) {
            refrigeracion = sensores.velocidad / 2;
        }
    }

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

    public double getTemperatura() {
        return motor.temperatura;
    }



    public double getRefrigeracion() {
        return refrigeracion;
    }
}
