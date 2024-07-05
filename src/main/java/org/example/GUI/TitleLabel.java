package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class TitleLabel extends JLabel {

    public TitleLabel(String title) {
        super(title);
        try  (InputStream input = TitleLabel.class.getClassLoader().getResourceAsStream("Fonts/RobotoMono.ttf")){
            Font fnt = Font.createFont(Font.TRUETYPE_FONT, input);
            Font sized = fnt.deriveFont(35f).deriveFont(Font.BOLD);
            setFont(sized);
            System.out.println(fnt.getClass());
        } catch (IOException e) {
            System.out.println("anyadat");
        } catch (FontFormatException fe) {
            System.out.println("faszom geci");
        }

    }

    public static void main(String[] args) {
        new TitleLabel("asd");
    }
}
