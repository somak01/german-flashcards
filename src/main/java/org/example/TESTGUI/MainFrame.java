package org.example.TESTGUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        NextButton nb = new NextButton(this);
        add(nb);
        setSize(1000, 1000);
        setLayout(null);
        getContentPane().setBackground(Color.getHSBColor(56f, 15f, 88f));
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}

