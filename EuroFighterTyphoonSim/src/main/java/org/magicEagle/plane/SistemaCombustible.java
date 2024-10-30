package org.magicEagle.plane;

public class SistemaCombustible {
    //Variables
   float CapacidadMaxima;
   float nivelActual;
   String tipoCombustible;
   float consumoPorSegundo;

   //Constructor

    public SistemaCombustible(float CapacidadMaxima,float NivelActual,String TipoCombustible, float consumoPorSegundo) {
        this.CapacidadMaxima = CapacidadMaxima;
        this.nivelActual = NivelActual;
        this.tipoCombustible = TipoCombustible;
        this.consumoPorSegundo = consumoPorSegundo;

    }

    //Getters y Setters
    public float getCapacidadMaxima(){
        return CapacidadMaxima;
    }
    public float getNivelActual() {
        return nivelActual;
    }
    public String getTipoCombustible() {
        return tipoCombustible;
    }
    public float getConsumoPorSegundo() {
        return consumoPorSegundo;
    }
}
