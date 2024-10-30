package org.magicEagle.plane;

public class SistemaSensores {
    //variables
    float velocidad;
    float Altitud;
    float Presion;
    String Estado;
    float Temperatura;

    //Constructor
    public SistemaSensores(float velocidad, float Altitud, float Presion, String Estado, float Temperatura) {
        this.velocidad = velocidad;
        this.Altitud = Altitud;
        this.Presion = Presion;
        this.Estado = Estado;
        this.Temperatura = Temperatura;
    }

    //Getters and Setters

    public float getVelocidad(){
        return velocidad;

    }
    public float getAltitud() {
        return  Altitud;

    }
    public float getPresion() {
        return Presion;

    }
    public String getEstado() {
        return Estado;

    }
    public float getTemperatura() {
        return Temperatura;

    }
}
