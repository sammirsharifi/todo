package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "user_table";
    public static final String user_name = "userName";
    public static final String passColumn_name = "password";

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = user_name, length = 1024)
    private String username;



    @Column(name = passColumn_name)
    private String password;





    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
