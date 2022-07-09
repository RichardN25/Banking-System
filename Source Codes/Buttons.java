package bankingsystem2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class Buttons extends JButton{
    
    Buttons(String name) {
        setText(name);
        setFont(new Font("Arial",Font.BOLD,14));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusable(false);
    }
    
    Buttons(String name, int width, int height) {
        setText(name);
        setFont(new Font("Arial",Font.BOLD,24));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusable(false);
        setPreferredSize(new Dimension(width,height));
    }
    
    Buttons(String name, int width, int height, int fontSize) {
        setText(name);
        setFont(new Font("Arial",Font.BOLD,fontSize));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusable(false);
        setPreferredSize(new Dimension(width,height));
    }
}