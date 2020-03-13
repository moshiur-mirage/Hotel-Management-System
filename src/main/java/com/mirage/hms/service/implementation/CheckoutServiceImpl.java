/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.CheckoutDao;
import com.mirage.hms.model.Checkout;
import com.mirage.hms.service.interfaces.CheckoutService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("checkoutService")
public class CheckoutServiceImpl implements CheckoutService{
    
    @Autowired
    private CheckoutDao checkoutDao;
    @Override
    public Checkout insertCheckout(Checkout checkout) {
        return checkoutDao.insertCheckout(checkout);
    }

    @Override
    public void updateCheckout(Checkout checkout) {
         checkoutDao.updateCheckout(checkout);
    }

    @Override
    public void deleteCheckout(Integer checkoutId) {
        checkoutDao.deleteCheckout(checkoutId);
    }

    @Override
    public List<Checkout> viewAllCheckout() {
       return checkoutDao.viewAllCheckout();
    }

    @Override
    public Checkout getOneCheckout(Integer checkoutId) {
       return checkoutDao.getOneCheckout(checkoutId);
    }
}
