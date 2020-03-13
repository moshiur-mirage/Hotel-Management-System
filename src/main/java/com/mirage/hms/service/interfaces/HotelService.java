/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.interfaces;

import com.mirage.hms.dao.interfaces.*;
import com.mirage.hms.model.Hotel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service
public interface HotelService {
    public Hotel insertHotel(Hotel hotel);

    public void updateHotel(Hotel hotel);

    public void deleteHotel(Integer hotelId);

    public List<Hotel> viewAllHotel();

    public Hotel getOneHotel(Integer hotelId);
}
