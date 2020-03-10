/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Room;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mirage
 */
@Repository
@Transactional
public class RoomDaoImpl implements RoomDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Room insertRoom(Room room) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(room);
        t.commit();
        s.close();
        return room;
    }

    @Override
    public void updateRoom(Room room) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(room);
        t.commit();
        s.close();
        
    }

    @Override
    public void deleteRoom(Integer roomId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Room room = (Room) s.get(Room.class, roomId);
        s.delete(room);
        t.commit();
        s.close();
    }

    @Override
    public List<Room> viewAllRoom() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Room> list = s.createQuery("from Room").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Room getOneRoom(Integer roomId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Room room = (Room) s.get(Room.class, roomId);
        t.commit();
        s.close();
        return room;
    }
}
