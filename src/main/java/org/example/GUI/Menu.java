package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public abstract class Menu extends JPanel {
    protected JLabel title;
    public Menu() {
        title = new TitleLabel("Hurensohn");
        add(title);
        setBackground(new Color(164, 217, 208));
        setMinimumSize(new Dimension(800, 800));
        setSize(800, 800);
        title.setBounds(100, 100, 50, 50);
        System.out.println(title.getX());

    }
}
