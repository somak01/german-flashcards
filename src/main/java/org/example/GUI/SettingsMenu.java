package org.example.GUI;

import org.example.MODEL.WordType;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SettingsMenu extends Menu{
    private final JButton back = new JButton("Back");
    private final BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
    private final JComboBox womboCombo = new JComboBox<>(setOptions());
    private final JLabel type = new JLabel("Type:");
    public SettingsMenu() {
        super("Settings");
        setLayout(layout);
        add(title);
        add(Box.createRigidArea(new Dimension(1, 200)));
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        type.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(type);
        womboCombo.setMinimumSize(new Dimension(100, 50));
        womboCombo.setMaximumSize(new Dimension(100, 50));
        womboCombo.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        womboCombo.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        add(womboCombo);
        add(Box.createRigidArea(new Dimension(1, 200)));
        back.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        back.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        add(back);
    }

    public void setBackBtnActionListener(ActionListener newAction) {
        setActionToButton(newAction, back);
    }

    public String getWordType() {
        System.out.println((String)womboCombo.getSelectedItem());
        return (String)womboCombo.getSelectedItem();
    }

    private static String[] setOptions() {
        List<String> list =  new LinkedList<>();
        list.add("Default");
        list.addAll(Arrays.stream(WordType.wordTypes()).toList());
        return list.toArray(String[]::new);
    }


}
