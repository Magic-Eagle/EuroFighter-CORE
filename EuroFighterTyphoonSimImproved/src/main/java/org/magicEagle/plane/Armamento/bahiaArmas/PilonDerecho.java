package org.magicEagle.plane.Armamento.bahiaArmas;

import org.magicEagle.plane.Armamento.Armamento;
import org.magicEagle.plane.Armamento.Bomb;
import org.magicEagle.plane.Armamento.Misile;

import java.util.ArrayList;
import java.util.Objects;
/**
 * @Author: CoderAnchel
 * Represents the right pylon of the aircraft, which can hold a maximum of 4 weapons.
 */
public class PilonDerecho {
    int pilonesMax = 4;

    public ArrayList<Armamento> guns;
    public ArrayList<Misile> misiles;
    public ArrayList<Bomb> bombs;

    /**
     * Constructor for PilonDerecho.
     * Initializes the armas list.
     */
    public PilonDerecho() {
        misiles = new ArrayList<>();
        bombs = new  ArrayList<>();
        guns = new ArrayList<>();
    }
    /**
     * Loads a weapon onto the pylon if there is space available.
     *
     * @param arma the weapon to be loaded
     */
    public void loadMisiles(Misile arma) {
        if(misiles.size() + bombs.size() < pilonesMax) {
            misiles.add(arma);
        }else {
            System.out.println("No hay espacio en el pylon izquierdo");
        }
    }

    public void loadBomb(Bomb arma) {
        if(misiles.size() + bombs.size() < pilonesMax) {
            bombs.add(arma);
        }else {
            System.out.println("No hay espacio en el pylon izquierdo");
        }
    }

    public int cantidadBombs() {
        int i = 0;
        for (Bomb arma : bombs) {
            if (!arma.estado) {
                i++;
            }
        }
        return i;
    }
    /**
     * Returns the number of weapons that are not in an active state.
     *
     * @return the count of inactive weapons
     */
    public int cantidadMisiles() {
        int i = 0;
        for (Misile arma : misiles) {
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
    public void unloadMisiles(Armamento arma) {
        misiles.remove(arma);
    }
    /**
     * Returns the list of weapons currently loaded on the pylon.
     *
     * @return the list of loaded weapons
     */
    public void showLodout() {
        guns.addAll(misiles);
        guns.addAll(bombs);
    }
}
