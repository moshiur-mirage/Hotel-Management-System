/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.HotelDao;
import com.mirage.hms.model.Hotel;
import com.mirage.hms.service.interfaces.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("hotelService")
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelDao hotelDao;
    @Override
    public Hotel insertHotel(Hotel hotel) {
        return hotelDao.insertHotel(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelDao.updateHotel(hotel);
    }

    @Override
    public void deleteHotel(Integer hotelId) {
        hotelDao.deleteHotel(hotelId);
    }

    @Override
    public List<Hotel> viewAllHotel() {
        return hotelDao.viewAllHotel();
    }

    @Override
    public Hotel getOneHotel(Integer hotelId) {
        return hotelDao.getOneHotel(hotelId);
    }
}
