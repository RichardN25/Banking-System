package bankingsystem2;

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

public class Admin_ShowBankAccount extends Functions implements ActionListener{
    
    private final JFrame frame;
    
    JPanel borderPanel, northPanel, southPanel, westPanel, eastPanel, cenPanel,
            lgtPanel, bckPanel, butPanel;
    JButton bckBtn;
    Labels titleLabel, accnumLabel, userLabel, balanceLabel, updated, created;
    EmptyBorder empty;
    CompoundBorder border;
    LineBorder rounded;
    JTextField accnumTField, userTField, balanceTField, updateTField, createTField;
    
    private int showId;
    
    Admin_ShowBankAccount(int showId){
        
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
        accnumLabel = new Labels("Account Number",15);
        userLabel = new Labels("Bank Account Owner",15);
        balanceLabel = new Labels("Balance",15);
        updated = new Labels("Last Updated",15);
        created = new Labels("Created At",15);
        accnumTField = new JTextField();
        userTField = new JTextField();
        balanceTField = new JTextField();
        updateTField = new JTextField();
        createTField = new JTextField();
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
        accnumTField.setPreferredSize(new Dimension(300, 40));
        userTField.setPreferredSize(new Dimension(300, 40));
        balanceTField.setPreferredSize(new Dimension(300, 40));
        updateTField.setPreferredSize(new Dimension(300, 40));
        createTField.setPreferredSize(new Dimension(300, 40));

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
        accnumTField.setForeground(Color.BLACK);
        userTField.setForeground(Color.BLACK);
        balanceTField.setForeground(Color.BLACK);
        updateTField.setForeground(Color.BLACK);
        createTField.setForeground(Color.BLACK);
        
        //Buttons
        bckBtn.addActionListener(this);
        
        //Border
        bckBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        accnumLabel.setBorder(BorderFactory.createEmptyBorder(45,0,5,185));
        userLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,153));
        balanceLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,245));
        updated.setBorder(BorderFactory.createEmptyBorder(5,0,5,205));
        created.setBorder(BorderFactory.createEmptyBorder(5,0,5,225));
        butPanel.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        accnumTField.setBorder(border);
        userTField.setBorder(border);
        balanceTField.setBorder(border);
        updateTField.setBorder(border);
        createTField.setBorder(border);
        
        //Editable
        accnumTField.setEditable(false);
        userTField.setEditable(false);
        balanceTField.setEditable(false);
        updateTField.setEditable(false);
        createTField.setEditable(false);
        
        //Font
        accnumTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        userTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        balanceTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        updateTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        createTField.setFont(new Font("Comic Sans", Font.BOLD, 14));
        
        //Fetch User Info
        try {
            query = "SELECT * FROM ACCOUNT WHERE ID = " + showId + "";
            rs = stm.executeQuery(query);
            rs.next();

            accnumTField.setText(rs.getString("accnum"));
            balanceTField.setText(rs.getString("balance"));
            updateTField.setText(rs.getString("updated_at"));
            createTField.setText(rs.getString("created_at"));
            
            query = "SELECT firstname, lastname FROM users WHERE ID = " + rs.getInt("id_user") + "";
            rs = stm.executeQuery(query);
            rs.next();
            
            userTField.setText(rs.getString("lastname") + ", " + rs.getString("firstname"));
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Integration
        bckPanel.add(bckBtn);
        northPanel.add(lgtPanel, BorderLayout.EAST);
        northPanel.add(bckPanel, BorderLayout.WEST);
        northPanel.add(titleLabel, BorderLayout.CENTER);
        cenPanel.add(accnumLabel);
        cenPanel.add(accnumTField);
        cenPanel.add(userLabel);
        cenPanel.add(userTField);
        cenPanel.add(balanceLabel);
        cenPanel.add(balanceTField);
        cenPanel.add(updated);
        cenPanel.add(updateTField);
        cenPanel.add(created);
        cenPanel.add(createTField);
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
            new Admin_BankAccounts();
            
        }
    }
}