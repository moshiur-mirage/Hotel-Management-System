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
@Table(name="serviceDetails",
        catalog="hms")
public class ServiceDetails implements java.io.Serializable{
    private int serviceDetailsId;
    private String name;
    private double cost;

    public ServiceDetails() {
    }

    public ServiceDetails(int serviceDetailsId, String name, double cost) {
        this.serviceDetailsId = serviceDetailsId;
        this.name = name;
        this.cost = cost;
    }

    @Id
    @Column(name="serviceDetailsId",unique=true,nullable=false)
    public int getServiceDetailsId() {
        return serviceDetailsId;
    }

    public void setServiceDetailsId(int serviceDetailsId) {
        this.serviceDetailsId = serviceDetailsId;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="cost")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
}
