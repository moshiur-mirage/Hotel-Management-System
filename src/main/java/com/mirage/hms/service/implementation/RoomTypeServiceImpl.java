/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.RoomtypeDao;

import com.mirage.hms.model.Roomtype;

import com.mirage.hms.service.interfaces.RoomtypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("roomTypeService")
public class RoomTypeServiceImpl implements RoomtypeService{
    @Autowired
    private RoomtypeDao roomtypeDao;
    @Override
    public Roomtype insertRoomtype(Roomtype roomtype) {
        return roomtypeDao.insertRoomtype(roomtype);
    }

    @Override
    public void updateRoomtype(Roomtype roomtype) {
        roomtypeDao.updateRoomtype(roomtype);
    }

    @Override
    public void deleteRoomtype(Integer roomtypeId) {
        roomtypeDao.deleteRoomtype(roomtypeId);
    }

    @Override
    public List<Roomtype> viewAllRoomtype() {
        return roomtypeDao.viewAllRoomtype();
    }

    @Override
    public Roomtype getOneRoomtype(Integer roomtypeId) {
        return roomtypeDao.getOneRoomtype(roomtypeId);
    }
}
