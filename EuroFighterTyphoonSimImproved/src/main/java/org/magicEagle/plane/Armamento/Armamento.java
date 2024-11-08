package org.magicEagle.plane.Armamento;
/**
 * @Author: CoderAnchel
 * Abstract class representing an armament.
 */
public abstract class Armamento {
    String armamentType;
    int mass;
    public Boolean estado;
    private long launchTime = 0;
    public boolean launched = false;


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
}
