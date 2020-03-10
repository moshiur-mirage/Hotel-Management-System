/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service
public interface UserDao {
    public User insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer userId);

    public List<User> viewAllUser();

    public User getOneUser(Integer userId);
}
