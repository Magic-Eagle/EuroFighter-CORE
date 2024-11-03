package org.magicEagle.plane;

import java.util.ArrayList;

import org.magicEagle.Main.Eurofighter;

//NEEDS TO BE IMPLEMENTED ❌🔜

/**
 * @Author: CoderAnchel
 * Represents a radar system with various detection modes and states.
 */
public class Radar {
    final double alcanceMaximo = 500.00;
    final double alcanceEfectivo = 50.00;
    final String SISTEMA = "Banda X";
    private final String[] MODOS_RADAR = {
            "Standby",
            "Aire-Aire",
            "Aire-Tierra",
            "Aire-Mar",
            "Aire-Aire Aire-Tierra",
            "Aire-Aire y Aire-Mar",
            "Aire-Tierra y Aire-Mar",
            "Aire-Aire, Aire-Tierra y Aire-Mar"
    };
    private String modoDeteccion;
    private boolean estado;
    private ArrayList<Eurofighter> objectivos;

    /**
     * Constructs a Radar object with the specified detection mode and state.
     *
     * @Author: CoderAnchel
     * @param modoDeteccion the index of the detection mode in MODOS_RADAR
     * @param estado the initial state of the radar (true for on, false for off)
     */
    public Radar(int modoDeteccion, boolean estado) {
        this.modoDeteccion = MODOS_RADAR[modoDeteccion];
        this.estado = estado;
        objectivos = new ArrayList<>();
    }
    /**
     * Returns the current detection mode of the radar.
     *
     * @Author: CoderAnchel
     * @return the current detection mode
     */
    public String getModoDeteccion() {
        return modoDeteccion;
    }
    /**
     * Sets the detection mode of the radar.
     *
     * @Author: CoderAnchel
     * @param modoDeteccion the index of the new detection mode in MODOS_RADAR
     */
    public void setModoDeteccion(int modoDeteccion) {
        this.modoDeteccion = MODOS_RADAR[modoDeteccion];
    }
    /**
     * Returns the current state of the radar.
     *
     * @Author: CoderAnchel
     * @return true if the radar is on, false otherwise
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Adds a Eurofighter object to the radar's list of detected objects.
     *
     * @Author: CoderAnchel
     * @param eurofighter the Eurofighter object to be added
     */
    public void addObjetivo(Eurofighter eurofighter) {
        objectivos.add(eurofighter);
    }
    /**
     * Returns the Eurofighter object at the specified index in the list of detected objects.
     *
     * @Author: CoderAnchel
     * @param index the index of the Eurofighter object to return
     * @return the Eurofighter object at the specified index
     */
    public Eurofighter getObjetivo(int index) {
        return objectivos.get(index);
    }
}
