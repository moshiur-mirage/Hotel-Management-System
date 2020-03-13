/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.interfaces;

import com.mirage.hms.model.Payment;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */

public interface PaymentDao {
    public Payment insertPayment(Payment payment);

    public void updatePayment(Payment payment);

    public void deletePayment(Integer paymentId);

    public List<Payment> viewAllPayment();

    public Payment getOnePayment(Integer paymentId);
}
