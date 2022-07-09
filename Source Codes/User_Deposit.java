
package bankingsystem2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class User_Deposit extends Functions implements ActionListener{
    
    private final JFrame frame;
    
    JPanel borderPanel, northPanel, southPanel, westPanel, eastPanel, cenPanel,
            lgtPanel, bckPanel, butPanel;
    JButton lgtBtn, bckBtn, nxtBtn;
    Labels titleLabel, accLabel, amnLabel;
    EmptyBorder empty;
    CompoundBorder border;
    LineBorder rounded;
    JTextField amnTField;
    JComboBox accCBox;

    User_Deposit() {
        
        //Initialization
        frame = new JFrame("Deposit");
        borderPanel = new JPanel();
        northPanel = new JPanel();
        southPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        cenPanel = new JPanel();
        lgtPanel = new JPanel();
        bckPanel = new JPanel();
        butPanel = new JPanel();
        lgtBtn = new Buttons("Logout",100,50,15);
        bckBtn = new Buttons("Back",80,50,15);
        nxtBtn = new Buttons("Proceed",160,30,14);
        titleLabel = new Labels("Deposit",20);
        accLabel = new Labels("Account",20);
        amnLabel = new Labels("Amount ",20);
        amnTField = new JTextField();
        accCBox = new JComboBox(getAccounts());
        rounded = new LineBorder(Color.BLACK, 2, false);
        empty = new EmptyBorder(0, 5, 0, 0);
        border = new CompoundBorder(rounded, empty);
        
        //Layout
        borderPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        cenPanel.setLayout(new FlowLayout());
        
        //Size
        northPanel.setPreferredSize(new Dimension(0, 60));
        southPanel.setPreferredSize(new Dimension(0, 40));
        westPanel.setPreferredSize(new Dimension(100, 0));
        eastPanel.setPreferredSize(new Dimension(100, 0));
        lgtPanel.setPreferredSize(new Dimension(100, 0));
        bckPanel.setPreferredSize(new Dimension(100, 0));
        amnTField.setPreferredSize(new Dimension(300, 40));
        accCBox.setPreferredSize(new Dimension(300, 40));
        
        //Color
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);
        westPanel.setBackground(Color.WHITE);
        eastPanel.setBackground(Color.WHITE);
        cenPanel.setBackground(Color.WHITE);
        lgtPanel.setBackground(Color.BLACK);
        bckPanel.setBackground(Color.BLACK);
        amnTField.setForeground(Color.BLACK);
        accCBox.setBackground(Color.WHITE);
        accCBox.setForeground(Color.BLACK);
        butPanel.setBackground(Color.WHITE);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        //Buttons // CB
        nxtBtn.addActionListener(this);
        lgtBtn.addActionListener(this);
        bckBtn.addActionListener(this);
        //accCBox.setSelectedIndex(0);
        accCBox.addActionListener(this);
        
        //Border
        lgtBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        bckBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        accLabel.setBorder(BorderFactory.createEmptyBorder(120,0,10,220));
        amnLabel.setBorder(BorderFactory.createEmptyBorder(10,0,10,220));
        accCBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        amnTField.setBorder(border);
        butPanel.setBorder(BorderFactory.createEmptyBorder(40,0,0,0));
        
        //Font
        amnTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        accCBox.setFont(new Font("Comic Sans", Font.BOLD, 14));
        
        //Extra
        accCBox.setFocusable(false);
        
        //Integration
        bckPanel.add(bckBtn);
        lgtPanel.add(lgtBtn);
        northPanel.add(lgtPanel, BorderLayout.EAST);
        northPanel.add(bckPanel, BorderLayout.WEST);
        northPanel.add(titleLabel, BorderLayout.CENTER);
        cenPanel.add(accLabel);
        cenPanel.add(accCBox);
        cenPanel.add(amnLabel);
        cenPanel.add(amnTField);
        butPanel.add(nxtBtn);
        cenPanel.add(butPanel);
        borderPanel.add(northPanel, BorderLayout.NORTH);
        borderPanel.add(southPanel, BorderLayout.SOUTH);
        borderPanel.add(westPanel, BorderLayout.WEST);
        borderPanel.add(eastPanel, BorderLayout.EAST);
        borderPanel.add(cenPanel, BorderLayout.CENTER);
        frame.add(borderPanel);
        
        //Frame attributes
        frame.setSize(600,650);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == lgtBtn){
            
            frame.dispose();
            Logout();
            
        }else if(e.getSource() == bckBtn){
            
            frame.dispose();
            new User_Dashboard();
            
        }else if(e.getSource() == nxtBtn){
            setAccount(accCBox.getSelectedItem());
            depositFunc(accCBox.getSelectedItem(), amnTField.getText(), frame);
        }
        
    }
    
}
