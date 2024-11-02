package org.magicEagle.plane.Armamento;

public class canon extends Armamento {
    String model;
    int caliber;
    int bulletCapacity;
    int bulletPerSecond;
    int explosiveDamage;

    public canon(String model, int caliber, int bulletCapacity, int bulletPerSecond, int explosiveDamage) {
        this.model = model;
        this.caliber = caliber;
        this.bulletCapacity = bulletCapacity;
        this.bulletPerSecond = bulletPerSecond;
        this.explosiveDamage = explosiveDamage;
    }
}
