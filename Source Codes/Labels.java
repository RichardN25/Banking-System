package bankingsystem;

import java.awt.Font;
import javax.swing.JLabel;

public class Labels extends JLabel{
    Labels() {
        setFont(new Font("Comic Sans", Font.BOLD, 18));
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
    }
    
    Labels(String name) {
        setText(name);
        setFont(new Font("Comic Sans", Font.BOLD, 18));
    }
    
    Labels(String name, int size) {
        setText(name);
        setFont(new Font("Comic Sans", Font.BOLD, size));
    }
}