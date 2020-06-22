package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class AppCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Pattern(regexp = "^$|[a-zA-Z0-9]*$")
    @NotEmpty
    @Size(min = 4, max = 220)
    private String username;

    @Pattern(regexp = "^$|[a-zA-Z0-9]*$")
    @NotEmpty
    @Size(min = 4, max = 220)
    private String password;

    @Pattern(regexp = "^$|[0-9]*$")
    @NotEmpty
    @Size(min = 10, max = 11)
    private String phone;

    @Pattern(regexp = "^$|[a-zA-Z0-9]*$")
    @NotEmpty
    @Size(min = 4, max = 220)
    private String address;

    @ManyToOne
    private AppRole appRole;

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppCustomer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

