package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Menu extends JPanel {
    protected final TitleLabel title = new TitleLabel();
    public Menu(String titleText) {
        setBackground(new Color(164, 217, 208));
        title.setText(titleText);
        setMinimumSize(new Dimension(800, 800));
        setSize(800, 800);
        System.out.println(title.getX());

    }
    protected void setActionToButton(ActionListener newAction, JButton btn) {
        if (newAction != null) {
            btn.addActionListener(newAction);
        } else throw new NullPointerException(btn.getClass().getName());
    }
    public void setTitleText(String text) {
        if (text != null) {
            title.setText(text);
        } else throw new NullPointerException("Title tried to be set to null");
    }

}
