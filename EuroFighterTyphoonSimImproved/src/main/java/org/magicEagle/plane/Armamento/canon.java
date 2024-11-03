package org.magicEagle.plane.Armamento;
/**
 * @Author: CoderAnchel
 * The `canon` class represents a type of armament with specific attributes such as model, caliber,
 * bullet capacity, bullets per second, and explosive damage.
 */
public class canon extends Armamento {
    String model;
    int caliber;
    int bulletCapacity;
    int bulletPerSecond;
    int explosiveDamage;

    /**
     * Constructs a new `canon` instance with the specified attributes.
     *
     * @param model the model of the canon
     * @param caliber the caliber of the canon
     * @param bulletCapacity the bullet capacity of the canon
     * @param bulletPerSecond the number of bullets the canon can fire per second
     * @param explosiveDamage the explosive damage caused by the canon
     */
    public canon(String model, int caliber, int bulletCapacity, int bulletPerSecond, int explosiveDamage) {
        this.model = model;
        this.caliber = caliber;
        this.bulletCapacity = bulletCapacity;
        this.bulletPerSecond = bulletPerSecond;
        this.explosiveDamage = explosiveDamage;
    }
}
