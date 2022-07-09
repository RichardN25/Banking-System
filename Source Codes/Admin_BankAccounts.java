package bankingsystem2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Admin_BankAccounts extends Functions implements ActionListener{
    
    private JFrame frame;
    JPanel northPanel, northWestPanel, northEastPanel, centerPanel, centerEastPanel,
    centerWestPanel, tablePanel, buttonsPanel, gridPanel, userLabelPanel;
    JLabel userLabel;
    JLabel arr[] = new Labels[49];
    JButton nextBtn, prevBtn, backBtn;
    JButton options[] = new Buttons[12];
    GridLayout grid;
    
    ArrayList<String> accounts = new ArrayList<>();

    //counter Variables
    private int dataIndex;
    private int buttonIndex;
    private int pageIndex = 1;
    
    Admin_BankAccounts() {
        
        //Initialization
        frame = new JFrame("Bank Accounts");
        grid = new GridLayout(7,11);
        northPanel = new JPanel();
        northWestPanel = new JPanel();
        northEastPanel = new JPanel();
        centerPanel = new JPanel();
        centerEastPanel = new JPanel();
        centerWestPanel = new JPanel();
        tablePanel = new JPanel();
        buttonsPanel = new JPanel();
        gridPanel = new JPanel();
        userLabel = new Labels("Bank Accounts",30);
        userLabelPanel = new JPanel();
        nextBtn = new Buttons("Next");
        prevBtn = new Buttons("Previous");
        backBtn = new Buttons("Back");
        
        //RETRIEVE DATA FROM BANKING SYSTEM DATABASE
        try {
            query = "SELECT * FROM ACCOUNT ORDER BY ID ASC";
            rs = stm.executeQuery(query);

            while (rs.next()){
                accounts.add(Integer.toString(rs.getInt("id")));
                accounts.add(rs.getString("accnum"));
                accounts.add(Integer.toString(rs.getInt("id_user")));
                accounts.add(Float.toString(rs.getFloat("balance")));
                accounts.add(rs.getString("updated_at"));
                accounts.add(rs.getString("created_at"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //GREATER THAN 42 (FIRST 6 ENTRIES * PER DATA COLUMN)
        if(accounts.size() > 42){
            nextBtn.setEnabled(true);
        }
        else{
            nextBtn.setEnabled(false);
        }
        
        //PRELOAD TABLE && SET LABELS
            for (int i = 0; i < arr.length; i++){
                arr[i] = new Labels();
                arr[i].setBackground(Color.WHITE);
                arr[i].setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
                arr[i].setOpaque(true);
                gridPanel.add(arr[i]);
                
                if(i % 7 == 6){
                    if(i == 6){
                        arr[i].setText("OPTIONS");
                    }
                    else{
                        
                        options[buttonIndex + 0] = new Buttons("Show");
                        options[buttonIndex + 1] = new Buttons("Delete");

                        options[buttonIndex + 0].setBounds(5, 5, 170, 30);
                        options[buttonIndex + 1].setBounds(5, 35, 170, 30);
                        
                        options[buttonIndex + 0].addActionListener(this);
                        options[buttonIndex + 1].addActionListener(this);
                        
                        arr[i].setLayout(null);
                        arr[i].add(options[buttonIndex + 0]);
                        arr[i].add(options[buttonIndex + 1]);
                        
                        buttonIndex += 2; 
                    }
                }
            }
            buttonIndex = 0;
            
        //PRINT FIRST 6 ENTRIES FROM DATABASE
            for(int i = 0; i < arr.length; i++){
                if(i % 7 == 0){
                        //arr[i].setWidthcolumn PAANO MAGSET WIDTH NG COLUMN
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 1){
                   if(i == 1){
                        arr[i].setText("ACC. NO.");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 2){
                   if(i == 2){
                        arr[i].setText("ID USER");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 3){
                   if(i == 3){
                        arr[i].setText("BALANCE");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 4){
                   if(i == 4){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 5){
                   if(i == 5){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
                else if(i % 7 == 6){
                   if(i == 6){
                        arr[i].setText("OPTIONS");
                   }
                   else{ 
                        if(arr[i-6].getText().isEmpty() == false){
                           options[buttonIndex + 0].setVisible(true);
                           options[buttonIndex + 1].setVisible(true);
                           
                           buttonIndex += 2;
                        }
                        else{
                           arr[i].setText("");
                           options[buttonIndex + 0].setVisible(false);
                           options[buttonIndex + 1].setVisible(false);
                           
                           buttonIndex += 2;
                        }
                   }
                }
                arr[i].setBorder(new LineBorder(Color.BLACK));
            }
            
            buttonIndex = 0;
        
        //Layout
        grid.setHgap(2);
        grid.setVgap(2);
        gridPanel.setLayout(grid);
        tablePanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());
        
        //Size
        tablePanel.setSize(700,500);
        buttonsPanel.setPreferredSize(new Dimension(700,50));
        buttonsPanel.setPreferredSize(new Dimension(0,100));
        northPanel.setPreferredSize(new Dimension(1500,130));
        northWestPanel.setPreferredSize(new Dimension(100,50));
        northEastPanel.setPreferredSize(new Dimension(1400,75));
        centerWestPanel.setPreferredSize(new Dimension(100,0));
        centerEastPanel.setPreferredSize(new Dimension(100,0));
        
        //Color
        gridPanel.setBackground(Color.BLACK);
        buttonsPanel.setBackground(Color.WHITE);
        centerPanel.setBackground(Color.WHITE);
        centerWestPanel.setBackground(Color.WHITE);
        centerEastPanel.setBackground(Color.WHITE);
        northWestPanel.setBackground(Color.BLACK);
        northEastPanel.setBackground(Color.BLACK);
        userLabelPanel.setBackground(Color.BLACK);
        userLabel.setForeground(Color.WHITE);
        
        //Border
        gridPanel.setBorder(new LineBorder(Color.WHITE));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        northWestPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        northEastPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,90));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        userLabelPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        userLabel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        
        //Buttons
        backBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        nextBtn.setPreferredSize(new Dimension(335,45));
        backBtn.setPreferredSize(new Dimension(75,70));
        prevBtn.setPreferredSize(new Dimension(335,45));
        nextBtn.addActionListener(this);
        backBtn.addActionListener(this);
        prevBtn.addActionListener(this);
        nextBtn.setFocusable(false);
        backBtn.setFocusable(false);
        prevBtn.setFocusable(false);
        prevBtn.setEnabled(false);
        
        //Integration
        centerPanel.add(centerWestPanel, BorderLayout.WEST);
        centerPanel.add(centerEastPanel, BorderLayout.EAST);
        centerPanel.add(tablePanel, BorderLayout.CENTER);
        buttonsPanel.add(prevBtn);
        buttonsPanel.add(nextBtn);
        tablePanel.add(buttonsPanel, BorderLayout.SOUTH);
        tablePanel.add(gridPanel, BorderLayout.CENTER);
        userLabelPanel.add(userLabel);
        northEastPanel.add(userLabelPanel);
        northWestPanel.add(backBtn);
        northPanel.add(northWestPanel, BorderLayout.WEST);
        northPanel.add(northEastPanel, BorderLayout.EAST);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        
        //Frame attributes
        frame.setSize(1500,800);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        int option;
        
        if(ae.getSource() == options[0] || ae.getSource() == options[1]){
            if(ae.getSource() == options[0]){
                frame.dispose();
                new Admin_ShowBankAccount(Integer.valueOf(accounts.get(0 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[1]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc3(Integer.valueOf(accounts.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                }
            }
        }
        else if(ae.getSource() == options[2] || ae.getSource() == options[3]){
            if(ae.getSource() == options[2]){
                frame.dispose();
                new Admin_ShowBankAccount(Integer.valueOf(accounts.get(6 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[3]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc3(Integer.valueOf(accounts.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                }
            }
        }
        else if(ae.getSource() == options[4] || ae.getSource() == options[5]){
            if(ae.getSource() == options[4]){
                frame.dispose();
                new Admin_ShowBankAccount(Integer.valueOf(accounts.get(12 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[5]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc3(Integer.valueOf(accounts.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                }
            }
        }
        else if(ae.getSource() == options[6] || ae.getSource() == options[7]){
            if(ae.getSource() == options[6]){
                frame.dispose();
                new Admin_ShowBankAccount(Integer.valueOf(accounts.get(18 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[7]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc3(Integer.valueOf(accounts.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                }
            }
        }
        else if(ae.getSource() == options[8] || ae.getSource() == options[9]){
            if(ae.getSource() == options[8]){
                frame.dispose();
                new Admin_ShowBankAccount(Integer.valueOf(accounts.get(24 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[9]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc3(Integer.valueOf(accounts.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                }
            }
        }
        else if(ae.getSource() == options[10] || ae.getSource() == options[11]){
            if(ae.getSource() == options[10]){
                frame.dispose();
                new Admin_ShowBankAccount(Integer.valueOf(accounts.get(30 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[11]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc3(Integer.valueOf(accounts.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                }
            }
        }
        
        if(ae.getSource() == nextBtn){
            //PREV NEXT LOGIC
            pageIndex++;
            prevBtn.setEnabled(true);
            
            if(pageIndex == 1 && accounts.size() > 42){
                nextBtn.setEnabled(true);
            }
            else if(accounts.size() > 42 * (pageIndex)){
                nextBtn.setEnabled(true);
            }
            else{
                nextBtn.setEnabled(false);
            }
            
            for(int i = 0; i < arr.length; i++){
                if(i % 7 == 0){
                        //arr[i].setWidthcolumn PAANO MAGSET WIDTH NG COLUMN
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 1){
                   if(i == 1){
                        arr[i].setText("ACC. NO.");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 2){
                   if(i == 2){
                        arr[i].setText("ID USER");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 3){
                   if(i == 3){
                        arr[i].setText("BALANCE");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 4){
                   if(i == 4){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 5){
                   if(i == 5){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
                else if(i % 7 == 6){
                   if(i == 6){
                        arr[i].setText("OPTIONS");
                   }
                   else{ 
                        if(arr[i-6].getText().isEmpty() == false){
                           options[buttonIndex + 0].setVisible(true);
                           options[buttonIndex + 1].setVisible(true);
                           options[buttonIndex + 2].setVisible(true);
                           
                           buttonIndex += 3;
                        }
                        else{
                           arr[i].setText("");
                           options[buttonIndex + 0].setVisible(false);
                           options[buttonIndex + 1].setVisible(false);
                           options[buttonIndex + 2].setVisible(false);
                           
                           buttonIndex += 3;
                        }
                   }
                }
                arr[i].setBorder(new LineBorder(Color.BLACK));
            }
            buttonIndex = 0;
        }
        else if(ae.getSource() == prevBtn){
            
            //PREV NEXT LOGIC
            dataIndex = dataIndex - (42 + (42 - ((42 * pageIndex) - dataIndex)));
            
            pageIndex--;
            
            if(pageIndex == 1){
                nextBtn.setEnabled(true);
                prevBtn.setEnabled(false);
            }
            else{
                prevBtn.setEnabled(true);
            }
            
            for(int i = 0; i < arr.length; i++){
                if(i % 7 == 0){
                        //arr[i].setWidthcolumn PAANO MAGSET WIDTH NG COLUMN
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 1){
                   if(i == 1){
                        arr[i].setText("ACC. NO.");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 2){
                   if(i == 2){
                        arr[i].setText("ID USER");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 3){
                   if(i == 3){
                        arr[i].setText("BALANCE");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 4){
                   if(i == 4){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 7 == 5){
                   if(i == 5){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(accounts.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
                else if(i % 7 == 6){
                   if(i == 6){
                        arr[i].setText("OPTIONS");
                   }
                   else{ 
                        if(arr[i-6].getText().isEmpty() == false){
                           options[buttonIndex + 0].setVisible(true);
                           options[buttonIndex + 1].setVisible(true);
                           options[buttonIndex + 2].setVisible(true);
                           
                           buttonIndex += 3;
                        }
                        else{
                           arr[i].setText("");
                           options[buttonIndex + 0].setVisible(false);
                           options[buttonIndex + 1].setVisible(false);
                           options[buttonIndex + 2].setVisible(false);
                           
                           buttonIndex += 3;
                        }
                   }
                }
                arr[i].setBorder(new LineBorder(Color.BLACK));
            }
            buttonIndex = 0;
        }
        else if(ae.getSource() == backBtn){
            frame.dispose();
            new Admin_Dashboard();
        }
    }
}