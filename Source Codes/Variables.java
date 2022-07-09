package bankingsystem2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Variables {
    
    public static Connection conn = null;
    public static Statement stm = null;
    public static PreparedStatement prstm = null;
    public static ResultSet rs = null;
    public static String query = "";
    public static String id = "";
    public static String firstname = "";
    public static String middlename = "";
    public static String lastname = "";
    public static String username = "";            
    public static String password = "";
    public static String role = "";
    public static String fullname = firstname+" "+lastname;
    
    public static int currID = 0;
    
    public static ArrayList<String> bankList = new ArrayList<>();
    public static ArrayList<String> balanceList = new ArrayList<>();
    
    public static String[] bankAccounts;
    public static String[] balanceAccounts;
    
    public void Logout(){
        id = "";
        firstname = "";
        middlename = "";
        lastname = "";
        username = "";
        password = "";
        role = "";
        fullname = "";
        currID = 0;
        
        bankList.clear();
        balanceList.clear();
        
        bankAccounts = bankList.toArray(new String[0]);
        
        new Login();
    }

}