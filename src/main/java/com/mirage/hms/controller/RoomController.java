/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.dao.RoomDao;
import com.mirage.hms.model.Room;
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
@RequestMapping("admin")
public class RoomController {
    
    @Autowired
    private RoomDao roomDao;
    
    @GetMapping("/room")
    public List<Room>getRoomlist(){
        return roomDao.viewAllRoom();        
    
    }
    
    //create 
    @PostMapping("/room")
    public Room createRoom(@RequestBody Room room){
        return roomDao.insertRoom(room);
    }
    // view by id
    @GetMapping("/room/{roomId}")
    public ResponseEntity<Room> getRoom(@PathVariable("roomId") Integer roomId){
        Room room = roomDao.getOneRoom(roomId);
        if(room == null){
            //no room found in browser
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Room>(room,HttpStatus.OK);
        }
    }
    
    // update room 
    @PutMapping(value="/room/{roomId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Room> updateRoom(@PathVariable("roomId") Integer roomId, @RequestBody Room room) {
        System.out.println("Updating Room " + roomId);
         
        Room cr = roomDao.getOneRoom(roomId);
         
        if (cr==null) {
            System.out.println("Room with id " + roomId + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }
 
        cr.setRoomId(room.getRoomId());
        cr.setRoomId(room.getRoomtypeId());
        cr.setFloorId(room.getFloorId());
        cr.setCapacity(room.getCapacity());
        cr.setSize(room.getSize());
        cr.setRent(room.getRent());
        cr.setDesc(room.getDesc());
        
         
        roomDao.updateRoom(cr);
        return new ResponseEntity<Room>(cr, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/room/{roomId}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("roomId") Integer roomId) {
        System.out.println("Fetching & Deleting Category with id " + roomId);

        Room room = roomDao.getOneRoom(roomId);
        if (room == null) {
            System.out.println("Unable to delete. Category with id " + roomId + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }

        roomDao.deleteRoom(roomId);
        return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
    }
}
