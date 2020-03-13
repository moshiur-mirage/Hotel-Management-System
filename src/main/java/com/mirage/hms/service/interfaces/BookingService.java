/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.interfaces;

import com.mirage.hms.dao.interfaces.*;
import com.mirage.hms.model.Booking;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service
public interface BookingService {
    public Booking insertBooking(Booking booking);

    public void updateBooking(Booking booking);

    public void deleteBooking(Integer bookingId);

    public List<Booking> viewAllBooking();

    public Booking getOneBooking(Integer bookingId);
    
    
    
}
