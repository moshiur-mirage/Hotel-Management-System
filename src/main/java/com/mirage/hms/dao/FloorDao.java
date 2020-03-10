/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Floor;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service
public interface FloorDao {
    public Floor insertFloor(Floor floor);

    public void updateFloor(Floor floor);

    public void deleteFloor(Integer floorId);

    public List<Floor> viewAllFloor();

    public Floor getOneFloor(Integer floorId);
}
