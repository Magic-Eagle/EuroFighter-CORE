package org.magicEagle.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * @Author: CoderAnchel
 * KeyHandler class implements the KeyListener interface to handle key events.
 * It tracks the state of various keys being pressed or released.
 */
public class KeyHandler implements KeyListener {
    public boolean
            upPressed,
            downPressed,
            closePressed,
            launchPressed,
            leftLaunch1Pressed,
            leftLaunch2Pressed,
            leftLaunch3Pressed,
            leftLaunch4Pressed,
            rightLaunch1Pressed,
            rightLaunch2Pressed,
            rightLaunch3Pressed,
            rightLaunch4Pressed,
            middleLaunch1Pressed,
            middleLaunch2Pressed,
            middleLaunch3Pressed,
            middleLaunch4Pressed,
            middleLaunch5Pressed,
            shotIsPressed;
    /**
     * This method is called when a key is typed.
     * It is not used in this implementation.
     *
     * @param e the KeyEvent
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //not used
    }

    /**
     * This method is called when a key is pressed.
     * It updates the state of the corresponding key to true.
     *
     * @param e the KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if(code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if(code == KeyEvent.VK_X) {
            closePressed = true;
        }

        if(code == KeyEvent.VK_0) {
            launchPressed = true;
        }

        //left launch
        if(code == KeyEvent.VK_1) {
            leftLaunch1Pressed = true;
        }

        if(code == KeyEvent.VK_2) {
            leftLaunch2Pressed = true;
        }

        if(code == KeyEvent.VK_3) {
            leftLaunch3Pressed = true;
        }

        if(code == KeyEvent.VK_4) {
            leftLaunch4Pressed = true;
        }

        //right launch
        if(code == KeyEvent.VK_5) {
            rightLaunch1Pressed = true;
        }

        if(code == KeyEvent.VK_6) {
            rightLaunch2Pressed = true;
        }

        if(code == KeyEvent.VK_7) {
            rightLaunch3Pressed = true;
        }

        if(code == KeyEvent.VK_8) {
            rightLaunch4Pressed = true;
        }

        if (code == KeyEvent.VK_ENTER) {
            shotIsPressed = true;
        }
    }

    /**
     * This method is called when a key is released.
     * It updates the state of the corresponding key to false.
     *
     * @param e the KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if(code == KeyEvent.VK_X) {
            closePressed = false;
        }
        if (code == KeyEvent.VK_ENTER) {
            shotIsPressed = false;
        }
    }
}

