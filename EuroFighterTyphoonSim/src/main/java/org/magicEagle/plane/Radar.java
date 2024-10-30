package org.magicEagle.plane;

import org.magicEagle.Main.Eurofighter;

import java.util.ArrayList;

public class Radar {

    //CONSTANTES
    final double alcanceMaximo = 500.00;
    final double alcanceEfectivo = 50.00;
    final String SISTEMA = "Banda X";
    private final String [] MODOS_RADAR = {
            "Standby",
            "Aire-Aire",
            "Aire-Tierra",
            "Aire-Mar",
            "Aire-Aire Aire-Tierra",
            "Aire-Aire y Aire-Mar",
            "Aire-Tierra y Aire-Mar",
            "Aire-Aire, Aire-Tierra y Aire-Mar"
    };


    //Variables
    private String modoDeteccion;
    private boolean estado;
    private ArrayList<Eurofighter> objectivos;

    //Constructor
    public Radar(int modoDeteccion, boolean estado) {
        this.modoDeteccion = MODOS_RADAR[modoDeteccion];
        this.estado = estado;
        objectivos = new ArrayList<>();
    }

    public String getModoDeteccion() {
        return modoDeteccion;
    }

    public void setModoDeteccion(int modoDeteccion) {
        this.modoDeteccion = MODOS_RADAR[modoDeteccion];
    }

    public boolean getEstado() {
        return estado;
    }

    public void addObjetivo(Eurofighter eurofighter){
        objectivos.add(eurofighter);
    }

    public Eurofighter getObjetivo(int index){
        return objectivos.get(index);
    }
}
