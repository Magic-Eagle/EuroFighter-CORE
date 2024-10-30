package org.magicEagle.utils;

import org.magicEagle.plane.Motor;

public class SimLoop {
    private boolean running = true;

    KeyHandler keyHandler = new KeyHandler();
    Motor motor = new Motor(2565.00F,0.0F,"Encendido",0.0F,keyHandler);
    Logs logs = new Logs(motor);

    public void runSim() {
        // 20ms 50hz interval
        int updateInterval = 20;

        while (running) {
            long startTime = System.currentTimeMillis();

            //actualizar informacion
            updateInfo();
            logMotor();

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


    public void updateInfo() {
        // Update all the info
        motor.ajustarPotencia();
    }

    public void logMotor() {
        logs.logMotor();
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



}


