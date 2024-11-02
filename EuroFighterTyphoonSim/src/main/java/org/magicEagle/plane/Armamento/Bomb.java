package org.magicEagle.plane.Armamento;

public class Bomb extends Armamento {
    String model;
    String guidance;
    int maxSpeed;
    int guidanceTime;
    int launchRange;
    int explosiveMass;
    int armourPenetration;

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
