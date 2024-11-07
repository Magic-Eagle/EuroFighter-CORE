package org.magicEagle.plane;

public class SistemaElectrico {
    public boolean sistemaElectrico = false;
    public boolean lucesDeCabina = false;
    public boolean taxingLights = false;
    public boolean formationLights = false;
    public boolean anticolisionLights = false;

    public void startElectricUnit() {
        sistemaElectrico = !sistemaElectrico;
    };

    public void startCabinLights() {
        lucesDeCabina = !lucesDeCabina;
    };

    public void startTaxingLights() {
        taxingLights = !taxingLights;
    };

    public void startFormationLights() {
        formationLights = !formationLights;
    };

    public void startAnticolisionLights() {
        anticolisionLights = !anticolisionLights;
    };

    public void stopElectricUnit() {
        sistemaElectrico = false;
    };

}
