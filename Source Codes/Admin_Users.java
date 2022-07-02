package bankingsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Admin_Users implements ActionListener{
    private JFrame frame;
    JPanel northPanel, northWestPanel, northEastPanel, centerPanel, centerEastPanel,
             centerWestPanel, tablePanel, buttonsPanel, gridPanel, userLabelPanel;
    JLabel userLabel;
    JLabel arr[] = new Labels[77];
    JButton next, prev, back;
    Icon backIcon;
    
    ArrayList<String> users = new ArrayList<>();
    int indexDisp = 0;
    
    Color color1  = new Color(20, 30, 39);
    Color color2  = new Color(228, 88, 38);
    
    Admin_Users() {
        frame = new JFrame("Users");
        northPanel = new JPanel();
        northWestPanel = new JPanel();
        northEastPanel = new JPanel();
        centerPanel = new JPanel();
        centerEastPanel = new JPanel();
        centerWestPanel = new JPanel();
        tablePanel = new JPanel();
        buttonsPanel = new JPanel();
        gridPanel = new JPanel();
        userLabel = new Labels("USERS",30);
        userLabelPanel = new JPanel();
        next = new Buttons("Next");
        prev = new Buttons("Previous");
//        backIcon = new ImageIcon("imgs/back2.png");
        back = new JButton("Back");
        
        back.setBackground(Color.green);
        back.setFocusable(false);
//        back.setContentAreaFilled(false);
//        back.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
        back.setPreferredSize(new Dimension(75,70));
        back.addActionListener(this);

        next.setFocusable(false);
        prev.setFocusable(false);
        prev.setPreferredSize(new Dimension(335,45));
        next.setPreferredSize(new Dimension(335,45));
        next.addActionListener(this);
        prev.addActionListener(this);
        prev.setEnabled(false);
                
        gridPanel.setLayout(new GridLayout(7,11));
        gridPanel.setBorder(new LineBorder(Color.WHITE));

        tablePanel.setLayout(new BorderLayout());
        tablePanel.setSize(700,500);
        gridPanel.setBackground(new Color(0,0,0));
        
        buttonsPanel.setPreferredSize(new Dimension(700,50));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(2,0,0,0));
        
        int count = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            Statement stm = con.createStatement();

            String query = "SELECT ID, USERNAME, FIRSTNAME, MIDDLENAME, LASTNAME, ROLE, UPDATED_AT, CREATED_AT FROM USERS ORDER BY ID ASC";
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()){
                users.add(Integer.toString(rs.getInt("id")));
                users.add(rs.getString("username"));
                users.add(rs.getString("firstname"));
                users.add(rs.getString("middlename"));
                users.add(rs.getString("lastname"));
                users.add(rs.getString("role"));
                users.add(rs.getString("updated_at"));
                users.add(rs.getString("created_at"));
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(indexDisp < users.size()){
            next.setEnabled(true);
        }
        else{
            next.setEnabled(false);
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Labels();
            arr[i].setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
            arr[i].setOpaque(true);
            gridPanel.add(arr[i]);
        }
        
//        for(int i = 0; i < 77; i++){
//            if(i % 11 == 0){
//                if(i == 0){
//                    arr[i].setText("ID");
//                }
//                else{
//                    arr[i].setText(users.get(i-4));
//                }
//            }
//        }
        
        buttonsPanel.setBackground(color1); //BUTTONS PANEL SOUTH
        buttonsPanel.setPreferredSize(new Dimension(0,100));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        buttonsPanel.add(prev);
        buttonsPanel.add(next);
        
        //Size customization
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(1500,130));
        
        northWestPanel.setPreferredSize(new Dimension(100,75));
        northWestPanel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        
        northEastPanel.setPreferredSize(new Dimension(1400,75)); //TOP PANEL
        northEastPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,90));
        
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        
        centerWestPanel.setPreferredSize(new Dimension(100,0));
        centerWestPanel.setBackground(color1); //LEFT PANEL
        
        centerEastPanel.setBackground(color1); // RIGHT PANEL
        centerEastPanel.setPreferredSize(new Dimension(100,0));
        
        northWestPanel.setBackground(color1); // BACK BUTTON PANEL
        northEastPanel.setBackground(color1); // TOP LABEL PANEL
        
        userLabelPanel.add(userLabel); //Title Panel
        userLabelPanel.setBackground(color2);
        userLabelPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        
        userLabel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        userLabel.setForeground(Color.white);
        
        //Integration of the components into the frame
        centerPanel.add(centerWestPanel, BorderLayout.WEST);
        centerPanel.add(centerEastPanel, BorderLayout.EAST);
        centerPanel.add(tablePanel, BorderLayout.CENTER);
        tablePanel.add(buttonsPanel, BorderLayout.SOUTH);
        tablePanel.add(gridPanel, BorderLayout.CENTER);
        northEastPanel.add(userLabelPanel);
        northWestPanel.add(back);
        northPanel.add(northWestPanel, BorderLayout.WEST);
        northPanel.add(northEastPanel, BorderLayout.EAST);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        
        //Frame attributes
        frame.setSize(1500,700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
