package org.magicEagle.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, closePressed, launchPressed;

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

        if(code == KeyEvent.VK_L) {
            launchPressed = true;
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

