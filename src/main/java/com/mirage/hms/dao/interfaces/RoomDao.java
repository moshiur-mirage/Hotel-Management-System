/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.interfaces;

import com.mirage.hms.model.Room;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */

public interface RoomDao {
    public Room insertRoom(Room room);

    public void updateRoom(Room room);

    public void deleteRoom(Integer roomId);

    public List<Room> viewAllRoom();

    public Room getOneRoom(Integer roomId);
}
