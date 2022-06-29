package bankingsystem;

public class Admin extends User {
    Admin() {
        super("AdminFN", "AdminMN", "AdminLN", "Admin", "PasswordAdmin");
        SetRole();
    }
    public void SetRole() {
        super.role = "Admin";
    }
}