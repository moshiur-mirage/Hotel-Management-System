/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.dao.FloorDao;
import com.mirage.hms.model.Floor;
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
public class FloorController {
    @Autowired
    private FloorDao floorDao;
    
    //show all
    @GetMapping("/floor")
    public List<Floor>getFloorlist(){
        return floorDao.viewAllFloor();        
    }
    
    
    //create 
    @PostMapping("/floor")
    public Floor createFloor(@RequestBody Floor floor){
        return floorDao.insertFloor(floor);
    }
    // view by id
    @GetMapping("/floor/{floorId}")
    public ResponseEntity<Floor> getFloor(@PathVariable("floorId") Integer floorId){
        Floor floor = floorDao.getOneFloor(floorId);
        if(floor == null){
            //no floor found in browser
            return new ResponseEntity<Floor>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Floor>(floor,HttpStatus.OK);
        }
    }
    
    // update floor 
    @PutMapping(value="/floor/{floorId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Floor> updateFloor(@PathVariable("floorId") Integer floorId, @RequestBody Floor floor) {
        System.out.println("Updating Floor " + floorId);
         
        Floor currentFloor = floorDao.getOneFloor(floorId);
         
        if (currentFloor==null) {
            System.out.println("Floor with id " + floorId + " not found");
            return new ResponseEntity<Floor>(HttpStatus.NOT_FOUND);
        }
 
        
        currentFloor.setHotelId(floor.getHotelId());
        currentFloor.setDesc(floor.getDesc());
        currentFloor.setFloorId(floor.getFloorId());
        
         
        floorDao.updateFloor(currentFloor);
        return new ResponseEntity<Floor>(currentFloor, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/floor/{floorId}")
    public ResponseEntity<Floor> deleteUser(@PathVariable("floorId") Integer floorId) {
        System.out.println("Fetching & Deleting Category with id " + floorId);

        Floor floor = floorDao.getOneFloor(floorId);
        if (floor == null) {
            System.out.println("Unable to delete. Category with id " + floorId + " not found");
            return new ResponseEntity<Floor>(HttpStatus.NOT_FOUND);
        }

        floorDao.deleteFloor(floorId);
        return new ResponseEntity<Floor>(HttpStatus.NO_CONTENT);
    }
}
