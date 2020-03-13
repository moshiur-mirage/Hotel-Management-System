/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.interfaces;

import com.mirage.hms.model.Roomtype;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */

public interface RoomtypeDao {
    public Roomtype insertRoomtype(Roomtype role);

    public void updateRoomtype(Roomtype role);

    public void deleteRoomtype(Integer roleId);

    public List<Roomtype> viewAllRoomtype();

    public Roomtype getOneRoomtype(Integer roleId);
}
