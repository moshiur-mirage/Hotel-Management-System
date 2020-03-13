/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.PaymentDao;
import com.mirage.hms.model.Payment;
import com.mirage.hms.service.interfaces.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public Payment insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDao.updatePayment(payment);
    }

    @Override
    public void deletePayment(Integer paymentId) {
        paymentDao.deletePayment(paymentId);
    }

    @Override
    public List<Payment> viewAllPayment() {
        return paymentDao.viewAllPayment();
    }

    @Override
    public Payment getOnePayment(Integer paymentId) {
        return paymentDao.getOnePayment(paymentId);
    }
}
