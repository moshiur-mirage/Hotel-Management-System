/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.dao.MethodDao;
import com.mirage.hms.model.Method;
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
@RequestMapping("/admin")
public class MethodController {
    
     @Autowired
    private MethodDao methodDao;
    
    //show all
    @GetMapping("/method")
    public List<Method>getMethodlist(){
        return methodDao.viewAllMethod();        
    }
    
    
    //create 
    @PostMapping("/method")
    public Method createMethod(@RequestBody Method method){
        return methodDao.insertMethod(method);
    }
    // view by id
    @GetMapping("/method/{methodId}")
    public ResponseEntity<Method> getMethod(@PathVariable("methodId") Integer methodId){
        Method method = methodDao.getOneMethod(methodId);
        if(method == null){
            //no method found in browser
            return new ResponseEntity<Method>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Method>(method,HttpStatus.OK);
        }
    }
    
    // update method 
    @PutMapping(value="/method/{methodId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Method> updateMethod(@PathVariable("methodId") Integer methodId, @RequestBody Method method) {
        System.out.println("Updating Method " + methodId);
         
        Method currentMethod = methodDao.getOneMethod(methodId);
         
        if (currentMethod==null) {
            System.out.println("Method with id " + methodId + " not found");
            return new ResponseEntity<Method>(HttpStatus.NOT_FOUND);
        }
 
        
        currentMethod.setName(method.getName());
        currentMethod.setMethodId(method.getMethodId());
        currentMethod.setDesc(method.getDesc());
        
         
        methodDao.updateMethod(currentMethod);
        return new ResponseEntity<Method>(currentMethod, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/method/{methodId}")
    public ResponseEntity<Method> deleteUser(@PathVariable("methodId") Integer methodId) {
        System.out.println("Fetching & Deleting Category with id " + methodId);

        Method method = methodDao.getOneMethod(methodId);
        if (method == null) {
            System.out.println("Unable to delete. Category with id " + methodId + " not found");
            return new ResponseEntity<Method>(HttpStatus.NOT_FOUND);
        }

        methodDao.deleteMethod(methodId);
        return new ResponseEntity<Method>(HttpStatus.NO_CONTENT);
    }
}
