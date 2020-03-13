/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.service.interfaces.UserService;
import com.mirage.hms.model.User;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirage
 */
@RestController
@RequestMapping(value="/admin/")
public class UserController {
    @Autowired
    private UserService userService;
    
    //show all
    @GetMapping("/user")
    public List<User>getUserlist(){
        return userService.viewAllUser();        
    
    }
    
    //get user by name
    @GetMapping("/user/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable("name") String name){
        User user  = userService.viewUserByName(name);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    
    //create 
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.insertUser(user);
    }
    // view by id
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId){
        User user = userService.getOneUser(userId);
        if(user == null){
            //no user found in browser
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
    }
    
    // update user 
    @PutMapping(value="/user/{userId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        System.out.println("Updating User " + userId);
         
        User currentUser = userService.getOneUser(userId);
         
        if (currentUser==null) {
            System.out.println("User with id " + userId + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUserId(user.getUserId());
        currentUser.setName(user.getName());
        currentUser.setRoleId(user.getRoleId());
        currentUser.setPassword(user.getPassword());
        currentUser.setCreateDate(user.getCreateDate());
              
        
         
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("Fetching & Deleting Category with id " + userId);

        User user = userService.getOneUser(userId);
        if (user == null) {
            System.out.println("Unable to delete. Category with id " + userId + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUser(userId);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
