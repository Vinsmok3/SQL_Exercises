import java.util.Date;

public class User {

    private String username;
    private String email;
    private String password;
    private Date registration;
    private short active;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public User(String username, String email, String password, Date registration, short active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registration = registration;
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registration=" + registration +
                ", active=" + active +
                '}';
    }

}
