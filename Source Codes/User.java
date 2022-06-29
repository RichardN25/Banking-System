package bankingsystem;

public class User {
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String role;
    
    User(String input_FName, String input_MName, String input_LName, String input_Username, String input_Password) {
        firstName = input_FName;
        middleName = input_MName;
        lastName = input_LName;
        username = input_Username;
        password = input_Password;
        role = "User";
    }
    
    public String getFirstName(){
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
}