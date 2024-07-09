package org.example.GUI;

import org.example.Kontroller.Kontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends Menu{
    private final JButton settings = new JButton("Settings");
    private final JButton play = new JButton("Play");
    private final JButton exit = new JButton("Exit");
    private final GridBagLayout layout = new GridBagLayout();
    private final GridBagConstraints constraints = new GridBagConstraints();
    public MainMenu() {
        super("Main menu");
        setLayout(layout);
        generalConstraints();
        titleConstraints();
//        add(title, constraints);
        playConstraints();
        add(play, constraints);
        settingsConstraints();
        add(settings, constraints);
        exitConstraints();
        add(exit, constraints);

    }
    private void titleConstraints() {
        constraints.gridy = 0;
    }
    private void generalConstraints() {
        constraints.insets = new Insets(50, 100, 50, 100);
    }
    private void playConstraints() {
        constraints.gridy = 1;
    }
    private void settingsConstraints() {
        constraints.gridy = 2;
    }
    private void exitConstraints() {
        constraints.gridy = 3;
    }

    public void setExitListener(ActionListener newAction) {
        setActionToButton(newAction, exit);
    }

    public void setPlayListener(ActionListener newAction) {
        setActionToButton(newAction, play);
    }

    public void setSettingsListener(ActionListener newAction) {
        setActionToButton(newAction, settings);
    }
}
