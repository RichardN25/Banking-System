package bankingsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Buttons extends JButton{
    
    Buttons(String name) {
        setText(name);
        setFont(new Font("Arial",Font.BOLD,15));
        setBackground(new Color(228, 88, 38));
        setForeground(Color.white);
        setFocusable(false);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }
    
    Buttons(String name, int width, int height) {
        setText(name);
        setFont(new Font("Arial",Font.BOLD,24));
        setBackground(new Color(228, 88, 38));
        setForeground(Color.white);
        setFocusable(false);
        setPreferredSize(new Dimension(width,height));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }
    
    Buttons(String name, int width, int height, int fontSize) {
        setText(name);
        setFont(new Font("Arial",Font.BOLD,fontSize));
        setBackground(new Color(228, 88, 38));
        setForeground(Color.white);
        setFocusable(false);
        setPreferredSize(new Dimension(width,height));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }
}