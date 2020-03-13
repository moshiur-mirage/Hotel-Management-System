package com.mirage.hms.model;
// Generated 01-Mar-2020 22:54:27 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Service generated by hbm2java
 */
@Entity
@Table(name="service"
    ,catalog="hms"
)
public class Service  implements java.io.Serializable {


     private int serviceId;
     private Integer customerId;
     private Date date;
     private Double fee;

    public Service() {
    }

	
    public Service(int serviceId) {
        this.serviceId = serviceId;
    }
    public Service(int serviceId, Integer customerId, Date date, Double fee) {
       this.serviceId = serviceId;
       this.customerId = customerId;
       this.date = date;
       this.fee = fee;
    }
   
     @Id 

    
    @Column(name="serviceId", unique=true, nullable=false)
    public int getServiceId() {
        return this.serviceId;
    }
    
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    
    @Column(name="customerId")
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date", length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    
    @Column(name="fee", precision=22, scale=0)
    public Double getFee() {
        return this.fee;
    }
    
    public void setFee(Double fee) {
        this.fee = fee;
    }




}


