package bankingsystem;

public class Admin extends User {
    Admin() {
        super("AdminFN", "AdminMN", "AdminLN", "Admin", "PasswordAdmin");
        SetRole();
    }
    public void SetRole() {
        super.role = "Admin";
    }
    public String getFirstName() {
        return super.firstName;
    }
    public String getMiddleName() {
        return super.middleName;
    }
    public String getLastName() {
        return super.lastName;
    }
    public String getUsername() {
        return super.username;
    }
    public String getPassword() {
        return super.password;
    }
    public String getRole() {
        return super.role;
    }
}