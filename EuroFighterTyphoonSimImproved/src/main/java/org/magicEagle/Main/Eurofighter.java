package org.magicEagle.Main;

import org.magicEagle.plane.Armamento.Misile;
import org.magicEagle.plane.Armamento.bahiaArmas.PilonCentral;
import org.magicEagle.plane.Armamento.bahiaArmas.PilonDerecho;
import org.magicEagle.plane.Armamento.bahiaArmas.PilonIzquierdo;
import org.magicEagle.plane.Combustible;
import org.magicEagle.plane.Motor;
import org.magicEagle.plane.SistemaRefrigeracion;
import org.magicEagle.plane.SistemaSensores;
import org.magicEagle.utils.KeyHandler;
import org.magicEagle.utils.Logs;

/**
 * @Author: CoderAnchel
 * The Eurofighter class represents a Eurofighter aircraft with various components and systems.
 */
public class Eurofighter {

    /**
     * Declaring the components and systems of the Eurofighter.
     */
    public KeyHandler keyHandler = new KeyHandler();
    public Motor motor =  new Motor(150000, 0, "Encendido", 0, this.keyHandler);
    public Combustible combustible = new Combustible(5000, 5000, "SAF",this.motor.getConmsumoCombustible());
    public SistemaSensores sistemaSensores = new SistemaSensores(0, 0, "Sensor de Peso encendido", this.motor.getTemperatura(), this, this.combustible, 4, this.motor);
    public SistemaRefrigeracion sistemaRefrigeracion = new SistemaRefrigeracion(this.motor, this.sistemaSensores);
    public Logs logs = new Logs(this.motor, this.combustible, this.sistemaSensores, this.sistemaRefrigeracion);
    public Misile misile1 = new Misile("Misile 1", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);
    public Misile misile2 = new Misile("Misile 2", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);
    public Misile misile3 =  new Misile("Misile 3", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);
    public Misile misile4 =  new Misile("Misile 4", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);
    public Misile misile5 = new Misile("Misile 5", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);
    public Misile misile6 =  new Misile("Misile 6", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);
    public Misile misile7 = new Misile("Misile 7", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);
    public Misile misile8 = new Misile("Misile 8", "Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, this.keyHandler, false);

    public PilonDerecho pilonDerecho = new PilonDerecho();
    public PilonIzquierdo pilonIzquierdo = new PilonIzquierdo();
    public PilonCentral pilonCentral = new PilonCentral();

    public String name;
    public String estadoTierra;
    public String estadoMotor;

    public final double PESO_DESCARGADO = 11500;
    public final double VELOCIDAD_MAXIMA = 2.495;
    /**
     * Constructs a new Eurofighter instance with the specified name and ground status.
     *
     * @param name the name of the Eurofighter
     * @param estadoTierra the ground status of the Eurofighter
     */
    public Eurofighter(String name, String estadoTierra) {
        this.name = name;
        this.estadoTierra = estadoTierra;
    }

}