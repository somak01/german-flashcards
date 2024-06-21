package org.example.TESTGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NextButton extends JButton {
    private JFrame mainFrame;
    public NextButton(JFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
        setBounds(100, 100, 100, 50);
        setBackground(Color.YELLOW);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'w') {
                    if (getX() + 10 < mainFrame.getWidth() - getWidth()) {
                        setBounds(getX() + 10, getY(), getWidth(), getHeight());
                    } else {
                        setBounds(mainFrame.getWidth() - getWidth(), getY(), getWidth(), getHeight());
                    }
                } else if (e.getKeyChar() == 's') {
                    if (getX() > 0) {
                        setBounds(getX() - 10, getY(), getWidth(), getHeight());
                    } else {
                        setBounds(0, getY(), getWidth(), getHeight());
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
