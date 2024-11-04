package org.magicEagle.plane.Armamento;

import org.magicEagle.utils.KeyHandler;

/**
 * @Author: CoderAnchel
 * Represents a Bomb which is a type of Armamento.
 */
public class Bomb extends Armamento {

    KeyHandler keyHandler;

    String model;
    String guidance;
    int maxSpeed;
    int guidanceTime;
    int launchRange;
    int explosiveMass;
    int armourPenetration;

    //variables de lanzamiento
    double velocidad;
    double distancia;
    private long launchTime = 0;
    public boolean launched = false;
    /**
     * Constructs a new Bomb with the specified parameters.
     *
     * @param model the model of the bomb
     * @param armamentType the type of armament
     * @param mass the mass of the bomb
     * @param guidance the guidance system of the bomb
     * @param maxSpeed the maximum speed of the bomb
     * @param guidanceTime the guidance time of the bomb
     * @param launchRange the launch range of the bomb
     * @param explosiveMass the explosive mass of the bomb
     * @param armourPenetration the armour penetration capability of the bomb
     */
    public Bomb(String model,String armamentType, int mass, String guidance, int maxSpeed, int guidanceTime, int launchRange, int explosiveMass, int armourPenetration, Boolean estado, KeyHandler keyHandler) {
        this.model = model;
        super.armamentType = armamentType;
        super.mass = mass;
        this.guidance = guidance;
        this.maxSpeed = maxSpeed;
        this.guidanceTime = guidanceTime;
        this.launchRange = launchRange;
        this.explosiveMass = explosiveMass;
        this.armourPenetration = armourPenetration;
        super.estado = estado;
        this.keyHandler = keyHandler;
    }
    /**
     * @Author: CoderAnchel
     * Updates the state of the missile to "Impacto".
     */
    public void actualizarEstado(){
        if (!launched) {
            this.estado = true;
            launchTime = System.currentTimeMillis();
            launched = true;
        }
    }

    public boolean shouldDisplayExplosion() {
        long currentTime = System.currentTimeMillis();

        // Devuelve true si la diferencia entre el tiempo actual y el tiempo de lanzamiento es menor a 10 segundos
        if (estado && (currentTime - launchTime < 10000)) {
            return true;  // Mostrar el mensaje
        }

        return false;  // No mostrar el mensaje
    }
    /**
     * @Author: CoderAnchel
     * Checks if the launch key is pressed and updates the state to "Lanzado".
     */
    /**
     * Returns the current state of the missile.
     *
     * @Author: CoderAnchel
     * @return the current state of the missile
     */
    public Boolean getEstado(){
        return this.estado;
    }
    /**
     * Returns the current speed of the missile.
     *
     * @Author: CoderAnchel
     * @return the current speed of the missile
     */
    public double getVelocidad(){
        return this.velocidad;
    }
    /**
     * Returns the current distance traveled by the missile.
     *
     * @Author: CoderAnchel
     * @return the current distance traveled by the missile
     */
    public double getDistancia(){
        return this.distancia;
    }
}
