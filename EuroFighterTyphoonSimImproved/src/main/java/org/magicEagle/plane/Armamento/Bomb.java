package org.magicEagle.plane.Armamento;
/**
 * @Author: CoderAnchel
 * Represents a Bomb which is a type of Armamento.
 */
public class Bomb extends Armamento {
    String model;
    String guidance;
    int maxSpeed;
    int guidanceTime;
    int launchRange;
    int explosiveMass;
    int armourPenetration;
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
    public Bomb(String model,String armamentType, int mass, String guidance, int maxSpeed, int guidanceTime, int launchRange, int explosiveMass, int armourPenetration) {
        this.model = model;
        super.armamentType = armamentType;
        super.mass = mass;
        this.guidance = guidance;
        this.maxSpeed = maxSpeed;
        this.guidanceTime = guidanceTime;
        this.launchRange = launchRange;
        this.explosiveMass = explosiveMass;
        this.armourPenetration = armourPenetration;
    }
}
