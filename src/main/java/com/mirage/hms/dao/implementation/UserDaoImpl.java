/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.implementation;

import com.mirage.hms.dao.interfaces.UserDao;
import com.mirage.hms.model.User;

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
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public User insertUser(User user) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(user);
        t.commit();
        s.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(user);
        t.commit();
        s.close();
        
    }

    @Override
    public void deleteUser(Integer userId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        User user = (User) s.get(User.class, userId);
        s.delete(user);
        t.commit();
        s.close();
    }

    @Override
    public List<User> viewAllUser() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<User> list = s.createQuery("from User").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public User getOneUser(Integer userId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        User user = (User) s.get(User.class, userId);
        t.commit();
        s.close();
        return user;
    }

    @Override
    public void register(User suer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User validateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User viewUserByName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Criteria crit = s.createCriteria(User.class);
        crit.add(Restrictions.eq("name", name));
        User user = (User) crit.uniqueResult();
        t.commit();
        s.close();
        return user;
    }
    
}
