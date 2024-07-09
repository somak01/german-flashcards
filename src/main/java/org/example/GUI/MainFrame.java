package org.example.GUI;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private final GridBagLayout layout = new GridBagLayout();
    private final TitleLabel title = new TitleLabel("German Flashcards");
    private final ContentPanel content = new ContentPanel();
    private final GridBagConstraints constraints = new GridBagConstraints();
    public MainFrame() {
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(125, 252, 225));
        setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        setGeneralConstraints();
        setTitleConstraints();
        add(title, constraints);
        setContentAreaConstraints();
        add(content, constraints);
        JPanel fasz = new JPanel();
        fasz.setBackground(Color.BLACK);
        setVisible(true);

    }
    private void setGeneralConstraints()  {
       constraints.insets = new Insets(50, 20 ,50, 20);
    }
    private void setTitleConstraints() {
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        constraints.gridx = 4;
        constraints.gridy = 0;
    }

    private void setContentAreaConstraints() {
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
//        constraints.ipadx = 800;
//        constraints.ipady = 800;

    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}

