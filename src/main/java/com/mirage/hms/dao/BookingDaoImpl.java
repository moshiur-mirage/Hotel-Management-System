/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.dao.BookingDao;
import com.mirage.hms.model.Booking;
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
public class BookingDaoImpl implements BookingDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Booking insertBooking(Booking booking) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(booking);
        t.commit();
        s.close();
        return booking;
    }

    @Override
    public void updateBooking(Booking booking) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(booking);
        t.commit();
        s.close();
    }
    
    

    @Override
    public void deleteBooking(Integer bookingId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Booking booking = (Booking) s.get(Booking.class, bookingId);
        s.delete(booking);
        t.commit();
        s.close();
    }

    @Override
    public List<Booking> viewAllBooking() {
//        List<Booking> list = sessionFactory.getCurrentSession().createQuery("from Booking").list();
//        return list;

        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Booking> list = s.createQuery("from Booking").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Booking getOneBooking(Integer bookingId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Booking booking = (Booking) s.get(Booking.class, bookingId);
        t.commit();
        s.close();
        return booking;

    }
}
