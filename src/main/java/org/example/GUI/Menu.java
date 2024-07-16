package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Menu extends JPanel {
    protected final TitleLabel title = new TitleLabel();
    private Color baseColor = new Color(164, 217, 208);
    private Dimension size = new Dimension(800, 800);
    public Menu(String titleText) {
        setBackground(baseColor);
        title.setText(titleText);
        setMinimumSize(size);
        setSize(size);
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


    public Color getBaseColor() {
        return this.baseColor;
    }

}
