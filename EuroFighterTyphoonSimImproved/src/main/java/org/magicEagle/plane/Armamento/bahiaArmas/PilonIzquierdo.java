package org.magicEagle.plane.Armamento.bahiaArmas;

import org.magicEagle.plane.Armamento.Armamento;

import java.util.ArrayList;
/**
 * @Author: CoderAnchel
 * Represents the left pylon of the aircraft, which can hold a maximum of 4 weapons.
 */
public class PilonIzquierdo {
    int pilonesMax = 4;
    public ArrayList<Armamento> armas;

    /**
     * Constructor for PilonIzquierdo.
     * Initializes the armas list.
     */
    public PilonIzquierdo() {
        armas = new ArrayList<>();
    }

    /**
     * Counts the number of weapons that are not in an active state.
     *
     * @return the number of inactive weapons.
     */
    public int cantidadArmas() {
        int i = 0;
        for (Armamento arma : armas) {
            if (!arma.estado) {
                i++;
            }
        }
        return i;
    }

    /**
     * Loads a weapon onto the pylon if there is space available.
     *
     * @param arma the weapon to be loaded.
     */
    public void loadGun(Armamento arma) {
        if(armas.size() < pilonesMax) {
            armas.add(arma);
        }
    }
    /**
     * Returns the list of weapons currently loaded on the pylon.
     *
     * @return the list of loaded weapons.
     */
    public ArrayList<Armamento> showLodout() {
        return armas;
    }
}
