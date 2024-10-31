package org.magicEagle.plane;

public class Combustible {
    //Variables
   double CapacidadMaxima;
   double nivelActual;
   String tipoCombustible;
   double consumoPorSegundo;

   //Constructor

    public Combustible(double CapacidadMaxima, double NivelActual, String TipoCombustible, double consumoPorSegundo) {
        this.CapacidadMaxima = CapacidadMaxima;
        this.nivelActual = NivelActual;
        this.tipoCombustible = TipoCombustible;
        this.consumoPorSegundo = consumoPorSegundo;
    }

    //Getters y Setters
    public double getCapacidadMaxima(){
        return CapacidadMaxima;
    }
    public double getNivelActual() {
        return nivelActual;
    }
    public String getTipoCombustible() {
        return tipoCombustible;
    }
    public double getConsumoPorSegundo() {
        return consumoPorSegundo;
    }

    public void consumirCombustible(double consumoPorSegundo) {
        if (nivelActual > 0) {
            nivelActual = nivelActual - consumoPorSegundo;
        }
    }
}
