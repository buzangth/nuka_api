package com.genetics.nuka_api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genetics.nuka_api.security.ApplicationUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name="users")
@Entity
public class User implements UserDetails {
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

    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();



    @Override
    @JsonIgnore
    public Set<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

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

    public Set<SimpleGrantedAuthority> getRole() {
        return role.getGrantedAuthorities();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
