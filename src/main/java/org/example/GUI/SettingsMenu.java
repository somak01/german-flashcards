package org.example.GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SettingsMenu extends Menu{
    private final JButton back = new JButton("Back");
    private final BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
    public SettingsMenu() {
        super("Settings");
        setLayout(layout);
        add(title);
        add(back);
    }

    public void setBackBtnActionListener(ActionListener newAction) {
        setActionToButton(newAction, back);
    }

}
