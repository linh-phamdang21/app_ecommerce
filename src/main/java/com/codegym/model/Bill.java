package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp orderDate;

    @ManyToOne
    private BillStatus billStatus;

    @ManyToOne
    private AppCustomer customer;

    @OneToOne
    private BillDetail billDetail;

    public Bill() {
    }

    public Bill(Long id, AppCustomer customer, BillDetail billDetail,   BillStatus billStatus,Timestamp orderDate) {
        this.id = id;
        this.customer = customer;
        this.billDetail = billDetail;
        this.billStatus = billStatus;
        this.orderDate = orderDate;
    }
    public Bill( AppCustomer customer, BillDetail billDetail,   BillStatus billStatus,Timestamp orderDate) {
        this.customer = customer;
        this.billDetail = billDetail;
        this.billStatus = billStatus;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public BillStatus getStatus() {
        return billStatus;
    }

    public void setStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public AppCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(AppCustomer customer) {
        this.customer = customer;
    }

    public BillDetail getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
    }
}