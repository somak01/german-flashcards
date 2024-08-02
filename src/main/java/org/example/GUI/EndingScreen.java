package org.example.GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EndingScreen extends JOptionPane {
    private final JButton okButton = new JButton("OK");
    private final JPanel panel = new JPanel();
    private final JButton restartButton = new JButton("Restart");
    private final JLabel result = new JLabel();
    public EndingScreen() {
        setSize(500, 500);
        this.add(result);
        this.setOptions(new Object[] {okButton, restartButton});



    }
    private void setListenerToButton(ActionListener newAction, JButton button) {
        if (newAction != null) {
            button.addActionListener(newAction);
        } else throw new NullPointerException();
    }
    public void setRestartListener(ActionListener newAction) {
        setListenerToButton(newAction, restartButton);
    }
    public void setResultText(String text) {
        setMessage(text);
    }

    public void setOkButtonActionListener(ActionListener newAction) {
        setListenerToButton(newAction, okButton);
    }
}
