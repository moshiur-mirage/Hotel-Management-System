/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Floor;
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
public class FloorDaoImpl implements FloorDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Floor insertFloor(Floor floor) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(floor);
        t.commit();
        s.close();
        return floor;
    }

    @Override
    public void updateFloor(Floor floor) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(floor);
        t.commit();
        s.close();
    }
    
    

    @Override
    public void deleteFloor(Integer floorId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Floor floor = (Floor) s.get(Floor.class, floorId);
        s.delete(floor);
        t.commit();
        s.close();
    }

    @Override
    public List<Floor> viewAllFloor() {
//        List<Floor> list = sessionFactory.getCurrentSession().createQuery("from Floor").list();
//        return list;

        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Floor> list = s.createQuery("from Floor").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Floor getOneFloor(Integer floorId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Floor floor = (Floor) s.get(Floor.class, floorId);
        t.commit();
        s.close();
        return floor;

    }
}
