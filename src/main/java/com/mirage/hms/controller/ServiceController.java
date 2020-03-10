/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.dao.ServiceDao;
import com.mirage.hms.model.Service;
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
@RequestMapping("admin")
public class ServiceController {
    @Autowired
    private ServiceDao serviceDao;
    
    //show all
    @GetMapping("/service")
    public List<Service>getServicelist(){
        return serviceDao.viewAllService();        
    }
    
    
    //create 
    @PostMapping("/service")
    public Service createService(@RequestBody Service service){
        return serviceDao.insertService(service);
    }
    // view by id
    @GetMapping("/service/{serviceId}")
    public ResponseEntity<Service> getService(@PathVariable("serviceId") Integer serviceId){
        Service service = serviceDao.getOneService(serviceId);
        if(service == null){
            //no service found in browser
            return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Service>(service,HttpStatus.OK);
        }
    }
    
    // update service 
    @PutMapping(value="/service/{serviceId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Service> updateService(@PathVariable("serviceId") Integer serviceId, @RequestBody Service service) {
        System.out.println("Updating Service " + serviceId);
         
        Service currentService = serviceDao.getOneService(serviceId);
         
        if (currentService==null) {
            System.out.println("Service with id " + serviceId + " not found");
            return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
        }
 
        
        currentService.setUserId(service.getUserId());
        currentService.setFee(service.getFee());
        currentService.setDate(service.getDate());
        currentService.setServiceId(service.getServiceId());
        
        
         
        serviceDao.updateService(currentService);
        return new ResponseEntity<Service>(currentService, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/service/{serviceId}")
    public ResponseEntity<Service> deleteUser(@PathVariable("serviceId") Integer serviceId) {
        System.out.println("Fetching & Deleting Category with id " + serviceId);

        Service service = serviceDao.getOneService(serviceId);
        if (service == null) {
            System.out.println("Unable to delete. Category with id " + serviceId + " not found");
            return new ResponseEntity<Service>(HttpStatus.NOT_FOUND);
        }

        serviceDao.deleteService(serviceId);
        return new ResponseEntity<Service>(HttpStatus.NO_CONTENT);
    }
}
