package org.magicEagle.plane.Armamento;
/**
 * @Author: CoderAnchel
 * Abstract class representing an armament.
 */
public abstract class Armamento {
    String armamentType;
    int mass;
    public Boolean estado;

    /**
     * Gets the type of the armament.
     *
     * @return the type of the armament
     */
    public String getArmamentType() {
        return armamentType;
    }

    /**
     * Gets the mass of the armament.
     *
     * @return the mass of the armament
     */
    public int getMass() {
        return mass;
    }

    /**
     * Updates the state of the armament to true.
     */
    public void actualizarEstado(){
        this.estado = true;
    }
}
