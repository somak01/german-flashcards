package org.example.GUI;

import org.example.DB.WordSet;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        NextButton nb = new NextButton(this);
        add(nb);
        var wordList = WordSet.getVerbs();
        JLabel ge = new JLabel(wordList.get(0).getGerman());
        JLabel hu = new JLabel(wordList.get(0).getHungarian());
        ge.setBounds(120, 140, 350, 200);
        add(ge);
        hu.setBounds(540, 140, 350, 200);
        add(hu);
        hu.setVisible(false);
        setSize(1000, 1000);
        setLayout(null);
        getContentPane().setBackground(Color.getHSBColor(56f, 15f, 88f));
        setVisible(true);
        nb.addActionListener(e -> {
            if (e.getSource() == nb) {
                hu.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}

