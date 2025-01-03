package org.magicEagle.plane.Armamento;

import org.magicEagle.utils.KeyHandler;
/**
 * @Author: CoderAnchel
 * The Misile class represents a missile with various properties and behaviors.
 * It extends the Armamento class and uses a KeyHandler for input handling.
 */
public class Misile extends Armamento {

    KeyHandler keyHandler;

    String model;
    String guidance;
    String aspect;
    int lookRange;
    int range;
    int maxSpeed;
    int overloadG;
    int guidanceTime;
    int ExplosiveMass;


    //variables de lanzamiento
    double velocidad;
    double distancia;
    private long launchTime = 0;
    public boolean launched = false;

    /**
     * Constructs a new Misile instance with the specified parameters.
     *
     * @param model the model of the missile
     * @param armamentType the type of armament
     * @param mass the mass of the missile
     * @param guidance the guidance system of the missile
     * @param aspect the aspect of the missile
     * @param lookRange the look range of the missile
     * @param range the range of the missile
     * @param maxSpeed the maximum speed of the missile
     * @param overloadG the overload G of the missile
     * @param guidanceTime the guidance time of the missile
     * @param ExplosiveMass the explosive mass of the missile
     * @param keyHandler the KeyHandler instance for input handling
     */
    public Misile(String model,String armamentType, int mass, String guidance, String aspect, int lookRange, int range, int maxSpeed, int overloadG, int guidanceTime, int ExplosiveMass, KeyHandler keyHandler, Boolean estado) {
        this.model = model;
        super.armamentType = armamentType;
        super.mass = mass;
        this.guidance = guidance;
        this.aspect = aspect;
        this.lookRange = lookRange;
        this.range = range;
        this.maxSpeed = maxSpeed;
        this.overloadG = overloadG;
        this.guidanceTime = guidanceTime;
        this.ExplosiveMass = ExplosiveMass;
        this.keyHandler = keyHandler;
        super.estado = estado;
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
