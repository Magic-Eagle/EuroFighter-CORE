package org.magicEagle.plane;

public class SistemaElectrico {
    public boolean sistemaElectrico = false;
    public  boolean LucesDeCabina = false;

    public void startElectricUnit() {
        sistemaElectrico = !sistemaElectrico;
    };

    public void stopElectricUnit() {
        sistemaElectrico = false;
    };

}
