package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class TitleLabel extends JLabel {
    public TitleLabel() {
        this("");
    }
    public TitleLabel(String title) {
        super(title);
        try  (InputStream input = TitleLabel.class.getClassLoader().getResourceAsStream("Fonts/RobotoMono.ttf")){
            Font fnt = Font.createFont(Font.TRUETYPE_FONT, input);
            Font sized = fnt.deriveFont(35f).deriveFont(Font.BOLD);
            setFont(sized);
        } catch (IOException e) {
            System.err.println("valami baj van a filelal");
            System.exit(1);
        } catch (FontFormatException fe) {
            System.err.println("Valami baj van a font formattal");
            System.exit(1);
        }

    }
}
