package org.example.GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SettingsMenu extends Menu{
    private final JButton back = new JButton("Back");
    public SettingsMenu() {
        super();
    }

    public void setBackBtnActionListener(ActionListener newAction) {
        if (newAction != null) {
            back.addActionListener(newAction);
        }
    }

}
