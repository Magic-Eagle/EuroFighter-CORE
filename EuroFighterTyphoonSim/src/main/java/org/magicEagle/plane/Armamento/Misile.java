package org.magicEagle.plane.Armamento;

import org.magicEagle.utils.KeyHandler;

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
    String estado;

    public Misile(String model,String armamentType, int mass, String guidance, String aspect, int lookRange, int range, int maxSpeed, int overloadG, int guidanceTime, int ExplosiveMass, KeyHandler keyHandler) {
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
    }

    public void actualizarEstado(){
        this.estado = "Impacto";
    }

    public void checkLaunch(){
        if(keyHandler.launchPressed){
            this.estado = "Lanzado";
        }

    }

    public String getEstado(){
        return this.estado;
    }

    public double getVelocidad(){
        return this.velocidad;
    }

    public double getDistancia(){
        return this.distancia;
    }
}
