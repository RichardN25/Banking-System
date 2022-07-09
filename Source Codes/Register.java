package bankingsystem2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Register extends Variables implements ActionListener{
    
    private final JFrame frame;
    
    JPanel borderPanel, northPanel, southPanel, westPanel, eastPanel, cenPanel,
            lgtPanel, bckPanel, butPanel;
    JButton bckBtn, nxtBtn;
    Labels titleLabel, fnLabel, mnLabel, lnLabel, unLabel, pwLabel, cpLabel;
    EmptyBorder empty;
    CompoundBorder border;
    LineBorder rounded;
    JTextField fnTField, mnTField, lnTField, unTField, pwTField, cpTField;
    
    Register(){
        
        //Initialization
        frame = new JFrame("Register");
        borderPanel = new JPanel();
        northPanel = new JPanel();
        southPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        cenPanel = new JPanel();
        lgtPanel = new JPanel();
        bckPanel = new JPanel();
        butPanel = new JPanel();
        bckBtn = new Buttons("Back",80,50,15);
        nxtBtn = new Buttons("Proceed",160,30,14);
        titleLabel = new Labels("Register",15);
        fnLabel = new Labels("First Name",15);
        mnLabel = new Labels("Middle Name",15);
        lnLabel = new Labels("Last Name",15);
        unLabel = new Labels("Username",15);
        pwLabel = new Labels("Password",15);
        cpLabel = new Labels("Confirm Password",15);
        fnTField = new JTextField();
        mnTField = new JTextField();
        lnTField = new JTextField();
        unTField = new JTextField();
        pwTField = new JTextField();
        cpTField = new JTextField();
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
        fnTField.setPreferredSize(new Dimension(300, 40));
        mnTField.setPreferredSize(new Dimension(300, 40));
        lnTField.setPreferredSize(new Dimension(300, 40));
        unTField.setPreferredSize(new Dimension(300, 40));
        pwTField.setPreferredSize(new Dimension(300, 40));
        cpTField.setPreferredSize(new Dimension(300, 40));
        
        //Color
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);
        westPanel.setBackground(Color.WHITE);
        eastPanel.setBackground(Color.WHITE);
        cenPanel.setBackground(Color.WHITE);
        lgtPanel.setBackground(Color.BLACK);
        bckPanel.setBackground(Color.BLACK);
        butPanel.setBackground(Color.WHITE);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        fnTField.setForeground(Color.BLACK);
        mnTField.setForeground(Color.BLACK);
        lnTField.setForeground(Color.BLACK);
        unTField.setForeground(Color.BLACK);
        pwTField.setForeground(Color.BLACK);
        cpTField.setForeground(Color.BLACK);
        
        //Buttons
        bckBtn.addActionListener(this);
        nxtBtn.addActionListener(this);
        
        //Border
        bckBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        fnLabel.setBorder(BorderFactory.createEmptyBorder(30,0,5,225));
        mnLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,210));
        lnLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,225));
        unLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,225));
        pwLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,230));
        cpLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,170));
        butPanel.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        fnTField.setBorder(border);
        mnTField.setBorder(border);
        lnTField.setBorder(border);
        unTField.setBorder(border);
        pwTField.setBorder(border);
        cpTField.setBorder(border);
        
        //Font
        fnTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        mnTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        lnTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        unTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        pwTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        cpTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        
        //Integration
        bckPanel.add(bckBtn);
        northPanel.add(lgtPanel, BorderLayout.EAST);
        northPanel.add(bckPanel, BorderLayout.WEST);
        northPanel.add(titleLabel, BorderLayout.CENTER);
        cenPanel.add(fnLabel);
        cenPanel.add(fnTField);
        cenPanel.add(mnLabel);
        cenPanel.add(mnTField);
        cenPanel.add(lnLabel);
        cenPanel.add(lnTField);
        cenPanel.add(unLabel);
        cenPanel.add(unTField);
        cenPanel.add(pwLabel);
        cenPanel.add(pwTField);
        cenPanel.add(cpLabel);
        cenPanel.add(cpTField);
        butPanel.add(nxtBtn);
        cenPanel.add(butPanel);
        borderPanel.add(northPanel, BorderLayout.NORTH);
        borderPanel.add(southPanel, BorderLayout.SOUTH);
        borderPanel.add(westPanel, BorderLayout.WEST);
        borderPanel.add(eastPanel, BorderLayout.EAST);
        borderPanel.add(cenPanel, BorderLayout.CENTER);
        frame.add(borderPanel);
        
        //Frame attributes
        frame.setSize(600,750);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bckBtn){
            
            new Login();
            frame.dispose();
            
        }else if(e.getSource() == nxtBtn){
            
            System.out.println("Register");
            System.out.println("First Name        " + fnTField.getText());
            System.out.println("Middle Name       " + mnTField.getText());
            System.out.println("Last Name         " + lnTField.getText());
            System.out.println("Username          " + unTField.getText());
            System.out.println("Password          " + pwTField.getText());
            System.out.println("Confirm Password  " + cpTField.getText());
            
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Database is connected !");

                stm = conn.createStatement();
                // User Database
                query = " insert into bankingsystem.users (username, firstname, middlename, lastname, password, role)" + "values (?, ?, ?, ?, ?, ?)";

                PreparedStatement prepStm = conn.prepareStatement(query, stm.RETURN_GENERATED_KEYS);

                prepStm.setString(1, unTField.getText());
                prepStm.setString(2, fnTField.getText());
                prepStm.setString(3, mnTField.getText());
                prepStm.setString(4, lnTField.getText());
                prepStm.setString(5, pwTField.getText());
                prepStm.setString(6, "user");
                prepStm.execute();

                // Bank Account Database

                // Get ID
                String currID = null;
                String generateAccNum;
                double bal = 0;
                String getId = "SELECT id FROM bankingsystem.users WHERE username = '"+ unTField.getText() + "' and password  = '" + pwTField.getText() + "'";
                ResultSet rs = stm.executeQuery(getId);

                if(rs.next()){
                    currID = String.valueOf(rs.getInt("id"));
                }

                // ACCNUM GENERATOR
                generateAccNum = "2022-" + (("000000" + currID + "-1").substring(currID.length()));

                System.out.println(("000000" + currID).substring(currID.length()));
                String query1 = "insert into bankingsystem.account (accnum, id_user, balance)" + "values (?, ?, ?)";

                PreparedStatement prepStm1 = conn.prepareStatement(query1, stm.RETURN_GENERATED_KEYS);

                prepStm1.setString(1, generateAccNum);
                prepStm1.setString(2, currID);
                prepStm1.setDouble(3, bal);

                prepStm1.execute();

            }catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            frame.dispose();
            new Login();
        }
    }
}