package org.magicEagle.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.magicEagle.Main.Eurofighter;

/**
 * @Author: CoderAnchel
 * This class represents the main simulation loop for the Eurofighter simulation.
 * It extends JPanel and implements Runnable to allow for graphical updates and
 * continuous simulation updates.
 */
public class SimLoop extends JPanel implements Runnable {
    private boolean running = true;

    final int originalTitleSize = 16; //16x16
    final int scale = 3; //scale becouse we are not in 80s

    // Screen size
    public final int titleSize = originalTitleSize * scale; // 48x48
    public final int maxScreenCol = 31;
    public final int maxScreenRow = 19;
    public final int screenWidth = titleSize * maxScreenCol; // 768px
    public final int screenHeight = titleSize * maxScreenRow; // 576 px

    // BufferedImage to hold the image of the Eurofighter
    BufferedImage image, image2;


    // Instance of Eurofighter with the name and status
    Eurofighter eurofighter = new Eurofighter(
            "Eurofighter 1",
            "Listo para despegue"
    );

    int iterador = 200;

    /**
     * Constructs a new SimLoop instance and initializes the panel settings.
     * Sets the preferred size, background color, double buffering, key listener,
     * and focusable state for the simulation loop panel.
     */
    public SimLoop() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.decode("#1e1e1e"));
        this.setDoubleBuffered(true);
        this.addKeyListener(eurofighter.keyHandler);
        this.setFocusable(true);
        this.requestFocus();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.println("X: " + x + " Y: " + y);
                //95, 300 + 30
                //detectar su el click ocurrio en el boton de encender la unidad electrica
                if (x >= 95 && x <= 355 && y >= 300 + 30 && y <= 340 + 60) {
                    eurofighter.sistemaElectrico.startElectricUnit();
                }
            }
        });
    }

    /**
     * Updates the information of various components in the simulation.
     * This method adjusts the power, consumption, and temperature of the motor,
     * consumes fuel, updates sensor data, and checks the states of the missile and pylon.
     */
    public void updateInfo() {
        // Update all the info
        eurofighter.motor.ajustarPotencia();
        eurofighter.motor.ajustarConsumo();
        eurofighter.motor.ajustarTemperatura();
        eurofighter.combustible.consumirCombustible(eurofighter.motor.getConmsumoCombustible());
        eurofighter.sistemaSensores.obtenerPesoTotal();
        eurofighter.sistemaSensores.ajustarVelocidad();
        eurofighter.sistemaRefrigeracion.calculaRefrigeracion();
        eurofighter.sistemaRefrigeracion.refrigerar();
        eurofighter.pilonDerecho.cantidadMisiles();
        eurofighter.pilonDerecho.cantidadBombs();
        eurofighter.pilonDerecho.showLodout();
        eurofighter.pilonIzquierdo.cantidadMisiles();
        eurofighter.pilonIzquierdo.cantidadBombs();
        eurofighter.pilonIzquierdo.showLodout();
        eurofighter.pilonCentral.cantidadMisiles();
        eurofighter.pilonCentral.cantidadBombs();
        eurofighter.pilonCentral.showLodout();
    }

    /**
     * Logs the information of various components in the simulation.
     * This method logs the motor, fuel, weight, speed, and temperature data.
     */
    public void log() {
        eurofighter.logs.logMotor();
        eurofighter.logs.logsCombustible();
        eurofighter.logs.logsPeso();
        eurofighter.logs.logsVelocidad();
        eurofighter.logs.logsTemperatura();
    }
    /**
     * Checks the state of the left launch buttons and updates the missile states accordingly.
     * If any of the left launch buttons are pressed, the corresponding missile's state is updated.
     */

    public void checkIfShot() {
        if (eurofighter.keyHandler.shotIsPressed && eurofighter.cannon.amo > 0) {
            eurofighter.cannon.shoot();
            eurofighter.cannon.estado = true;
        } else if (!eurofighter.keyHandler.shotIsPressed) {
            eurofighter.cannon.estado = false;
        }
    }

    public void checkLeftLaunch(){

        if(eurofighter.keyHandler.leftLaunch1Pressed && !eurofighter.misile1.launched){
            eurofighter.misile1.actualizarEstado();
        }
        if(eurofighter.keyHandler.leftLaunch2Pressed && !eurofighter.misile2.launched){
            eurofighter.misile2.actualizarEstado();
        }
        if(eurofighter.keyHandler.leftLaunch3Pressed && !eurofighter.misile3.launched){
            eurofighter.misile3.actualizarEstado();
        }
        if(eurofighter.keyHandler.leftLaunch4Pressed && !eurofighter.bomb1.launched){
            eurofighter.bomb1.actualizarEstado();
        }
    }
    /**
     * Checks the state of the right launch buttons and updates the missile states accordingly.
     * If any of the right launch buttons are pressed, the corresponding missile's state is updated.
     */
    public void checkRightLaunch(){
        if(eurofighter.keyHandler.rightLaunch1Pressed && !eurofighter.misile5.launched){
            eurofighter.misile5.actualizarEstado();
        }
        if(eurofighter.keyHandler.rightLaunch2Pressed && !eurofighter.misile6.launched){
            eurofighter.misile6.actualizarEstado();
        }
        if(eurofighter.keyHandler.rightLaunch3Pressed  && !eurofighter.misile7.launched){
            eurofighter.misile7.actualizarEstado();
        }
        if(eurofighter.keyHandler.rightLaunch4Pressed && !eurofighter.bomb2.launched){
            eurofighter.bomb2.actualizarEstado();
        }
    }
    public void checkMiddleLaunch(){
        if(eurofighter.keyHandler.middleLaunch1Pressed && !eurofighter.misile11.launched){
            eurofighter.misile11.actualizarEstado();
        }
        if(eurofighter.keyHandler.middleLaunch2Pressed && !eurofighter.misile12.launched){
            eurofighter.misile12.actualizarEstado();
        }
        if(eurofighter.keyHandler.middleLaunch3Pressed  && !eurofighter.misile13.launched){
            eurofighter.misile13.actualizarEstado();
        }
        if(eurofighter.keyHandler.middleLaunch4Pressed  && !eurofighter.misile14.launched){
            eurofighter.misile14.actualizarEstado();
        }
        if(eurofighter.keyHandler.middleLaunch5Pressed && !eurofighter.bomb11.launched){
            eurofighter.bomb11.actualizarEstado();
        }
    }
    /**
     * Paints the components of the simulation loop panel.
     * This method paints the speed, power, fuel, temperature, cooling, and missile data.
     * It also displays the Eurofighter image and various buttons for the simulation.
     *
     * @param g the graphics object to paint the components
     */
    public void paintComponent(Graphics g)   {
        super.paintComponent(g);

        String potencia = String.format("%.3f", eurofighter.motor.getnivelActualPotencia());
        String velocidad = String.format( "%.3f", eurofighter.sistemaSensores.ajustarVelocidad());
        String combustibleString = String.format( "%.3f", eurofighter.combustible.getNivelActual());
        String temperatura = String.format("%.3f", eurofighter.motor.getTemperatura());
        String cantidadMisilesDerecha = String.format("%d", eurofighter.pilonDerecho.cantidadMisiles());
        String cantidadMisilesIzquierda = String.format("%d", eurofighter.pilonIzquierdo.cantidadMisiles());
        String cantidadBombasDerecha = String.format("%d", eurofighter.pilonDerecho.cantidadBombs());
        String cantidadBombasIzquierda = String.format("%d", eurofighter.pilonIzquierdo.cantidadBombs());
        String cantidadMisilesCentro = String.format("%d", eurofighter.pilonCentral.cantidadMisiles());
        String cantidadBombasCentro = String.format("%d", eurofighter.pilonCentral.cantidadBombs());

        Graphics g2 = (Graphics2D)g;

        //Fuente
        try {
            // Carga la fuente desde un archivo .ttf
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/org/magicEagle/assets/Inter-VariableFont_opsz,wght.ttf")).deriveFont(Font.BOLD, 14);

            Font customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/org/magicEagle/assets/Inter-VariableFont_opsz,wght.ttf")).deriveFont(Font.BOLD, 24);

            image = ImageIO.read(new File("src/main/java/org/magicEagle/assets/eurofighter-freisteller.png"));
            image2 = ImageIO.read(new File("src/main/java/org/magicEagle/assets/Eurofighter_Typhoon-logo-B7C3B310E1-seeklogo.com.png"));
            g2.setFont(customFont);  // Configura la fuente personalizada
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());

        g2.setColor(Color.decode("#08193c"));
        g2.fillRect(0,0,1800, 60);
        g2.drawImage(image2, 20, 5, 120, 50, this);

        g2.setColor(Color.white);
        g2.drawString("MagicEagle - TEST BANK", 1250, 35);

        g2.setColor(Color.white);
        g2.drawString("Velocidad", 120, 95);

        g2.setColor(Color.white);
        g2.fillRect(120, 110, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(velocidad,"%.3f" ), 150, 135);

        g2.setColor(Color.white);
        g2.drawString("Potencia", 300, 95);

        g2.setColor(Color.white);
        g2.fillRect(300, 110, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(potencia, "%.3f"), 330, 135);

        g2.setColor(Color.white);
        g2.drawString("Combustible", 480, 95);

        g2.setColor(Color.white);
        g2.fillRect(480, 110, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(combustibleString, "%.3f"), 510, 135);

        g2.setColor(Color.white);
        g2.drawString("Temperatura", 188, 240);

        g2.setColor(Color.white);
        g2.fillRect(188, 250, 160, 40);
        g2.setColor(Color.black);
        g2.drawString(String.format(temperatura, "%.2f"), 218, 275);

        g2.setColor(Color.white);
        g2.drawString("Refrigeracion", 388, 240);

        g2.setColor(Color.white);
        g2.fillRect(388, 250, 160, 40);
        g2.setColor(Color.black);
        g2.drawString("100%", 418, 275);

        g2.drawImage(image, 700, 50, 560, 300, this);

        if (!eurofighter.sistemaElectrico.sistemaElectrico){
            g2.setColor(Color.decode("#ffd43b"));
            g2.fillRect(95, 300 + 30, 260, 40);
            g2.setColor(Color.black);
            g2.drawString("START ELECTRIC UNIT", 141, 325 + 30);
        } else {
            g2.setColor(Color.decode("#fc090f"));
            g2.fillRect(95, 300 + 30, 260, 40);
            g2.setColor(Color.black);
            g2.drawString("SHUT DOWN ELECTRIC UNIT", 120, 325 + 30);
        }

        // Sexto rectángulo (verde)
        g2.setColor(Color.decode("#69db7c"));
        g2.fillRect(95, 370 + 30, 260, 40);
        g2.setColor(Color.black);
        g2.drawString("START ENGINE", 170, 395 + 30);

        // Séptimo rectángulo (rosa)
        g2.setColor(Color.decode("#da77f2"));
        g2.fillRect(95, 440 + 30, 260, 40);
        g2.setColor(Color.black);
        g2.drawString("SHUT DOWN ENGINE", 145, 465 + 30);

        g2.setColor(Color.WHITE);
        g2.drawString("Misiles", 430, 325);

        g2.setColor(Color.WHITE);
        g2.drawString("Bombs", 730, 325);

        g2.setColor(Color.WHITE);
        g2.drawString("Cannon", 1030, 325);

        if (eurofighter.misile1.shouldDisplayExplosion()) {
            g2.setColor(Color.decode("#ffc9c9"));
            g2.fillRect(430, 490, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawRect(430, 490, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawString("MISILE 1 IS OUT", 460, 512);
        }

        // Repetimos para otros elementos según la lógica anterior
        if (eurofighter.misile2.shouldDisplayExplosion()) {
            g2.setColor(Color.decode("#ffc9c9"));
            g2.fillRect(430, 525, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawRect(430, 525, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawString("MISILE 2 IS OUT", 460, 547);
        }

        if (eurofighter.misile3.shouldDisplayExplosion()) {
            g2.setColor(Color.decode("#ffc9c9"));
            g2.fillRect(430, 560, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawRect(430, 560, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawString("MISILE 3 IS OUT", 460, 582);
        }

        if (eurofighter.bomb1.shouldDisplayExplosion()) {
            g2.setColor(Color.decode("#ffc9c9"));
            g2.fillRect(730, 490, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawRect(730, 490, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawString("BOMB 1 IS OUT", 760, 512);
        }

        if (eurofighter.bomb2.shouldDisplayExplosion()) {
            g2.setColor(Color.decode("#ffc9c9"));
            g2.fillRect(730, 525, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawRect(730, 525, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawString("BOMB 2 IS OUT", 760, 547);
        }

        if (eurofighter.bomb11.shouldDisplayExplosion()) {
            g2.setColor(Color.decode("#ffc9c9"));
            g2.fillRect(730, 560, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawRect(730, 560, 260, 30);

            g2.setColor(Color.decode("#e03131"));
            g2.drawString("BOMB 3 IS OUT", 760, 582);
        }

        // Misiles lanzados adicionales
        if (eurofighter.misile5.shouldDisplayExplosion()) {
            g2.setColor(Color.red);
            g2.fillRect(500, 310, 260, 40);
            g2.setColor(Color.black);
            g2.drawString("MISILE LAUNCHED", 530, 335);
        }

        if (eurofighter.misile6.shouldDisplayExplosion()) {
            g2.setColor(Color.red);
            g2.fillRect(500, 410, 260, 40);
            g2.setColor(Color.black);
            g2.drawString("MISILE LAUNCHED", 530, 435);
        }

        // Pylon Izquierdo
        if (eurofighter.pilonIzquierdo.misiles != null) {
            g2.setColor(Color.decode("#1e1e1e"));
            g2.fillRect(430, 340, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawRect(430, 340, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawString("Left Pylon: " + String.format(cantidadMisilesIzquierda, "Cantidad de Bombas P1:  %.3d"), 460, 365);
        }

        // Pilon central
        if (eurofighter.pilonCentral.misiles != null) {
            g2.setColor(Color.decode("#1e1e1e"));
            g2.fillRect(430, 390, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawRect(430, 390, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawString("Middle Pylon: " + String.format(cantidadMisilesCentro, "Cantidad de Bombas P2:  %.3d"), 460, 415);
        }

        // Pylon Derecho
        if (eurofighter.pilonDerecho.misiles != null) {
            g2.setColor(Color.decode("#1e1e1e"));
            g2.fillRect(430, 440, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawRect(430, 440, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawString("Right Pylon: " + String.format(cantidadMisilesDerecha, "Cantidad de Bombas P2:  %.3d"), 460, 465);
        }

        // Pylon Izquierdo (Bombas)
        if (eurofighter.pilonIzquierdo.bombs != null) {
            g2.setColor(Color.decode("#1e1e1e"));
            g2.fillRect(730, 340, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawRect(730, 340, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawString("Left Pylon: " + String.format(cantidadBombasIzquierda, "Cantidad de Bombas P1:  %.3d"), 760, 365);
        }
        if (eurofighter.pilonCentral.bombs != null) {
            g2.setColor(Color.decode("#1e1e1e"));
            g2.fillRect(730, 390, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawRect(730, 390, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawString("Center Pylon: " + String.format(cantidadBombasCentro, "Cantidad de Bombas P1:  %.3d"), 760, 415);
        }
        if (eurofighter.pilonDerecho.bombs != null) {
            g2.setColor(Color.decode("#1e1e1e"));
            g2.fillRect(730, 430, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawRect(730, 430, 260, 40);

            g2.setColor(Color.WHITE);
            g2.drawString("Right Pylon: " + String.format(cantidadBombasCentro, "Cantidad de Bombas P1:  %.3d"), 760, 455);
        }

        // Cannon
        g2.setColor(Color.decode("#1e1e1e"));
        g2.fillRect(1030, 340, 260, 40);

        g2.setColor(Color.WHITE);
        g2.drawRect(1030, 340, 260, 40);

        g2.setColor(Color.WHITE);
        g2.drawString(String.format("%d", eurofighter.cannon.amo) + " Remaining", 1060, 365);

        if (eurofighter.cannon.estado) {
            g2.setColor(Color.decode("#b2f2bb"));
            g2.fillRect(1030, 390, 260, 40);

            g2.setColor(Color.decode("#2f9e44"));
            g2.drawRect(1030, 390, 260, 40);

            g2.setColor(Color.decode("#2f9e44"));
            g2.drawString("SHOOTING", 1060, 415);
        }

        g2.dispose();
    }
    /**
     * Stops the simulation loop and resets the motor state.
     * Sets the running flag to false to stop the loop.
     */
    public void stop() {
        eurofighter.motor.reset();
        running = false;
    }

    /**
     * Checks if the simulation loop is currently running.
     *
     * @return true if the simulation loop is running, false otherwise
     */
    public boolean isRunning() {
        return running;
    }
    /**
     * Sets the running state of the simulation loop.
     *
     * @param running the new running state of the simulation loop
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * @Author: CoderAnchel
     * Runs the simulation loop with a 50Hz interval.
     * This method loads the right pylon with missiles and updates the information,
     * logs, and repaints the simulation loop panel. It also stops the simulation loop
     * if the close button is pressed.
     */
    @Override
    public void run() {

        // 50hz interval
        int updateInterval = 8;

        eurofighter.pilonIzquierdo.loadMisile(eurofighter.misile1);
        eurofighter.pilonIzquierdo.loadMisile(eurofighter.misile2);
        eurofighter.pilonIzquierdo.loadMisile(eurofighter.misile3);
        eurofighter.pilonIzquierdo.loadBomb(eurofighter.bomb1);

        eurofighter.pilonCentral.loadMisile(eurofighter.misile11);
        eurofighter.pilonCentral.loadMisile(eurofighter.misile12);
        eurofighter.pilonCentral.loadMisile(eurofighter.misile13);
        eurofighter.pilonCentral.loadMisile(eurofighter.misile14);
        eurofighter.pilonCentral.loadBomb(eurofighter.bomb11);

        eurofighter.pilonDerecho.loadMisiles(eurofighter.misile5);
        eurofighter.pilonDerecho.loadMisiles(eurofighter.misile6);
        eurofighter. pilonDerecho.loadMisiles(eurofighter.misile7);
        eurofighter.pilonDerecho.loadBomb(eurofighter.bomb2);

        while (running) {
            long startTime = System.currentTimeMillis();

            //actualizar informacion
            updateInfo();
            checkLeftLaunch();
            checkMiddleLaunch();
            checkRightLaunch();
            checkIfShot();
            log();
            repaint();

            if (eurofighter.keyHandler.closePressed) {
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


