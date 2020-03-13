/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.implementation;

import com.mirage.hms.dao.interfaces.CheckoutDao;
import com.mirage.hms.model.Checkout;
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
public class CheckoutDaoImpl implements CheckoutDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Checkout insertCheckout(Checkout checkout) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(checkout);
        t.commit();
        s.close();
        return checkout;
    }

    @Override
    public void updateCheckout(Checkout checkout) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(checkout);
        t.commit();
        s.close();
        
    }

    @Override
    public void deleteCheckout(Integer checkoutId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Checkout checkout = (Checkout) s.get(Checkout.class, checkoutId);
        s.delete(checkout);
        t.commit();
        s.close();
    }

    @Override
    public List<Checkout> viewAllCheckout() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Checkout> list = s.createQuery("from Checkout").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Checkout getOneCheckout(Integer checkoutId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Checkout checkout = (Checkout) s.get(Checkout.class, checkoutId);
        t.commit();
        s.close();
        return checkout;
    }
}
