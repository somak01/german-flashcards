package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public abstract class Menu extends JPanel {
    protected JLabel title;
    public Menu() {
        title = new TitleLabel("Main menu");
        JLabel title2 = new TitleLabel("Pass auf!");
        add(title);
        add(title2);
        setBackground(new Color(164, 217, 208));
        setBounds(100, 100, 800, 800);
        title.setBounds(100, 100, 50, 50);
        System.out.println(title.getX());

    }
}
