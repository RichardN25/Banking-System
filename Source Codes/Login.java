package bankingsystem2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Login extends Functions implements ActionListener{

    private final JFrame frame;
    JPanel borderPanel, northPanel, southPanel, westPanel, eastPanel, cenPanel, butPanel;
    JTextField unTField;
    JPasswordField pwTField;
    Labels titleLabel, unLabel, pwLabel;
    EmptyBorder empty;
    CompoundBorder border;
    LineBorder rounded;
    JButton logBtn, regBtn;
    
    Login(){
        
        //Initialization
        frame = new JFrame("Login");
        borderPanel = new JPanel();
        northPanel = new JPanel();
        southPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        cenPanel = new JPanel();
        butPanel = new JPanel();
        titleLabel = new Labels("BankBed",70);
        unLabel = new Labels("Username",14);
        pwLabel = new Labels("Password",14);
        unTField = new JTextField();
        pwTField = new JPasswordField();
        rounded = new LineBorder(Color.BLACK, 2, false);
        empty = new EmptyBorder(0, 5, 0, 0);
        border = new CompoundBorder(rounded, empty);
        logBtn = new Buttons("Login",160,30,14);
        regBtn = new Buttons("Register",160,30,14);
        
        //Layout
        borderPanel.setLayout(new BorderLayout());
        cenPanel.setLayout(new FlowLayout());
        butPanel.setLayout(new FlowLayout());
        
        //Size
        unTField.setPreferredSize(new Dimension(260, 40));
        pwTField.setPreferredSize(new Dimension(260, 40));
        northPanel.setPreferredSize(new Dimension(0, 60));
        southPanel.setPreferredSize(new Dimension(0, 40));
        westPanel.setPreferredSize(new Dimension(140, 0));
        eastPanel.setPreferredSize(new Dimension(140, 0));
        butPanel.setPreferredSize(new Dimension(160, 70));
        
        //Color
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);
        westPanel.setBackground(Color.WHITE);
        eastPanel.setBackground(Color.WHITE);
        cenPanel.setBackground(Color.WHITE);
        butPanel.setBackground(Color.WHITE);
        unTField.setForeground(Color.BLACK);
        pwTField.setForeground(Color.BLACK);
        
        //Buttons
        logBtn.addActionListener(this);
        regBtn.addActionListener(this);
        
        //Border
        titleLabel.setBorder(BorderFactory.createEmptyBorder(40,0,30,0));
        unLabel.setBorder(BorderFactory.createEmptyBorder(10,0,10,188));
        pwLabel.setBorder(BorderFactory.createEmptyBorder(10,0,10,188));
        butPanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        unTField.setBorder(border);
        pwTField.setBorder(border);
        
        //Font
        unTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        pwTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        
        //Integration
        cenPanel.add(titleLabel);
        cenPanel.add(unLabel);
        cenPanel.add(unTField);
        cenPanel.add(pwLabel);
        cenPanel.add(pwTField);
        cenPanel.add(butPanel);
        butPanel.add(logBtn);
        cenPanel.add(regBtn);
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
        String uName, pass, generateAcNum;
        
        if(e.getSource() == logBtn){
            
            uName = unTField.getText();
            pass = pwTField.getText();
            
            try {
                query = "SELECT * FROM users WHERE username = '"+ uName + "' and password  = '" + pass + "'";
                rs = stm.executeQuery(query);
                
                if (rs.next()){
                    System.out.println("Logged in Successfully");

                    id = Integer.toString(rs.getInt("id"));
                    username = rs.getString("username");
                    firstname= rs.getString("firstname");
                    middlename = rs.getString("middlename");
                    lastname = rs.getString("lastname");
                    password = rs.getString("password");
                    role = rs.getString("role");
                    fullname = firstname + " " + lastname;
                    Variables.currID = rs.getInt("id");


                    // Get the list of Bank Accounts
                    
                    //generateAcNum = "2022-" + (("000000" +  String.valueOf(Variables.currID)).substring( String.valueOf(Variables.currID).length()));
                    //query = "SELECT * FROM account WHERE accnum LIKE '%"+ generateAcNum + "%'";
                    
                    query = "SELECT * FROM ACCOUNT WHERE ID_USER = " + id + "";
                    ResultSet bankResult = stm.executeQuery(query);
                    
                    while(bankResult.next()){

                        // DITO PASOK ACCOUNT ID NA MADEDETECT PLUS BALANCE
                        bankList.add(bankResult.getString("accnum"));
                        balanceList.add(String.valueOf(bankResult.getDouble("balance")));
                    }
                    
                    if(role.contains("admin")){
                        frame.dispose();
                        new Admin_Dashboard();
                    }
                    else{
                        frame.dispose();
                        new User_Dashboard();
                    }
                }
                else {
                    System.out.println("Invalid Username or Password");
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Invalid", JOptionPane.WARNING_MESSAGE);
                }
                
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == regBtn){
            
            frame.dispose();
            new Register();
            
        }
    }
}