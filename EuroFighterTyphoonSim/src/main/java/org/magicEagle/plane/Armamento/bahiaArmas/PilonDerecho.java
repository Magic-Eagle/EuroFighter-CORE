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

    public void checkStates() {
        for (Armamento arma : armas) {
           if (Objects.equals(arma.estado, "Lanzado")) {
               armas.remove(arma);
           }
        }
    }

    public void unloadGun(Armamento arma) {
        armas.remove(arma);
    }

    public ArrayList<Armamento> showLodout() {
        return armas;
    }
}
