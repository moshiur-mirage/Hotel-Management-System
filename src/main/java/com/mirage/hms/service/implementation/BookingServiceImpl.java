/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.BookingDao;
import com.mirage.hms.model.Booking;
import com.mirage.hms.service.interfaces.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("bookingService")
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingDao bookingDao;
    @Override
    public Booking insertBooking(Booking booking) {
        return bookingDao.insertBooking(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDao.updateBooking(booking);
    }

    @Override
    public void deleteBooking(Integer bookingId) {
        bookingDao.deleteBooking(bookingId);
    }

    @Override
    public List<Booking> viewAllBooking() {
        return bookingDao.viewAllBooking();
    }

    @Override
    public Booking getOneBooking(Integer bookingId) {
        return bookingDao.getOneBooking(bookingId);
    }
    
}
