/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Method;
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
public class MethodDaoImpl implements MethodDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Method insertMethod(Method method) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(method);
        t.commit();
        s.close();
        return method;
    }

    @Override
    public void updateMethod(Method method) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(method);
        t.commit();
        s.close();
    }
    
    

    @Override
    public void deleteMethod(Integer methodId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Method method = (Method) s.get(Method.class, methodId);
        s.delete(method);
        t.commit();
        s.close();
    }

    @Override
    public List<Method> viewAllMethod() {
//        List<Method> list = sessionFactory.getCurrentSession().createQuery("from Method").list();
//        return list;

        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Method> list = s.createQuery("from Method").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Method getOneMethod(Integer methodId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Method method = (Method) s.get(Method.class, methodId);
        t.commit();
        s.close();
        return method;

    }
}
