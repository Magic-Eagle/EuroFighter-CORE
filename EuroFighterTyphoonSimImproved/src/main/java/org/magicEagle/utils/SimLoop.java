package org.magicEagle.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
    public final int maxScreenCol = 28;
    public final int maxScreenRow = 17;
    public final int screenWidth = titleSize * maxScreenCol; // 768px
    public final int screenHeight = titleSize * maxScreenRow; // 576 px

    // BufferedImage to hold the image of the Eurofighter
    BufferedImage image;


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
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(eurofighter.keyHandler);
        this.setFocusable(true);
        this.requestFocus();
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
        eurofighter.pilonDerecho.cantidadArmas();
        eurofighter.pilonIzquierdo.cantidadArmas();
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
    public void checkLeftLaunch(){
        if(eurofighter.keyHandler.leftLaunch1Pressed){
            eurofighter.misile1.actualizarEstado();
        }
        if(eurofighter.keyHandler.leftLaunch2Pressed){
            eurofighter.misile2.actualizarEstado();
        }
        if(eurofighter.keyHandler.leftLaunch3Pressed){
            eurofighter.misile3.actualizarEstado();
        }
        if(eurofighter.keyHandler.leftLaunch4Pressed){
            eurofighter.misile4.actualizarEstado();
        }
    }
    /**
     * Checks the state of the right launch buttons and updates the missile states accordingly.
     * If any of the right launch buttons are pressed, the corresponding missile's state is updated.
     */
    public void checkRightLaunch(){
        if(eurofighter.keyHandler.rightLaunch1Pressed){
            eurofighter.misile5.actualizarEstado();
        }
        if(eurofighter.keyHandler.rightLaunch2Pressed){
            eurofighter.misile6.actualizarEstado();
        }
        if(eurofighter.keyHandler.rightLaunch3Pressed){
            eurofighter.misile7.actualizarEstado();
        }
        if(eurofighter.keyHandler.rightLaunch4Pressed){
            eurofighter.misile8.actualizarEstado();
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

        Date date = new Date();

        String potencia = String.format("%.3f", eurofighter.motor.getnivelActualPotencia());
        String velocidad = String.format( "%.3f", eurofighter.sistemaSensores.ajustarVelocidad());
        String combustibleString = String.format( "%.3f", eurofighter.combustible.getNivelActual());
        String temperatura = String.format("%.3f", eurofighter.motor.getTemperatura());
        String cantidadArmasDerecha = String.format("%d", eurofighter.pilonDerecho.cantidadArmas());
        String cantidadArmasIzquierda = String.format("%d", eurofighter.pilonIzquierdo.cantidadArmas());

        Graphics g2 = (Graphics2D)g;

        //Fuente
        try {
            // Carga la fuente desde un archivo .ttf
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/org/magicEagle/assets/Excalifont-Regular (1).ttf")).deriveFont(Font.BOLD, 21);
            image = ImageIO.read(new File("src/main/java/org/magicEagle/assets/eurofighter-freisteller.png"));
            g2.setFont(customFont);  // Configura la fuente personalizada
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());


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
        g2.drawString(String.format(temperatura, "%.2f"), 218, 215);

        g2.setColor(Color.white);
        g2.drawString("Refrigeracion", 418, 180);

        g2.setColor(Color.white);
        g2.fillRect(388, 190, 160, 40);
        g2.setColor(Color.black);
        g2.drawString("100%", 418, 215);

        g2.drawImage(image, 700, 50,560,300, this);


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

        if(eurofighter.misile1.estado == true) {
            g2.setColor(Color.red);
            g2.fillRect(400, 310, 260, 40);
            g2.setColor(Color.black);
            g2.drawString("MISILE LAUNCHED", 430, 335);
        }

        if(eurofighter.misile2.estado == true) {
            g2.setColor(Color.red);
            g2.fillRect(500, 410, 260, 40);
            g2.setColor(Color.black);
            g2.drawString("MISILE LAUNCHED", 530, 435);
        }

        if(eurofighter.misile3.estado == true) {
            g2.setColor(Color.red);
            g2.fillRect(500, 510, 260, 40);
            g2.setColor(Color.black);
            g2.drawString("MISILE LAUNCHED", 530, 635);
        }

        // numeros

        if (eurofighter.pilonDerecho.armas != null) {
            g2.setColor(Color.red);
            g2.fillRect(400, 470, 260, 40);
            g2.setColor(Color.black);
            g2.drawString(String.format(cantidadArmasIzquierda, "Cantidad de armas P1:  %.3d"), 430, 495);
        }

        if (eurofighter.pilonIzquierdo.armas != null) {
            g2.setColor(Color.red);
            g2.fillRect(400, 570, 260, 40);
            g2.setColor(Color.black);
            g2.drawString(String.format(cantidadArmasDerecha, "Cantidad de armas P2:  %.3d"), 430, 595);
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

        eurofighter.pilonIzquierdo.loadGun(eurofighter.misile1);
        eurofighter.pilonIzquierdo.loadGun(eurofighter.misile2);
        eurofighter.pilonIzquierdo.loadGun(eurofighter.misile3);
        eurofighter.pilonIzquierdo.loadGun(eurofighter.misile4);

        eurofighter.pilonDerecho.loadGun(eurofighter.misile5);
        eurofighter.pilonDerecho.loadGun(eurofighter.misile6);
        eurofighter. pilonDerecho.loadGun(eurofighter.misile7);
        eurofighter.pilonDerecho.loadGun(eurofighter.misile8);


        while (running) {
            long startTime = System.currentTimeMillis();

            //actualizar informacion
            updateInfo();
            checkLeftLaunch();
            checkRightLaunch();
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


