/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.service.interfaces.HotelService;
import com.mirage.hms.model.Hotel;
import com.mirage.hms.model.User;
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
@RequestMapping("/admin")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    
    @GetMapping("/hotel")
    public List<Hotel>getHotellist(){
        return hotelService.viewAllHotel();        
    
    }
    
    //create 
    @PostMapping("/hotel")
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.insertHotel(hotel);
    }
    // view by id
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") Integer hotelId){
        Hotel hotel = hotelService.getOneHotel(hotelId);
        if(hotel == null){
            //no hotel found in browser
            return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
        }
    }
    
    // update hotel 
    @PutMapping(value="/hotel/{hotelId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("hotelId") Integer hotelId, @RequestBody Hotel hotel) {
        System.out.println("Updating Hotel " + hotelId);
         
        Hotel currentHotel = hotelService.getOneHotel(hotelId);
         
        if (currentHotel==null) {
            System.out.println("Hotel with id " + hotelId + " not found");
            return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
        }
 
        currentHotel.setHotelId(hotel.getHotelId());
        currentHotel.setName(hotel.getName());
        currentHotel.setLocation(hotel.getLocation());
        
         
        hotelService.updateHotel(currentHotel);
        return new ResponseEntity<Hotel>(currentHotel, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/hotel/{hotelId}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") Integer hotelId) {
        System.out.println("Fetching & Deleting Category with id " + hotelId);

        Hotel hotel = hotelService.getOneHotel(hotelId);
        if (hotel == null) {
            System.out.println("Unable to delete. Category with id " + hotelId + " not found");
            return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
        }

        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<Hotel>(HttpStatus.NO_CONTENT);
    }
}
