package org.magicEagle.utils;

import org.magicEagle.plane.Combustible;
import org.magicEagle.plane.Motor;

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

    KeyHandler keyHandler = new KeyHandler();
    Motor motor = new Motor(150000.0,0.0,"Encendido",0.0F,keyHandler);
    Combustible combustible = new Combustible(5000.0,5000.0,"SAF",motor.getConmsumoCombustible());
    Logs logs = new Logs(motor, combustible);

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
        combustible.consumirCombustible(motor.getConmsumoCombustible());
    }

    public void log() {
        logs.logMotor();
        logs.logsCombustible();
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


