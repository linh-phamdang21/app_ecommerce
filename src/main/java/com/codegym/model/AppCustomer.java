//package com.codegym.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table
//public class AppCustomer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long id;
//
//    private String CustomerName;
//
//    private String CustomerPass;
//
//    private String phone;
//
//    private String address;
//
//    @ManyToOne
//    private AppRole appRole;
//
//    public AppRole getAppRole() {
//        return appRole;
//    }
//
//    public void setAppRole(AppRole appRole) {
//        this.appRole = appRole;
//    }
//
//    public AppCustomer() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getCustomerName() {
//        return CustomerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        CustomerName = customerName;
//    }
//
//    public String getCustomerPass() {
//        return CustomerPass;
//    }
//
//    public void setCustomerPass(String customerPass) {
//        CustomerPass = customerPass;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//}
