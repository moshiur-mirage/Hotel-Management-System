/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;


import com.mirage.hms.dao.interfaces.FloorDao;

import com.mirage.hms.model.Floor;
import com.mirage.hms.service.interfaces.FloorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("floorService")
public class FloorServiceImpl implements FloorService{

    @Autowired
    private FloorDao floorDao;
    @Override
    public Floor insertFloor(Floor floor) {
        return floorDao.insertFloor(floor);
    }

    @Override
    public void updateFloor(Floor floor) {
        floorDao.updateFloor(floor);
    }

    @Override
    public void deleteFloor(Integer floorId) {
        floorDao.deleteFloor(floorId);
    }

    @Override
    public List<Floor> viewAllFloor() {
        return floorDao.viewAllFloor();
    }

    @Override
    public Floor getOneFloor(Integer floorId) {
        return floorDao.getOneFloor(floorId);
    }
    
}
