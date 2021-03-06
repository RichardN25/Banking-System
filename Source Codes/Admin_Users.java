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

public class Admin_Users extends Functions implements ActionListener{
    private JFrame frame;
    JPanel northPanel, northWestPanel, northEastPanel, centerPanel, centerEastPanel,
    centerWestPanel, tablePanel, buttonsPanel, gridPanel, userLabelPanel;
    JLabel userLabel;
    JLabel arr[] = new Labels[63];
    JButton nextBtn, prevBtn, backBtn;
    JButton options[] = new Buttons[18];
    GridLayout grid;
    
    ArrayList<String> users = new ArrayList<>();
    
    //counter Variables
    private int dataIndex;
    private int buttonIndex;
    private int pageIndex = 1;
    
    Admin_Users() {
        
        frame = new JFrame("Users");
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
        userLabel = new Labels("Users",30);
        userLabelPanel = new JPanel();
        nextBtn = new Buttons("Next");
        prevBtn = new Buttons("Previous");
        backBtn = new Buttons("Back");
        
        //RETRIEVE DATA FROM BANKING SYSTEM DATABASE
        try {
            query = "SELECT * FROM USERS ORDER BY ID ASC";
            rs = stm.executeQuery(query);

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
        catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //GREATER THAN 48 (FIRST 6 ENTRIES * PER DATA COLUMN)
        if(users.size() > 48){
            nextBtn.setEnabled(true);
        }
        else{
            nextBtn.setEnabled(false);
        }
        
        //PRELOAD TABLE && SET LABELS
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new Labels();
                arr[i].setBackground(Color.WHITE);
                arr[i].setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
                arr[i].setOpaque(true);
                gridPanel.add(arr[i]);
                
                if(i % 9 == 8){
                    if(i == 8){
                        arr[i].setText("OPTIONS");
                    }
                    else{
                        
                        options[buttonIndex + 0] = new Buttons("Show");
                        options[buttonIndex + 1] = new Buttons("Edit");
                        options[buttonIndex + 2] = new Buttons("Delete");

                        options[buttonIndex + 0].setBounds(5, 5, 130, 20);
                        options[buttonIndex + 1].setBounds(5, 25, 130, 20);
                        options[buttonIndex + 2].setBounds(5, 45, 130, 20);
                        
                        options[buttonIndex + 0].addActionListener(this);
                        options[buttonIndex + 1].addActionListener(this);
                        options[buttonIndex + 2].addActionListener(this);
                        
                        arr[i].setLayout(null);
                        arr[i].add(options[buttonIndex + 0]);
                        arr[i].add(options[buttonIndex + 1]);
                        arr[i].add(options[buttonIndex + 2]);
                        
                        buttonIndex += 3;
                    }
                }
            }
            buttonIndex = 0;
            
        //PRINT FIRST 6 ENTRIES FROM DATABASE
            for(int i = 0; i < arr.length; i++){
                if(i % 9 == 0){
                        //arr[i].setWidthcolumn PAANO MAGSET WIDTH NG COLUMN
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 1){
                   if(i == 1){
                        arr[i].setText("USERNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 2){
                   if(i == 2){
                        arr[i].setText("FIRSTNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 3){
                   if(i == 3){
                        arr[i].setText("MIDDLENAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 4){
                   if(i == 4){
                        arr[i].setText("LASTNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 5){
                   if(i == 5){
                        arr[i].setText("ROLE");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 6){
                   if(i == 6){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 7){
                   if(i == 7){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 8){
                   if(i == 8){
                        arr[i].setText("OPTIONS");
                   }
                   else{ 
                        if(arr[i-8].getText().isEmpty() == false){
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
        northWestPanel.setPreferredSize(new Dimension(100,75));
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
        northWestPanel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
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
        
        if(ae.getSource() == options[0] || ae.getSource() == options[1] || ae.getSource() == options[2]){
            if(ae.getSource() == options[0]){
                frame.dispose();
                new Admin_Show(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[1]){
                frame.dispose();
                new Admin_Edit(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[2]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                }
            }
        }
        else if(ae.getSource() == options[3] || ae.getSource() == options[4] || ae.getSource() == options[5]){
            if(ae.getSource() == options[3]){
                frame.dispose();
                new Admin_Show(Integer.valueOf(users.get(8 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[4]){
                frame.dispose();
                new Admin_Edit(Integer.valueOf(users.get(8 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[5]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                    
                }
            }
        }
        else if(ae.getSource() == options[6] || ae.getSource() == options[7] || ae.getSource() == options[8]){
            if(ae.getSource() == options[6]){
                frame.dispose();
                new Admin_Show(Integer.valueOf(users.get(16 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[7]){
                frame.dispose();
                new Admin_Edit(Integer.valueOf(users.get(16 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[8]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                    
                }
            }
        }
        else if(ae.getSource() == options[9] || ae.getSource() == options[10] || ae.getSource() == options[11]){
            if(ae.getSource() == options[9]){
                frame.dispose();
                new Admin_Show(Integer.valueOf(users.get(24 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[10]){
                frame.dispose();
                new Admin_Edit(Integer.valueOf(users.get(24 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[11]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                    
                }
            }
        }
        else if(ae.getSource() == options[12] || ae.getSource() == options[13] || ae.getSource() == options[14]){
            if(ae.getSource() == options[12]){
                frame.dispose();
                new Admin_Show(Integer.valueOf(users.get(32 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[13]){
                frame.dispose();
                new Admin_Edit(Integer.valueOf(users.get(32 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[14]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                    
                }
            }
        }
        else if(ae.getSource() == options[15] || ae.getSource() == options[16] || ae.getSource() == options[17]){
            if(ae.getSource() == options[15]){
                frame.dispose();
                new Admin_Show(Integer.valueOf(users.get(40 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[16]){
                frame.dispose();
                new Admin_Edit(Integer.valueOf(users.get(40 + (48 * pageIndex - 48))));
            }
            else if(ae.getSource() == options[17]){
                //notif
                option = JOptionPane.showConfirmDialog(null, "Are you sure to DELETE this User?", "Delete User", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    deleteFunc(Integer.valueOf(users.get(0 + (48 * pageIndex - 48))),frame);
                }else{
                    
                }
            }
        }
        
        if(ae.getSource() == nextBtn){
            //PREV NEXT LOGIC
            pageIndex++;
            prevBtn.setEnabled(true);
            
            if(pageIndex == 1 && users.size() > 48){
                nextBtn.setEnabled(true);
            }
            else if(users.size() > 48 * (pageIndex)){
                nextBtn.setEnabled(true);
            }
            else{
                nextBtn.setEnabled(false);
            }
            
            //BUTTONS LOGIC
            
            for(int i = 0; i < arr.length; i++){
                if(i % 9 == 0){
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 1){
                   if(i == 1){
                        arr[i].setText("USERNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 2){
                   if(i == 2){
                        arr[i].setText("FIRSTNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 3){
                   if(i == 3){
                        arr[i].setText("MIDDLENAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 4){
                   if(i == 4){
                        arr[i].setText("LASTNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 5){
                   if(i == 5){
                        arr[i].setText("ROLE");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 6){
                   if(i == 6){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 7){
                   if(i == 7){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 8){
                   if(i == 8){
                        arr[i].setText("OPTIONS");
                   }
                   else{
                       try{
                        if(arr[i-8].getText().isBlank() == false){
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
                       }catch(IndexOutOfBoundsException e){
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
            dataIndex = dataIndex - (48 + (48 - ((48 * pageIndex) - dataIndex)));
            
            pageIndex--;
            
            if(pageIndex == 1){
                nextBtn.setEnabled(true);
                prevBtn.setEnabled(false);
            }
            else{
                prevBtn.setEnabled(true);
            }
            
            for(int i = 0; i < arr.length; i++){
                if(i % 9 == 0){
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 1){
                   if(i == 1){
                        arr[i].setText("USERNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 2){
                   if(i == 2){
                        arr[i].setText("FIRSTNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 3){
                   if(i == 3){
                        arr[i].setText("MIDDLENAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 4){
                   if(i == 4){
                        arr[i].setText("LASTNAME");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 5){
                   if(i == 5){
                        arr[i].setText("ROLE");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 6){
                   if(i == 6){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 7){
                   if(i == 7){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(users.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 8){
                   if(i == 8){
                        arr[i].setText("OPTIONS");
                   }
                   else{
                       try{
                        if(arr[i-8].getText().isBlank() == false){
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
                       }catch(IndexOutOfBoundsException e){
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