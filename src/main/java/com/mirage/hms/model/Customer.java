/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mirage
 */
@Entity
@Table(name="customer",catalog="hms")
public class Customer implements java.io.Serializable{
    
    private Integer customerId;
    private String name;
    private String mobile;
    private String email;
    private String customername;
    private String password;

    public Customer() {
    }

    public Customer(Integer customerId, String name, String mobile, String email, String customername, String password) {
        this.customerId = customerId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.customername = customername;
        this.password = password;
    }

    @Id
    @Column(name="customerId", unique=true, nullable=false)
    public Integer getCustomerId() {
        return customerId;
    }

    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="customername")
    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }
    
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
