package org.magicEagle.plane.Armamento;

public class Misile extends Armamento {
    String model;
    String guidance;
    String aspect;
    int lookRange;
    int range;
    int maxSpeed;
    int overloadG;
    int guidanceTime;
    int ExplosiveMass;

    public Misile(String model,String armamentType, int mass, String guidance, String aspect, int lookRange, int range, int maxSpeed, int overloadG, int guidanceTime, int ExplosiveMass) {
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
    }
}
