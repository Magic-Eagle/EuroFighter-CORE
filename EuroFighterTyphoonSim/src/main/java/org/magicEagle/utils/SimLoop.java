package org.magicEagle.utils;

import org.magicEagle.Main.Eurofighter;
import org.magicEagle.plane.Combustible;
import org.magicEagle.plane.Motor;
import org.magicEagle.plane.SistemaRefrigeracion;
import org.magicEagle.plane.SistemaSensores;

import javax.swing.*;
import java.awt.*;

public class SimLoop extends JPanel implements Runnable {
    private boolean running = true;

    final int originalTitleSize = 16; //16x16
    final int scale = 3; //scale becouse we are not in 80s

    public final int titleSize = originalTitleSize * scale; // 48x48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = titleSize * maxScreenCol; // 768px
    public final int screenHeight = titleSize * maxScreenRow; // 576 px

    Eurofighter eurofighter = new Eurofighter("Eurofighter 1","Listo para despegue");
    KeyHandler keyHandler = new KeyHandler();
    Motor motor = new Motor(150000,0,"Encendido",0,keyHandler);
    Combustible combustible = new Combustible(5000,5000,"SAF",motor.getConmsumoCombustible());
    SistemaSensores sistemaSensores = new SistemaSensores( 0, 0, "Sensor de Peso encendido",
            motor.getTemperatura(),  eurofighter, combustible, 4, motor);
    SistemaRefrigeracion sistemaRefrigeracion = new SistemaRefrigeracion(motor,sistemaSensores);
    Logs logs = new Logs(motor, combustible,sistemaSensores,sistemaRefrigeracion);

    public SimLoop() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.requestFocus();
    }


    public void updateInfo() {
        // Update all the info
        motor.ajustarPotencia();
        motor.ajustarConsumo();
        motor.ajustarTemperatura();
        combustible.consumirCombustible(motor.getConmsumoCombustible());
        sistemaSensores.obtenerPesoTotal();
        sistemaSensores.ajustarVelocidad();
        sistemaRefrigeracion.calculaRefrigeracion();
        sistemaRefrigeracion.refrigerar();
    }

    public void log() {
        logs.logMotor();
        logs.logsCombustible();
        logs.logsPeso();
        logs.logsVelocidad();
        logs.logsTemperatura();
    }

    public void stop() {
        running = false;
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }


    @Override
    public void run() {
        // 50hz interval
        int updateInterval = 8;

        while (running) {
            long startTime = System.currentTimeMillis();

            //actualizar informacion
            updateInfo();
            log();

            if (keyHandler.closePressed) {
                stop();
            }

            long endTime = System.currentTimeMillis() - startTime;
            if (endTime < updateInterval) {
                try {
                    Thread.sleep(updateInterval - endTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


