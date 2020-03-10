/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Hotel;
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
public class HotelDaoImpl implements HotelDao{

  @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Hotel insertHotel(Hotel hotel) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(hotel);
        t.commit();
        s.close();
        return hotel;
    }

    @Override
    public void updateHotel(Hotel hotel) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(hotel);
        t.commit();
        s.close();
        
    }

    @Override
    public void deleteHotel(Integer hotelId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Hotel hotel = (Hotel) s.get(Hotel.class, hotelId);
        s.delete(hotel);
        t.commit();
        s.close();
    }

    @Override
    public List<Hotel> viewAllHotel() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Hotel> list = s.createQuery("from Hotel").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Hotel getOneHotel(Integer hotelId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Hotel hotel = (Hotel) s.get(Hotel.class, hotelId);
        t.commit();
        s.close();
        return hotel;
    }
    
}
