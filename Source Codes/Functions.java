package bankingsystem2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Functions extends Variables{
    
    private ArrayList<String> accounts = new ArrayList<>();
    private ArrayList<String> transactions = new ArrayList<>();
    
    private String account = "";
    private float accBalance;
    
    Functions(){}
    
    void setAccount(Object account){
        try {
            this.account = String.valueOf(account);
            query = "SELECT BALANCE FROM ACCOUNT WHERE ACCNUM = '" + this.account + "'";
            rs = stm.executeQuery(query);

            while (rs.next()){
                accBalance = rs.getFloat("balance");
                System.out.println(accBalance);
            }
        }catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String[] getAccounts(){
        bankAccounts = bankList.toArray(new String[0]);
        return bankAccounts;
    }
    
    String[] getBalances(){
        balanceAccounts = balanceList.toArray(new String[0]);
        return balanceAccounts;
    }
    
    float getRaccBalance(String Raccount){
        
        float RaccBalance = 0;
        
        try {
            
            query = "SELECT BALANCE FROM ACCOUNT WHERE ACCNUM = '" + Raccount + "'";
            rs = stm.executeQuery(query);

            while (rs.next()){
                RaccBalance = rs.getFloat("balance");
            }
        }catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return RaccBalance;
    }
    
    private void insertTransaction(String receiver, float amount, float run_bal, String type){
        
        
        if(type == "transfer"){
            try{
           
            query = " INSERT INTO TRANSACTION (ID_USER, SENDER, RECEIVER, AMOUNT, RUNNING_BALANCE, TYPE)" + "values (?, ?, ?, ?, ?, ?)";
                  
            PreparedStatement prepStm = conn.prepareStatement(query, stm.RETURN_GENERATED_KEYS);

            prepStm.setInt(1, Integer.valueOf(id));
            prepStm.setString(2, account);
            prepStm.setString(3, receiver);
            prepStm.setFloat(4, amount);
            prepStm.setFloat(5, run_bal);
            prepStm.setString(6, type);
            prepStm.execute();
            
            }catch (SQLException ex) {
                Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try{
           
            query = " INSERT INTO TRANSACTION (ID_USER, SENDER, AMOUNT, RUNNING_BALANCE, TYPE)" + "values (?, ?, ?, ?, ?)";
                  
            PreparedStatement prepStm = conn.prepareStatement(query, stm.RETURN_GENERATED_KEYS);

            prepStm.setInt(1, Integer.valueOf(id));
            prepStm.setString(2, account);
            prepStm.setFloat(3, amount);
            prepStm.setFloat(4, run_bal);
            prepStm.setString(5, type);
            prepStm.execute();
            
            }catch (SQLException ex) {
                Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    ArrayList<String> transactions(){
        try {

            query = "SELECT * FROM TRANSACTION WHERE ID_USER = " + id + " ORDER BY ID ASC";
            rs = stm.executeQuery(query);

            while (rs.next()){
                transactions.add(Integer.toString(rs.getInt("id")));
                transactions.add(Integer.toString(rs.getInt("id_user")));
                transactions.add(rs.getString("sender"));
                transactions.add(rs.getString("receiver"));
                transactions.add(Float.toString(rs.getFloat("amount")));
                accBalance = rs.getFloat("amount");
                transactions.add(Float.toString(rs.getFloat("running_balance")));
                transactions.add(rs.getString("type"));
                transactions.add(rs.getString("updated_at"));
                transactions.add(rs.getString("created_at"));
            }
        }catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactions;
    }
    
    void depositFunc(Object account, String amount, JFrame frame){
        
        try {
            float newBalance = accBalance + Float.valueOf(amount);
            query = "UPDATE ACCOUNT SET BALANCE = " + newBalance + "WHERE ACCNUM = '" + String.valueOf(account) + "'";
            stm.executeUpdate(query);
            
            System.out.println("Deposit");
            System.out.println("Account " + account);
            System.out.println("Amount  " + amount);
            System.out.println("New Balance  " + newBalance);
            
            insertTransaction("",Float.valueOf(amount),newBalance,"deposit");
            
            frame.dispose();
            new User_Dashboard();

        }catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void withdrawFunc(Object account, String amount, JFrame frame){
        
        try {
            float newBalance = accBalance - Float.valueOf(amount);
            System.out.println(newBalance);
            if(newBalance < 0){
                //WARNING BAWAL MAGWITHDRAW
                System.out.println("DONT HAVE ENOUGH FUNDS!");
            }
            else{
                query = "UPDATE ACCOUNT SET BALANCE = " + newBalance + "WHERE ACCNUM = '" + String.valueOf(account) + "'";
                stm.executeUpdate(query);

                System.out.println("Withdraw");
                System.out.println("Account " + account);
                System.out.println("Amount  " + amount);
                System.out.println("New Balance  " + newBalance); 
                
                insertTransaction("",Float.valueOf(amount),newBalance,"withdraw");
                
                frame.dispose();
                new User_Dashboard();
            }
        }catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void transferFunc(Object Saccount, String Raccount, String amount, JFrame frame){
        
        try {
            float newBalance = accBalance - Float.valueOf(amount);
            System.out.println(newBalance);
            if(newBalance < 0){
                //WARNING BAWAL MAGWITHDRAW
                System.out.println("DONT HAVE ENOUGH FUNDS!");
            }
            else if(Raccount == null){
                //NON EXISTING ACCOUNT VALIDATOR FUNCTION...
            }
            else{
                query = "UPDATE ACCOUNT SET BALANCE = " + newBalance + "WHERE ACCNUM = '" + String.valueOf(Saccount) + "'";
                stm.executeUpdate(query);
                
                System.out.println("Transfer");
                System.out.println("Account     " + Saccount);
                System.out.println("Transfer To " + Raccount);
                System.out.println("Amount      " + amount);
                System.out.println("New Balance  " + newBalance); 
               
                newBalance = getRaccBalance(Raccount) + Float.valueOf(amount);
                
                query = "UPDATE ACCOUNT SET BALANCE = " + newBalance + "WHERE ACCNUM = '" + String.valueOf(Raccount) + "'";
                stm.executeUpdate(query);
                
                insertTransaction(Raccount,Float.valueOf(amount),newBalance,"transfer");
                
                frame.dispose();
                new User_Dashboard();
            }
        }catch (SQLException ex) {
            Logger.getLogger(Admin_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteFunc(int delId, JFrame frame){
        try {
            
            deleteFunc2(delId);

            query = "DELETE FROM USERS WHERE ID = ?";
            prstm = conn.prepareStatement(query);
            prstm.setInt(1, delId);
            prstm.execute();
            
            frame.dispose();
            new Admin_Users();

        }catch (SQLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteFunc2(int delId){
        try {
            
            query = "DELETE FROM ACCOUNT WHERE ID_USER = ?";
            prstm = conn.prepareStatement(query);
            prstm.setInt(1, delId);
            prstm.execute();

        }catch (SQLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteFunc3(int delId, JFrame frame){
        try {
            
            query = "DELETE FROM ACCOUNT WHERE ID = ?";
            prstm = conn.prepareStatement(query);
            prstm.setInt(1, delId);
            prstm.execute();
            
            frame.dispose();
            new Admin_BankAccounts();

        }catch (SQLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void editFunc(int editId, String fn, String mn, String ln, String un, String pw, JFrame frame){
        try {
            //UPDATE FIELDS
            query = "UPDATE USERS SET FIRSTNAME = '"+ fn +"',"
                    + "MIDDLENAME = '"+ mn +"',"
                    + "LASTNAME = '"+ ln +"',"
                    + "USERNAME = '"+ un +"',"
                    + "PASSWORD = '"+ pw +"'"
                    + "WHERE ID = "+ editId +"";
            stm.executeUpdate(query);

            System.out.println("Successful Update!");
            System.out.println("First Name        " + fn);
            System.out.println("Middle Name       " + mn);
            System.out.println("Last Name         " + ln);
            System.out.println("Username          " + un);
            System.out.println("Password          " + pw);

            frame.dispose();
            new Admin_Users();

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
