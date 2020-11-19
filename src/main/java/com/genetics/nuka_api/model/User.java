package com.genetics.nuka_api.model;



// org.springframework.boot.autoconfigure.domain.EntityScan;

import com.genetics.nuka_api.security.ApplicationUserRole;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name =("first_name"))
    @NotBlank(message = "first name is required")
    private String firstname;

    @Column(name = "surname")
    @NotBlank(message = "surname is required")
    private String surname;

    @Email
    @NotBlank(message = "username is required")
    @Column(unique = true,name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="role")
    private ApplicationUserRole role;

    @Column(name="branch")
    private String branch;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public ApplicationUserRole getRole() {
        return role;
    }

    public void setRole(ApplicationUserRole role) {
        this.role = role;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}