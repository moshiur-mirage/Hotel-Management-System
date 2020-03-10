/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Role;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mirage
 */
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role insertRole(Role role) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(role);
        t.commit();
        s.close();
        return role;
    }

    @Override
    public void updateRole(Role role) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(role);
        t.commit();
        s.close();
    }
    
    

    @Override
    public void deleteRole(Integer roleId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Role role = (Role) s.get(Role.class, roleId);
        s.delete(role);
        t.commit();
        s.close();
    }

    @Override
    public List<Role> viewAllRole() {
//        List<Role> list = sessionFactory.getCurrentSession().createQuery("from Role").list();
//        return list;

        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Role> list = s.createQuery("from Role").list();
        t.commit();
        s.close();
        return list;
    }

    @Override
    public Role getOneRole(Integer roleId) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Role role = (Role) s.get(Role.class, roleId);
        t.commit();
        s.close();
        return role;

    }

}
