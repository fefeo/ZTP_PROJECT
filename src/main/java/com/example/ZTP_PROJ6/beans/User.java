package com.example.ZTP_PROJ6.beans;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Users")
@Table(name = "\"Users\"")
public class User {

    @Id
    @Column(
            name="id",
            updatable = false
    )
    private String id;
    @Column(
            name="login",
            nullable = false,
            columnDefinition = "text",
            length = 1200
    )
    private String login;
    @Column(
            name="pass",
            nullable = false,
            columnDefinition = "text"
    )
    private String pass;
    @Column(
            name="role",
            nullable = false,
            columnDefinition = "text"
    )
    private  Role role;
    @OneToMany(targetEntity = Recipe.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ur_fk", referencedColumnName = "id")
    private List<Recipe> recipes;

    public User(String id, String login, String pass, Role role) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public User() {

    }

    //    public User(String login, String pass) {
//        this.login = login;
//        this.pass = pass;
//        this.role = Role.USER;
//    }
//    public User(String login, String pass, Role role) {
//        this.login = login;
//        this.pass = pass;
//        this.role = role;
//    }
//    public User(String id, String login, String pass, Role role) {
//        this.id = id;
//        this.login = login;
//        this.pass = pass;
//        this.role = role;
//    }


    public String getId() { return id; }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public Role getRole() {
        return role;
    }

    public void setId() {
        this.id = idCreator();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                '}';
    }

    public static String idCreator() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
}