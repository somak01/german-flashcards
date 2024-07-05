package org.example.GUI;

import org.example.Kontroller;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private final Dimension size = new Dimension(800, 800);
    private final MainMenu main = new MainMenu();
    private final GameMenu game = new GameMenu();
    private final SettingsMenu settings = new SettingsMenu();
    private final CardLayout cLayout = new CardLayout();
    private final Kontroller kontroller = new Kontroller(main, game, settings);
    public ContentPanel() {
        setSize(size);
        setMinimumSize(size);
        setPreferredSize(size);
        setLayout(cLayout);
        add(main, "main");
        add(game, "game");
        add(settings, "settings");
        cLayout.show(this, "main");
        cLayout.show(this, "title");
        setVisible(true);

    }
}
