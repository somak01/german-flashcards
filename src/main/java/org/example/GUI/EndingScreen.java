package org.example.GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EndingScreen extends JOptionPane {
    private final JButton okButton = new JButton("OK");
    private final JPanel panel = new JPanel();
    private final JButton restartButton = new JButton("Restart");
    private final JLabel result = new JLabel();
    public EndingScreen() {
        add(panel);
        panel.add(result);
        panel.add(okButton);
        panel.add(restartButton);
        setSize(500, 500);
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
        result.setText(text);
    }

    public void setOkButtonActionListener(ActionListener newAction) {
        setListenerToButton(newAction, okButton);
    }
}
