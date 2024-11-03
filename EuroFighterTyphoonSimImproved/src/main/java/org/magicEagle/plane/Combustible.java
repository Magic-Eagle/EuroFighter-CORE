package org.magicEagle.plane;
/**
 * @Author: CoderAnchel
 * Represents the fuel system of a plane.
 */
public class Combustible {
    double CapacidadMaxima;
    double nivelActual;
    String tipoCombustible;
    double consumoPorSegundo;

    /**
     * Constructs a new Combustible instance.
     *
     * @param CapacidadMaxima   the maximum capacity of the fuel tank
     * @param NivelActual       the current fuel level
     * @param TipoCombustible   the type of fuel
     * @param consumoPorSegundo the fuel consumption per second
     */
    public Combustible(double CapacidadMaxima, double NivelActual, String TipoCombustible, double consumoPorSegundo) {
        this.CapacidadMaxima = CapacidadMaxima;
        this.nivelActual = NivelActual;
        this.tipoCombustible = TipoCombustible;
        this.consumoPorSegundo = consumoPorSegundo;
    }

    /**
     * Gets the maximum capacity of the fuel tank.
     *
     * @return the maximum capacity of the fuel tank
     */
    public double getCapacidadMaxima() {
        return CapacidadMaxima;
    }
    /**
     * Gets the current fuel level.
     *
     * @return the current fuel level
     */
    public double getNivelActual() {
        return nivelActual;
    }
    /**
     * Gets the type of fuel.
     *
     * @return the type of fuel
     */
    public String getTipoCombustible() {
        return tipoCombustible;
    }
    /**
     * Gets the fuel consumption per second.
     *
     * @return the fuel consumption per second
     */
    public double getConsumoPorSegundo() {
        return consumoPorSegundo;
    }
    /**
     * Consumes fuel based on the consumption rate per second.
     *
     * @param consumoPorSegundo the amount of fuel to consume per second
     */
    public void consumirCombustible(double consumoPorSegundo) {
        if (nivelActual > 0) {
            nivelActual = nivelActual - consumoPorSegundo;
        }
    }
}
