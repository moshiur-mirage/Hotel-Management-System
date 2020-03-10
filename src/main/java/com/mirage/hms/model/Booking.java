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
 * Booking generated by hbm2java
 */
@Entity
@Table(name="booking"
    ,catalog="hms"
)
public class Booking  implements java.io.Serializable {


     private int bookingId;
     private Integer roomId;
     private Integer customerId;
     private Date bookingDate;
     private Date boardingDate;
     private Date depurtureDate;
     private Double advance;

    public Booking() {
    }

	
    public Booking(int bookingId) {
        this.bookingId = bookingId;
    }
    public Booking(int bookingId, Integer roomId, Integer customerId, Date bookingDate, Date boardingDate, Date depurtureDate, Double advance) {
       this.bookingId = bookingId;
       this.roomId = roomId;
       this.customerId = customerId;
       this.bookingDate = bookingDate;
       this.boardingDate = boardingDate;
       this.depurtureDate = depurtureDate;
       this.advance = advance;
    }
   
     @Id 

    
    @Column(name="bookingId", unique=true, nullable=false)
    public int getBookingId() {
        return this.bookingId;
    }
    
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    
    @Column(name="roomId")
    public Integer getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    
    @Column(name="customerId")
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="bookingDate", length=10)
    public Date getBookingDate() {
        return this.bookingDate;
    }
    
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="boardingDate", length=10)
    public Date getBoardingDate() {
        return this.boardingDate;
    }
    
    public void setBoardingDate(Date boardingDate) {
        this.boardingDate = boardingDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="depurtureDate", length=10)
    public Date getDepurtureDate() {
        return this.depurtureDate;
    }
    
    public void setDepurtureDate(Date depurtureDate) {
        this.depurtureDate = depurtureDate;
    }

    
    @Column(name="advance", precision=22, scale=0)
    public Double getAdvance() {
        return this.advance;
    }
    
    public void setAdvance(Double advance) {
        this.advance = advance;
    }




}


