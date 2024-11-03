package org.magicEagle.plane.Armamento;

public abstract class Armamento {
    String armamentType;
    int mass;
    public Boolean estado;

    public String getArmamentType() {
        return armamentType;
    }

    public int getMass() {
        return mass;
    }

    public void actualizarEstado(){
        this.estado = true;
    }
}
