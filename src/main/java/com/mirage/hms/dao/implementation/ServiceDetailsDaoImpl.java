/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.implementation;

import com.mirage.hms.dao.interfaces.ServiceDetailsDao;
import com.mirage.hms.model.ServiceDetails;
import com.mirage.hms.model.ServiceDetails;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mirage
 */
@Repository
@Transactional
public class ServiceDetailsDaoImpl implements ServiceDetailsDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public ServiceDetails insertServiceDetails(ServiceDetails serviceDetails) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(serviceDetails);
        t.commit();
        s.close();
        return serviceDetails;
    }

    @Override
    public void updateServiceDetails(ServiceDetails serviceDetails) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(serviceDetails);
        t.commit();
        s.close();
        
    }

    @Override
    public void deleteServiceDetails(Integer serviceDetailsId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        ServiceDetails serviceDetails = (ServiceDetails) s.get(ServiceDetails.class, serviceDetailsId);
        s.delete(serviceDetails);
        t.commit();
        s.close();
    }

    @Override
    public List<ServiceDetails> viewAllServiceDetails() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<ServiceDetails> list = s.createQuery("from ServiceDetails").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public ServiceDetails getOneServiceDetails(Integer serviceDetailsId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        ServiceDetails serviceDetails = (ServiceDetails) s.get(ServiceDetails.class, serviceDetailsId);
        t.commit();
        s.close();
        return serviceDetails;
    }



    @Override
    public ServiceDetails viewServiceDetailsByName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Criteria crit = s.createCriteria(ServiceDetails.class);
        crit.add(Restrictions.eq("name", name));
        ServiceDetails serviceDetails = (ServiceDetails) crit.uniqueResult();
        t.commit();
        s.close();
        return serviceDetails;
    }
    
}
