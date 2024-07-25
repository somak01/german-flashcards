package org.example.GUI;

import org.example.Kontroller.Kontroller;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private final Dimension size = new Dimension(800, 800);
    private final MainMenu main = new MainMenu();
    private final GameMenu game = new GameMenu();
    private final SettingsMenu settings = new SettingsMenu();
    private final EndingScreen endingScreen = new EndingScreen();
    private final CardLayout cLayout = new CardLayout();
    private final Kontroller kontroller = new Kontroller(main, game, settings, endingScreen);
    public ContentPanel() {
        setSize(size);
        setMinimumSize(size);
        setPreferredSize(size);
        setLayout(cLayout);
        kontroller.configure();
        add(main, "main");
        add(game, "game");
        add(settings, "settings");
        add(endingScreen, "endingSc");
        cLayout.show(this, "main");
        cLayout.show(this, "title");
        setVisible(true);

    }
}
