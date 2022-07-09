package bankingsystem2;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Labels extends JLabel{
    Labels() {
        setFont(new Font("Comic Sans", Font.BOLD, 15));
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setForeground(Color.BLACK);
    }
    
    Labels(String name) {
        setText(name);
        setFont(new Font("Comic Sans", Font.BOLD, 15));
    }
    
    Labels(String name, int size) {
        setText(name);
        setFont(new Font("Comic Sans", Font.BOLD, size));
        setForeground(Color.BLACK);
    }
}