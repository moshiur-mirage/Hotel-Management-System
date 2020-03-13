/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.implementation;

import com.mirage.hms.dao.interfaces.CustomerDao;
import com.mirage.hms.model.Customer;
import com.mirage.hms.model.Customer;
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
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Customer insertCustomer(Customer customer) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(customer);
        t.commit();
        s.close();
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(customer);
        t.commit();
        s.close();
        
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customer customer = (Customer) s.get(Customer.class, customerId);
        s.delete(customer);
        t.commit();
        s.close();
    }

    @Override
    public List<Customer> viewAllCustomer() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Customer> list = s.createQuery("from Customer").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Customer getOneCustomer(Integer customerId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customer customer = (Customer) s.get(Customer.class, customerId);
        t.commit();
        s.close();
        return customer;
    }


    @Override
    public Customer viewCustomerByName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Criteria crit = s.createCriteria(Customer.class);
        crit.add(Restrictions.eq("username", name));
        Customer customer = (Customer) crit.uniqueResult();
        t.commit();
        s.close();
        return customer;
    }
    
}
