package org.magicEagle.plane.Armamento.bahiaArmas;

import org.magicEagle.plane.Armamento.Armamento;
import org.magicEagle.plane.Armamento.Misile;

import java.util.ArrayList;
import java.util.Objects;
/**
 * @Author: CoderAnchel
 * Represents the right pylon of the aircraft, which can hold a maximum of 4 weapons.
 */
public class PilonDerecho {
    int pilonesMax = 4;
    public ArrayList<Armamento> armas;

    /**
     * Constructor for PilonDerecho.
     * Initializes the armas list.
     */
    public PilonDerecho() {
        armas = new ArrayList<>();
    }
    /**
     * Loads a weapon onto the pylon if there is space available.
     *
     * @param arma the weapon to be loaded
     */
    public void loadGun(Armamento arma) {
        if(armas.size() < pilonesMax) {
            armas.add(arma);
        }
    }
    /**
     * Returns the number of weapons that are not in an active state.
     *
     * @return the count of inactive weapons
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
     * Unloads a weapon from the pylon.
     *
     * @param arma the weapon to be unloaded
     */
    public void unloadGun(Armamento arma) {
        armas.remove(arma);
    }
    /**
     * Returns the list of weapons currently loaded on the pylon.
     *
     * @return the list of loaded weapons
     */
    public ArrayList<Armamento> showLodout() {
        return armas;
    }
}
