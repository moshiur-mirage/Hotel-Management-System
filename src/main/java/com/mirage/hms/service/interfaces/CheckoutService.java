/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.interfaces;

import com.mirage.hms.model.Checkout;
import java.util.List;

/**
 *
 * @author mirage
 */
public interface CheckoutService {
    public Checkout insertCheckout(Checkout checkout);

    public void updateCheckout(Checkout checkout);

    public void deleteCheckout(Integer checkoutId);

    public List<Checkout> viewAllCheckout();

    public Checkout getOneCheckout(Integer checkoutId);
}
