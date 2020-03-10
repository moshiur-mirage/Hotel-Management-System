/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Roomtype;
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
public class RoomtypeDaoImpl implements RoomtypeDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Roomtype insertRoomtype(Roomtype roomtype) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(roomtype);
        t.commit();
        s.close();
        return roomtype;
    }

    @Override
    public void updateRoomtype(Roomtype roomtype) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(roomtype);
        t.commit();
        s.close();
    }
    
    

    @Override
    public void deleteRoomtype(Integer roomtypeId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Roomtype roomtype = (Roomtype) s.get(Roomtype.class, roomtypeId);
        s.delete(roomtype);
        t.commit();
        s.close();
    }

    @Override
    public List<Roomtype> viewAllRoomtype() {
//        List<Roomtype> list = sessionFactory.getCurrentSession().createQuery("from Roomtype").list();
//        return list;

        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Roomtype> list = s.createQuery("from Roomtype").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Roomtype getOneRoomtype(Integer roomtypeId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Roomtype roomtype = (Roomtype) s.get(Roomtype.class, roomtypeId);
        t.commit();
        s.close();
        return roomtype;

    }
}
