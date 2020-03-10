/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Service;
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
public class ServiceDaoImpl implements ServiceDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Service insertService(Service service) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(service);
        t.commit();
        s.close();
        return service;
    }

    @Override
    public void updateService(Service service) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(service);
        t.commit();
        s.close();
    }
    
    

    @Override
    public void deleteService(Integer serviceId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Service service = (Service) s.get(Service.class, serviceId);
        s.delete(service);
        t.commit();
        s.close();
    }

    @Override
    public List<Service> viewAllService() {
//        List<Service> list = sessionFactory.getCurrentSession().createQuery("from Service").list();
//        return list;

        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Service> list = s.createQuery("from Service").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Service getOneService(Integer serviceId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Service service = (Service) s.get(Service.class, serviceId);
        t.commit();
        s.close();
        return service;

    }
}
