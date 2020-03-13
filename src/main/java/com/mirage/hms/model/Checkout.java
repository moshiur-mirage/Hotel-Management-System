/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mirage
 */
@Entity
@Table(name="checkout",catalog="hms")
public class Checkout implements Serializable{
    private int checkoutId;
    private int customerId;
    private int bookingId;
    private double totalPay;
    private Date date;

    public Checkout() {
    }

    public Checkout(int checkoutId, int customerId, int bookingId, double totalPay, Date date) {
        this.checkoutId = checkoutId;
        this.customerId = customerId;
        this.bookingId = bookingId;
        this.totalPay = totalPay;
        this.date = date;
    }

    @Id
    @Column(name="checkoutId",unique=true,nullable=false)
    public int getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(int checkoutId) {
        this.checkoutId = checkoutId;
    }

    @Column(name="customerId")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Column(name="bookingId")
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Column(name="totalPay")
    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
