/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.RoomDao;
import com.mirage.hms.model.Room;
import com.mirage.hms.service.interfaces.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomDao roomDao;
    @Override
    public Room insertRoom(Room room) {
        return roomDao.insertRoom(room);
    }

    @Override
    public void updateRoom(Room room) {
        roomDao.updateRoom(room);
    }

    @Override
    public void deleteRoom(Integer roomId) {
        roomDao.deleteRoom(roomId);
    }

    @Override
    public List<Room> viewAllRoom() {
        return roomDao.viewAllRoom();
    }

    @Override
    public Room getOneRoom(Integer roomId) {
        return roomDao.getOneRoom(roomId);
    }
}
