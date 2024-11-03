package org.magicEagle.plane.Armamento.bahiaArmas;

import org.magicEagle.plane.Armamento.Armamento;
import org.magicEagle.plane.Armamento.Misile;

import java.util.ArrayList;
import java.util.Objects;

public class PilonDerecho {
    int pilonesMax = 4;
    public ArrayList<Armamento> armas;

    public PilonDerecho() {
        armas = new ArrayList<>();
    }

    public void loadGun(Armamento arma) {
        if(armas.size() < pilonesMax) {
            armas.add(arma);
        }
    }

    public int cantidadArmas() {
        int i = 0;
        for (Armamento arma : armas) {
            if (!arma.estado) {
                i++;
            }
        }
        return i;
    }

    public void unloadGun(Armamento arma) {
        armas.remove(arma);
    }

    public ArrayList<Armamento> showLodout() {
        return armas;
    }
}
