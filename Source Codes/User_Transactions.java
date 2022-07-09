
package bankingsystem2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class User_Transactions extends Functions implements ActionListener{
    
    private JFrame frame;
    JPanel northPanel, northWestPanel, northEastPanel, centerPanel, centerEastPanel,
             centerWestPanel, tablePanel, buttonsPanel, gridPanel, userLabelPanel;
    JLabel userLabel;
    JLabel arr[] = new Labels[63];
    JButton nextBtn, prevBtn, backBtn;
    JButton options[] = new Buttons[18];
    GridLayout grid;
    
    ArrayList<String> transactions = new ArrayList<>();
    
    Color color1  = new Color(255,255,255);
    Color color2  = new Color(0,0,0);
    
    //counter Variables
    private int dataIndex;
    private int pageIndex = 1;
    
    User_Transactions() {
        
        //Initialization
        frame = new JFrame("Transactions");
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
        userLabel = new Labels("Transactions",30);
        userLabelPanel = new JPanel();
        nextBtn = new Buttons("Next");
        prevBtn = new Buttons("Previous");
        backBtn = new Buttons("Back");
        
        transactions = transactions();
       
        //GREATER THAN 48 (FIRST 6 ENTRIES * PER DATA COLUMN)
        if(transactions.size() > 48){
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
            }
            
        //PRINT FIRST 6 ENTRIES FROM DATABASE
            for(int i = 0; i < arr.length; i++){
                if(i % 9 == 0){
                        //arr[i].setWidthcolumn PAANO MAGSET WIDTH NG COLUMN
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 1){
                   if(i == 1){
                        arr[i].setText("ID_USER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 2){
                   if(i == 2){
                        arr[i].setText("SENDER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 3){
                   if(i == 3){
                        arr[i].setText("RECEIVER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 4){
                   if(i == 4){
                        arr[i].setText("AMOUNT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 5){
                   if(i == 5){
                        arr[i].setText("RUNNING BAL");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 6){
                   if(i == 6){
                        arr[i].setText("TYPE");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 7){
                   if(i == 7){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 8){
                   if(i == 8){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                    }
                }
                arr[i].setBorder(new LineBorder(Color.BLACK));
            }
        
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
              
        if(ae.getSource() == nextBtn){
            //PREV NEXT LOGIC
            pageIndex++;
            prevBtn.setEnabled(true);
            
            if(pageIndex == 1 && transactions.size() > 48){
                nextBtn.setEnabled(true);
            }
            else if(transactions.size() > 48 * (pageIndex)){
                nextBtn.setEnabled(true);
            }
            else{
                nextBtn.setEnabled(false);
            }
            
            //BUTTONS LOGIC
            
            for(int i = 0; i < arr.length; i++){
                if(i % 9 == 0){
                        //arr[i].setWidthcolumn PAANO MAGSET WIDTH NG COLUMN
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 1){
                   if(i == 1){
                        arr[i].setText("ID_USER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 2){
                   if(i == 2){
                        arr[i].setText("SENDER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 3){
                   if(i == 3){
                        arr[i].setText("RECEIVER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 4){
                   if(i == 4){
                        arr[i].setText("AMOUNT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 5){
                   if(i == 5){
                        arr[i].setText("RUNNING BAL");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 6){
                   if(i == 6){
                        arr[i].setText("TYPE");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 7){
                   if(i == 7){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 8){
                   if(i == 8){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
                arr[i].setBorder(new LineBorder(Color.BLACK));
            }
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
                        //arr[i].setWidthcolumn PAANO MAGSET WIDTH NG COLUMN
                   if(i == 0){
                        arr[i].setText("ID");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 1){
                   if(i == 1){
                        arr[i].setText("ID_USER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 2){
                   if(i == 2){
                        arr[i].setText("SENDER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 3){
                   if(i == 3){
                        arr[i].setText("RECEIVER");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 4){
                   if(i == 4){
                        arr[i].setText("AMOUNT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 5){
                   if(i == 5){
                        arr[i].setText("RUNNING BAL");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 6){
                   if(i == 6){
                        arr[i].setText("TYPE");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 7){
                   if(i == 7){
                        arr[i].setText("UPDATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
               else if(i % 9 == 8){
                   if(i == 8){
                        arr[i].setText("CREATED AT");
                   }
                   else{
                        try{
                          arr[i].setText(transactions.get(dataIndex));
                          dataIndex++;
                       }catch(IndexOutOfBoundsException e){
                           arr[i].setText("");
                       }
                   }
                }
                arr[i].setBorder(new LineBorder(Color.BLACK));
            }
        }
        else if(ae.getSource() == backBtn){
            frame.dispose();
            new User_Dashboard();
        }
    }
}
