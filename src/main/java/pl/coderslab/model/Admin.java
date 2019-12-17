package pl.coderslab.model;

public class Admin {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    byte enable = 1;
    byte superadmin = 0;

    public Admin() {

    }

    public byte getSuperadmin() {
        return superadmin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getEnable() {
        return enable;
    }

}
