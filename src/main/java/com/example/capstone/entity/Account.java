package com.example.capstone.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account  {



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "account_roles",
            joinColumns = @JoinColumn(
                    name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "account_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Account(Collection<Role> roles, long id, String userName, String encrytedPassword) {
        this.roles = roles;
        this.id = id;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
    }

    public Account(Collection<Role> roles, long id, String userName, String encrytedPassword, String userRole) {
        this.roles = roles;
        this.id = id;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.userRole = userRole;
    }

    public Account() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "User_Name", length = 20, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

//    @Column(name = "Active", length = 1, nullable = false)
//    private boolean active;

    @Column(name = "User_Role", length = 20, nullable = false)
    private String userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", encrytedPassword='" + encrytedPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
