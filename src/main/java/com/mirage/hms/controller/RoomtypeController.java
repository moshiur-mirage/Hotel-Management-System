/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.service.interfaces.RoomtypeService;
import com.mirage.hms.model.Roomtype;
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
public class RoomtypeController {
    @Autowired
    private RoomtypeService roomtypeService;
    
    //show all
    @GetMapping("/roomtype")
    public List<Roomtype>getRoomtypelist(){
        return roomtypeService.viewAllRoomtype();        
    }
    
    
    //create 
    @PostMapping("/roomtype")
    public Roomtype createRoomtype(@RequestBody Roomtype roomtype){
        return roomtypeService.insertRoomtype(roomtype);
    }
    // view by id
    @GetMapping("/roomtype/{roomtypeId}")
    public ResponseEntity<Roomtype> getRoomtype(@PathVariable("roomtypeId") Integer roomtypeId){
        Roomtype roomtype = roomtypeService.getOneRoomtype(roomtypeId);
        if(roomtype == null){
            //no roomtype found in browser
            return new ResponseEntity<Roomtype>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Roomtype>(roomtype,HttpStatus.OK);
        }
    }
    
    // update roomtype 
    @PutMapping(value="/roomtype/{roomtypeId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Roomtype> updateRoomtype(@PathVariable("roomtypeId") Integer roomtypeId, @RequestBody Roomtype roomtype) {
        System.out.println("Updating Roomtype " + roomtypeId);
         
        Roomtype currentRoomtype = roomtypeService.getOneRoomtype(roomtypeId);
         
        if (currentRoomtype==null) {
            System.out.println("Roomtype with id " + roomtypeId + " not found");
            return new ResponseEntity<Roomtype>(HttpStatus.NOT_FOUND);
        }
 
        
        currentRoomtype.setRoomtypeId(roomtype.getRoomtypeId());
        currentRoomtype.setDesc(roomtype.getDesc());
        
         
        roomtypeService.updateRoomtype(currentRoomtype);
        return new ResponseEntity<Roomtype>(currentRoomtype, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/roomtype/{roomtypeId}")
    public ResponseEntity<Roomtype> deleteRoomType(@PathVariable("roomtypeId") Integer roomtypeId) {
        System.out.println("Fetching & Deleting Category with id " + roomtypeId);

        Roomtype roomtype = roomtypeService.getOneRoomtype(roomtypeId);
        if (roomtype == null) {
            System.out.println("Unable to delete. Category with id " + roomtypeId + " not found");
            return new ResponseEntity<Roomtype>(HttpStatus.NOT_FOUND);
        }

        roomtypeService.deleteRoomtype(roomtypeId);
        return new ResponseEntity<Roomtype>(HttpStatus.NO_CONTENT);
    }
}
