/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Payment;
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
public class PaymentDaoImpl implements PaymentDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Payment insertPayment(Payment payment) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(payment);
        t.commit();
        s.close();
        return payment;
    }

    @Override
    public void updatePayment(Payment payment) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(payment);
        t.commit();
        s.close();
    }
    
    

    @Override
    public void deletePayment(Integer paymentId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment payment = (Payment) s.get(Payment.class, paymentId);
        s.delete(payment);
        t.commit();
        s.close();
    }

    @Override
    public List<Payment> viewAllPayment() {
//        List<Payment> list = sessionFactory.getCurrentSession().createQuery("from Payment").list();
//        return list;

        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment> list = s.createQuery("from Payment").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Payment getOnePayment(Integer paymentId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment payment = (Payment) s.get(Payment.class, paymentId);
        t.commit();
        s.close();
        return payment;

    }
}
