package org.magicEagle.plane.Armamento.bahiaArmas;

import org.magicEagle.plane.Armamento.Armamento;

import java.util.ArrayList;

public class PilonIzquierdo {
    int pilonesMax = 4;
    public ArrayList<Armamento> armas;

    public PilonIzquierdo() {
        armas = new ArrayList<>();
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

    public void loadGun(Armamento arma) {
        if(armas.size() < pilonesMax) {
            armas.add(arma);
        }
    }

    public ArrayList<Armamento> showLodout() {
        return armas;
    }
}
