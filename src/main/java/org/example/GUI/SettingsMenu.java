package org.example.GUI;

import org.example.DB.WordSet;
import org.example.MODEL.WordType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SettingsMenu extends Menu{
    private final JButton back = new JButton("Back");
    private final BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
    private final JComboBox wordTypeCombo = new JComboBox<>(setOptions());
    private final JComboBox gameMode = new JComboBox(new String[]{"German-Hungarian", "Hungarian-German"});
    private final JComboBox lektion = new JComboBox(WordSet.lektionNums());
    private final Dimension comboBoxSize = new Dimension(100, 50);

    private final JLabel lektionLabel = new JLabel("Lektion(0 means all):");
    private final JLabel gameModeLabel = new JLabel("Gamemode:");
    private final JLabel typeLabel = new JLabel("Type:");
    public SettingsMenu() {
        super("Settings");
        setLayout(layout);
        add(title);
        add(Box.createRigidArea(new Dimension(1, 100)));
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        typeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(typeLabel);
        wordTypeCombo.setMinimumSize(comboBoxSize);
        wordTypeCombo.setMaximumSize(comboBoxSize);
        wordTypeCombo.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        wordTypeCombo.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        add(wordTypeCombo);
        add(Box.createRigidArea(new Dimension(1, 100)));
        lektion.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        lektion.setMinimumSize(comboBoxSize);
        lektion.setMaximumSize(comboBoxSize);
        lektionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(lektionLabel);
        add(lektion);

        add(Box.createRigidArea(new Dimension(1, 100)));
        gameMode.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        gameMode.setMinimumSize(comboBoxSize);
        gameMode.setMaximumSize(comboBoxSize);
        gameModeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(gameModeLabel);
        add(gameMode);

        add(Box.createRigidArea(new Dimension(1, 100)));
        back.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        back.setAlignmentY(JComponent.CENTER_ALIGNMENT);

        add(back);
    }

    public void setBackBtnActionListener(ActionListener newAction) {
        setActionToButton(newAction, back);
    }

    public String getWordType() {
        System.out.println((String) wordTypeCombo.getSelectedItem());
        return (String) wordTypeCombo.getSelectedItem();
    }

    private static String[] setOptions() {
        List<String> list =  new LinkedList<>();
        list.add("Default");
        list.addAll(Arrays.stream(WordType.wordTypes()).toList());
        return list.toArray(String[]::new);
    }

    public boolean isGermanToHungarian() {
        System.out.println((String)gameMode.getSelectedItem());
        System.out.println(((String)gameMode.getSelectedItem()).equals("German-Hungarian"));
        return ((String)gameMode.getSelectedItem()).equals("German-Hungarian");
    }


}
