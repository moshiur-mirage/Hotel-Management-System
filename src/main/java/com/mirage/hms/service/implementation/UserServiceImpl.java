/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.UserDao;
import com.mirage.hms.dao.interfaces.UserDao;
import com.mirage.hms.model.User;
import com.mirage.hms.model.User;
import com.mirage.hms.service.interfaces.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public List<User> viewAllUser() {
        return userDao.viewAllUser();
    }

    @Override
    public User getOneUser(Integer userId) {
        return userDao.getOneUser(userId);
    }



    @Override
    public User viewUserByName(String name) {
       return userDao.viewUserByName(name);
    }
}
