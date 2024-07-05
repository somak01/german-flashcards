package org.example.GUI;

import org.example.DB.WordSet;
import org.example.MODEL.Word;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private final MainMenu panel = new MainMenu();
    private final GameMenu game = new GameMenu();
    private final SettingsMenu settings = new SettingsMenu();
    public MainFrame() {
        setContentPane(panel);
        setSize(1000, 1000);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}

