package bankingsystem2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class User_Profile extends Functions implements ActionListener{
    
    private final JFrame frame;
    
    JPanel borderPanel, northPanel, southPanel, westPanel, eastPanel, cenPanel,
            lgtPanel, bckPanel, infoPanel, butPanel;
    Labels titleLabel, fnLabel, mnLabel, lnLabel, unLabel,
            fnnLabel, mnnLabel, lnnLabel, unnLabel,
            accLabel, balLabel, cbalLabel;
    JComboBox accCBox;
    JButton lgtBtn, bckBtn, nxtBtn;
    GridLayout grid;
    
    User_Profile(){
        
        //Initialization
        frame = new JFrame("Profile");
        borderPanel = new JPanel();
        northPanel = new JPanel();
        southPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        cenPanel = new JPanel();
        lgtPanel = new JPanel();
        bckPanel = new JPanel();
        infoPanel = new JPanel();
        butPanel = new JPanel();
        lgtBtn = new Buttons("Logout",100,50,15);
        bckBtn = new Buttons("Back",80,50,15);
        nxtBtn = new Buttons("Create New Bank Account",370,30,14);
        titleLabel = new Labels("Profile",15);
        unLabel = new Labels("Username:",15);
        fnLabel = new Labels("First Name:",15);
        mnLabel = new Labels("Middle Name:",15);
        lnLabel = new Labels("Last Name:",15);
        accLabel = new Labels("Bank Accounts:",15);
        balLabel = new Labels("Balance:",15);
        
        try{
            cbalLabel = new Labels(balanceAccounts[0],15);
        } catch (IndexOutOfBoundsException ex){
            cbalLabel = new Labels("0.00");
        } catch (NullPointerException ex){
            cbalLabel = new Labels("0.00");
        }
        
        unnLabel = new Labels(username,15);
        fnnLabel = new Labels(firstname,15);
        mnnLabel = new Labels(middlename,15);
        lnnLabel = new Labels(lastname,15);
        accCBox = new JComboBox(getAccounts());
        grid = new GridLayout(6,2);
        
        //Layout
        borderPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        cenPanel.setLayout(new FlowLayout());
        infoPanel.setLayout(grid);
        grid.setVgap(20);
        
        //Size
        northPanel.setPreferredSize(new Dimension(0, 60));
        southPanel.setPreferredSize(new Dimension(0, 40));
        westPanel.setPreferredSize(new Dimension(100, 0));
        eastPanel.setPreferredSize(new Dimension(100, 0));
        lgtPanel.setPreferredSize(new Dimension(100, 0));
        bckPanel.setPreferredSize(new Dimension(80, 0));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        infoPanel.setPreferredSize(new Dimension(370, 400));
        accCBox.setPreferredSize(new Dimension(300, 40));
        
        //Color
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);
        westPanel.setBackground(Color.WHITE);
        eastPanel.setBackground(Color.WHITE);
        cenPanel.setBackground(Color.WHITE);
        lgtPanel.setBackground(Color.BLACK);
        bckPanel.setBackground(Color.BLACK);
        infoPanel.setBackground(Color.WHITE);
        accCBox.setBackground(Color.WHITE);
        accCBox.setForeground(Color.BLACK);
        butPanel.setBackground(Color.WHITE);
        
        //Buttons // ComboBox
        lgtBtn.addActionListener(this);
        bckBtn.addActionListener(this);
        lgtBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        bckBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        accCBox.setSelectedIndex(0);
        accCBox.addActionListener(this);
        nxtBtn.addActionListener(this);
        
        //Border
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        accCBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        butPanel.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        
        //Font
        accCBox.setFont(new Font("Comic Sans", Font.BOLD, 14));
        
        //Extra
        accCBox.setFocusable(false);
        
        //Integration
        bckPanel.add(bckBtn);
        lgtPanel.add(lgtBtn);
        northPanel.add(lgtPanel, BorderLayout.EAST);
        northPanel.add(bckPanel, BorderLayout.WEST);
        northPanel.add(titleLabel, BorderLayout.CENTER);
        infoPanel.add(unLabel);
        infoPanel.add(unnLabel);
        infoPanel.add(fnLabel);
        infoPanel.add(fnnLabel);
        infoPanel.add(mnLabel);
        infoPanel.add(mnnLabel);
        infoPanel.add(lnLabel);
        infoPanel.add(lnnLabel);
        infoPanel.add(accLabel);
        infoPanel.add(accCBox);
        infoPanel.add(balLabel);
        infoPanel.add(cbalLabel);
        cenPanel.add(infoPanel);
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
            
        }else if(e.getSource() == accCBox){
            
            int account = accCBox.getSelectedIndex();
            
            for(int i = 0; i <= accCBox.getItemCount(); i++){
                if(account == i){
                    cbalLabel.setText(balanceList.get(i));
                }
            }
            
        }else if(e.getSource() == nxtBtn){
            
            try {
                int idAccCounter = 0;
                String getAccNum, generateAccNum;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(User_Profile.class.getName()).log(Level.SEVERE, null, ex);
                }
                Connection conn = null;
                conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "");
                getAccNum = "2022-" + (("000000" + String.valueOf(currID)).substring(String.valueOf(currID).length()));
                Statement stm = null;
                stm = conn.createStatement();
                // Get Balance
                // Sender query
                String query = "SELECT * FROM bankingsystem.account WHERE accnum LIKE '%"+ getAccNum + "%'";
                ResultSet rs = null;
                rs = stm.executeQuery(query);
                while(rs.next()){
                    
                    // DITO PASOK ACCOUNT ID NA MADEDETECT PLUS BALANCE
                    idAccCounter++;
                }   int nextCount = idAccCounter+1;
                generateAccNum = "2022-" + (("000000" + getAccNum + "-" + String.valueOf(nextCount)).substring(getAccNum.length()));
                System.out.println(generateAccNum);
                String query1 = " insert into bankingsystem.account (accnum, id_user, balance)" + "values (?, ?, ?)";
                PreparedStatement prepStm1 = null;
                prepStm1 = conn.prepareStatement(query1, stm.RETURN_GENERATED_KEYS);
                prepStm1.setString(1, generateAccNum);
                prepStm1.setInt(2, currID);
                prepStm1.setDouble(3, 0.0);
                prepStm1.execute();
                System.out.println("Bank Account Added");
                bankList.add(generateAccNum);
                balanceList.add("0.00");
                accCBox = new JComboBox(bankAccounts);
                frame.dispose();
                new User_Profile();
                
            } catch (SQLException ex) {
                Logger.getLogger(User_Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}