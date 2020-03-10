/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.dao.BookingDao;
import com.mirage.hms.model.Booking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirage
 */
@RestController
@RequestMapping(value= "/admin/")
public class BookingController {
    
    @Autowired
    private BookingDao bookingDao;
    
    //show all
    @GetMapping("/booking")
    public List<Booking>getBookinglist(){
        return bookingDao.viewAllBooking();        
    }
    
    
    //create 
    @PostMapping("/booking")
    public Booking createBooking(@RequestBody Booking booking){
        return bookingDao.insertBooking(booking);
    }
    // view by id
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable("bookingId") Integer bookingId){
        Booking booking = bookingDao.getOneBooking(bookingId);
        if(booking == null){
            //no booking found in browser
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Booking>(booking,HttpStatus.OK);
        }
    }
    
    // update booking 
    @PutMapping(value="/booking/{bookingId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Booking> updateBooking(@PathVariable("bookingId") Integer bookingId, @RequestBody Booking booking) {
        System.out.println("Updating Booking " + bookingId);
         
        Booking currentBooking = bookingDao.getOneBooking(bookingId);
         
        if (currentBooking==null) {
            System.out.println("Booking with id " + bookingId + " not found");
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
 
        
        currentBooking.setBookingId(booking.getBookingId());
        currentBooking.setRoomId(booking.getRoomId());
        currentBooking.setCustomerId(booking.getCustomerId());
        currentBooking.setBoardingDate(booking.getBoardingDate());
        currentBooking.setDepurtureDate(booking.getDepurtureDate());
        currentBooking.setBookingDate(booking.getBookingDate());
        currentBooking.setAdvance(booking.getAdvance());
        
        
         
        bookingDao.updateBooking(currentBooking);
        return new ResponseEntity<Booking>(currentBooking, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> deleteUser(@PathVariable("bookingId") Integer bookingId) {
        System.out.println("Fetching & Deleting Category with id " + bookingId);

        Booking booking = bookingDao.getOneBooking(bookingId);
        if (booking == null) {
            System.out.println("Unable to delete. Category with id " + bookingId + " not found");
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }

        bookingDao.deleteBooking(bookingId);
        return new ResponseEntity<Booking>(HttpStatus.NO_CONTENT);
    }
}
