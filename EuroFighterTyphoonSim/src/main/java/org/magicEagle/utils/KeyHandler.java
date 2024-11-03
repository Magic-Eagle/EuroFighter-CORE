package org.magicEagle.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            middleLaunch5Pressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //not used
    }


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
    }

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
    }
}

