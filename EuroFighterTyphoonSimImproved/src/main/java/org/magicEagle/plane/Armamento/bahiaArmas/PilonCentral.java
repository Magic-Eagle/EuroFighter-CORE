package org.magicEagle.plane.Armamento.bahiaArmas;

import org.magicEagle.plane.Armamento.Armamento;
import org.magicEagle.plane.Armamento.Bomb;
import org.magicEagle.plane.Armamento.Misile;

import java.util.ArrayList;

// NOT IMPLEMENTED ❌🔜

public class PilonCentral {
    int pilonesMax = 5;
    public ArrayList<Armamento> guns;
    public ArrayList<Misile> misiles;
    public ArrayList<Bomb> bombs;

    public PilonCentral() {
        guns = new ArrayList<>();
        misiles = new ArrayList<>();
        bombs = new ArrayList<>();
    }

    public void loadMisile(Misile arma) {
        if(misiles.size() + bombs.size() < pilonesMax) {
            misiles.add(arma);
        }else {
            System.out.println("No hay espacio en el pylon central");
        }
    }

    public int cantidadMisiles() {
        int i = 0;
        for (Misile arma : misiles) {
            if (!arma.estado) {
                i++;
            }
        }
        return i;
    }

    public void loadBomb(Bomb arma) {
        if(misiles.size() + bombs.size() < pilonesMax) {
            bombs.add(arma);
        } else {
            System.out.println("No hay espacio en el pylon central");
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

    public void unloadMisile(Armamento arma) {
        misiles.remove(arma);
    }


    public void showLodout() {
        guns.addAll(misiles);
        guns.addAll(bombs);
    }
}
