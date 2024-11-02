package org.magicEagle.utils;

import org.magicEagle.Main.Eurofighter;
import org.magicEagle.plane.Armamento.Misile;
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
    Misile misile = new Misile("Misile 1","Misile", 1000, "Guidance", "Aspect", 100, 1000, 1000, 100, 100, 100, keyHandler);


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
        misile.checkLaunch();
    }

    public void log() {
        logs.logMotor();
        logs.logsCombustible();
        logs.logsPeso();
        logs.logsVelocidad();
        logs.logsTemperatura();
    }

    public void paintComponent(Graphics g)   {
        super.paintComponent(g);

        String potencia = String.format("%.3f", motor.getnivelActualPotencia());
        String velocidad = String.format( "%.3f", sistemaSensores.ajustarVelocidad());
        String combustibleString = String.format( "%.3f", combustible.getNivelActual());
        String temperatura = String.format("%.3f", motor.getTemperatura());
        String misileVelocidad = String.format("%f", misile.getVelocidad());
        String misileDistance = String.format("%f", misile.getDistancia());

        Graphics g2 = (Graphics2D)g;

        //Fuente
        Font font = new Font("Arial", Font.BOLD, 16);
        g2.setFont(font);
        FontMetrics metrics = g2.getFontMetrics(font);


        g2.setColor(Color.white);
        g2.drawString("Velocidad", 150, 35);

        g2.setColor(Color.white);
        g2.fillRect(120, 50, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(velocidad,"%.3f" ), 150, 75);

        g2.setColor(Color.white);
        g2.drawString("Potencia", 330, 35);

        g2.setColor(Color.white);
        g2.fillRect(300, 50, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(potencia, "%.3f"), 330, 75);

        g2.setColor(Color.white);
        g2.drawString("Combustible", 510, 35);

        g2.setColor(Color.white);
        g2.fillRect(480, 50, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(combustibleString, "%.3f"), 510, 75);

        g2.setColor(Color.white);
        g2.drawString("Temperatura", 218, 180);

        g2.setColor(Color.white);
        g2.fillRect(188, 190, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(temperatura, "%.3f"), 218, 215);

        g2.setColor(Color.white);
        g2.drawString("Refrigeracion", 418, 180);

        g2.setColor(Color.white);
        g2.fillRect(388, 190, 160, 40);
        g2.setColor(Color.black);
        g2.drawString("100%", 418, 215);


        g2.setColor(Color.yellow);
        g2.fillRect(95, 300, 260, 40);
        g2.setColor(Color.black);
        g2.drawString("START ELECTRIC UNIT", 130, 325);

        // Sexto rectángulo (verde)
        g2.setColor(Color.green);
        g2.fillRect(95, 370, 260, 40);
        g2.setColor(Color.black);
        g2.drawString("START ENGINE", 130, 395);

        // Séptimo rectángulo (rosa)
        g2.setColor(Color.pink);
        g2.fillRect(95, 440, 260, 40);
        g2.setColor(Color.black);
        g2.drawString("START DOWN ENGINE", 130, 465);// Ajusta las coordenadas en el eje y

        // MISIL LANZADO (azul)

        if ("Lanzado".equals(misile.getEstado())) {
            g2.setColor(Color.BLUE);
            g2.fillRect(470, 300, 260, 40);
            g2.setColor(Color.WHITE);
            g2.drawString("MISIL LANZADO", 500, 325);
        }

        if ("Lanzad".equals(misile.getEstado())) {
            g2.setColor(Color.BLUE);
            g2.fillRect(470, 370, 260, 40);
            g2.setColor(Color.WHITE);
            g2.drawString(misileVelocidad, 500, 400);
        }

        g2.dispose();
    }

    public void stop() {
        motor.reset();
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
            repaint();

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


