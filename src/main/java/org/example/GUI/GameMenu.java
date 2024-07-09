package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameMenu extends Menu{
    private NextButton nb = new NextButton();
    private SubmitButton sb = new SubmitButton();
    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    public GameMenu() {
        super("Game");
        setLayout(layout);
        configureListeners();
        generaltConstraints();
        titleConstraints();
        add(title,constraints);
        nextAndSubmitConstraints();
        add(nb, constraints);
        nb.setVisible(false);
        add(sb, constraints);
    }

    private void setNextListener(ActionListener newAction) {
        setActionToButton(newAction, nb);
    }
    private void setSubmitListener(ActionListener newAction) {
        setActionToButton(newAction, sb);
    }

    private void configureListeners() {
        setNextListener(e -> {nb.setVisible(false);sb.setVisible(true);});
        setSubmitListener( e -> {sb.setVisible(false);nb.setVisible(true);});
    }
    private void generaltConstraints() {
        constraints.insets = new Insets(50, 100, 50, 100);
    }
    private void titleConstraints() {
        constraints.gridx = 2;
        constraints.gridy = 0;
    }

    private void nextAndSubmitConstraints() {
        constraints.gridx = 2;
        constraints.gridy = 2;
    }

}
