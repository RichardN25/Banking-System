package bankingsystem2;

import static bankingsystem2.Variables.fullname;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Admin_Dashboard extends Variables implements ActionListener{
    
    String greetings = fullname+"!";
    
    private final JFrame frame;
    JPanel borderPanel, northPanel, southPanel, westPanel, eastPanel, cenPanel,
            grtPanel, butPanel, lgtPanel;
    Labels grtLabel, namLabel;
    JButton userBtn, baccBtn, tranBtn, lgtBtn;
    GridLayout grid;
    
    Admin_Dashboard(){
        frame = new JFrame("Admin Dashboard");
        borderPanel = new JPanel();
        northPanel = new JPanel();
        southPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        cenPanel = new JPanel();
        grtPanel = new JPanel();
        butPanel = new JPanel();
        lgtPanel = new JPanel();
        grtLabel = new Labels("Hi, ",25);
        namLabel = new Labels(greetings,40);
        userBtn = new Buttons("Users",370,50,15);
        baccBtn = new Buttons("Bank Accounts",370,50,15);
        tranBtn = new Buttons("Transactions",370,50,15);
        lgtBtn = new Buttons("Logout",100,50,15);
        grid = new GridLayout(5,1);
        
        //Layout
        borderPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        cenPanel.setLayout(new FlowLayout());
        grtPanel.setLayout(new BoxLayout(grtPanel, BoxLayout.PAGE_AXIS));
        butPanel.setLayout(grid);
        grid.setVgap(30);
        
        //Size
        northPanel.setPreferredSize(new Dimension(0, 60));
        southPanel.setPreferredSize(new Dimension(0, 40));
        westPanel.setPreferredSize(new Dimension(100, 0));
        eastPanel.setPreferredSize(new Dimension(100, 0));
        grtPanel.setPreferredSize(new Dimension(370, 150));
        lgtPanel.setPreferredSize(new Dimension(100, 0));
        
        //Color
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);
        westPanel.setBackground(Color.WHITE);
        eastPanel.setBackground(Color.WHITE);
        cenPanel.setBackground(Color.WHITE);
        grtPanel.setBackground(Color.WHITE);
        butPanel.setBackground(Color.WHITE);
        lgtPanel.setBackground(Color.BLACK);
        
        //Buttons
        userBtn.addActionListener(this);
        baccBtn.addActionListener(this);
        tranBtn.addActionListener(this);
        lgtBtn.addActionListener(this);
        lgtBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        butPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        
        //Border
        grtPanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        
        //Integration
        grtPanel.add(grtLabel);
        grtPanel.add(namLabel);
        cenPanel.add(grtPanel);
        butPanel.add(userBtn);
        butPanel.add(baccBtn);
        butPanel.add(tranBtn);
        cenPanel.add(butPanel);
        lgtPanel.add(lgtBtn);
        northPanel.add(lgtPanel, BorderLayout.EAST);
        borderPanel.add(northPanel, BorderLayout.NORTH);
        borderPanel.add(southPanel, BorderLayout.SOUTH);
        borderPanel.add(westPanel, BorderLayout.WEST);
        borderPanel.add(eastPanel, BorderLayout.EAST);
        borderPanel.add(cenPanel, BorderLayout.CENTER);
        frame.add(borderPanel);
        
        //Frame attributes
        frame.setSize(600,700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == userBtn){
            
            frame.dispose();
            new Admin_Users();
            
        }else if(e.getSource() == baccBtn){
            
            frame.dispose();
            new Admin_BankAccounts();
            
        }else if(e.getSource() == tranBtn){
            
            frame.dispose();
            new Admin_Transactions();
            
        }else if(e.getSource() == lgtBtn){
            
            frame.dispose();
            Logout();
            
        }
    }
    
}
