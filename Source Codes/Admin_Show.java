package bankingsystem2;

import static bankingsystem2.Variables.query;
import static bankingsystem2.Variables.rs;
import static bankingsystem2.Variables.stm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Admin_Show extends Functions implements ActionListener{
    
    private final JFrame frame;
    
    JPanel borderPanel, northPanel, southPanel, westPanel, eastPanel, cenPanel,
            lgtPanel, bckPanel, butPanel;
    JButton bckBtn;
    Labels titleLabel, fnLabel, mnLabel, lnLabel, unLabel, pwLabel;
    EmptyBorder empty;
    CompoundBorder border;
    LineBorder rounded;
    JTextField fnTField, mnTField, lnTField, unTField, pwTField;
    
    private int showId;
    
    Admin_Show(int showId){
        
        this.showId = showId;
        
        //Initialization
        frame = new JFrame("Show");
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
        titleLabel = new Labels("Show",15);
        fnLabel = new Labels("First Name",15);
        mnLabel = new Labels("Middle Name",15);
        lnLabel = new Labels("Last Name",15);
        unLabel = new Labels("Username",15);
        pwLabel = new Labels("Password",15);
        fnTField = new JTextField();
        mnTField = new JTextField();
        lnTField = new JTextField();
        unTField = new JTextField();
        pwTField = new JTextField();
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
        
        //Buttons
        bckBtn.addActionListener(this);
        
        //Border
        bckBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        fnLabel.setBorder(BorderFactory.createEmptyBorder(45,0,5,225));
        mnLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,210));
        lnLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,225));
        unLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,225));
        pwLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,230));
        butPanel.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        fnTField.setBorder(border);
        mnTField.setBorder(border);
        lnTField.setBorder(border);
        unTField.setBorder(border);
        pwTField.setBorder(border);
        
        //Editable
        fnTField.setEditable(false);
        mnTField.setEditable(false);
        lnTField.setEditable(false);
        unTField.setEditable(false);
        pwTField.setEditable(false);
        
        //Font
        fnTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        mnTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        lnTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        unTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        pwTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        
        //Fetch User Info
        try {
            query = "SELECT * FROM users WHERE ID = " + showId + "";
            rs = stm.executeQuery(query);
            rs.next();

            //Field Text Existing
            fnTField.setText(rs.getString("firstname"));
            mnTField.setText(rs.getString("middlename"));
            lnTField.setText(rs.getString("lastname"));
            unTField.setText(rs.getString("username"));
            pwTField.setText(rs.getString("password"));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        
        if(e.getSource() == bckBtn){
            
            frame.dispose();
            new Admin_Users();
            
        }
    }
}