/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.service.interfaces.ServiceDetailsService;
import com.mirage.hms.model.ServiceDetails;
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
public class ServiceDetailsController {
    @Autowired
    private ServiceDetailsService serviceDetailsService;
    
    //show all
    @GetMapping("/serviceDetails")
    public List<ServiceDetails>getServiceDetailslist(){
        return serviceDetailsService.viewAllServiceDetails();        
    
    }
    
    //get serviceDetails by name
    @GetMapping("/serviceDetails/service/{name}")
    public ResponseEntity<ServiceDetails> getServiceDetailsByName(@PathVariable("name") String name){
        ServiceDetails serviceDetails  = serviceDetailsService.viewServiceDetailsByName(name);
        if(serviceDetails == null){
            return new ResponseEntity<ServiceDetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ServiceDetails>(serviceDetails,HttpStatus.OK);
    }
    
    //create 
    @PostMapping("/serviceDetails")
    public ServiceDetails createServiceDetails(@RequestBody ServiceDetails serviceDetails){
        return serviceDetailsService.insertServiceDetails(serviceDetails);
    }
    // view by id
    @GetMapping("/serviceDetails/{serviceDetailsId}")
    public ResponseEntity<ServiceDetails> getServiceDetails(@PathVariable("serviceDetailsId") Integer serviceDetailsId){
        ServiceDetails serviceDetails = serviceDetailsService.getOneServiceDetails(serviceDetailsId);
        if(serviceDetails == null){
            //no serviceDetails found in browser
            return new ResponseEntity<ServiceDetails>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<ServiceDetails>(serviceDetails,HttpStatus.OK);
        }
    }
    
    // update serviceDetails 
    @PutMapping(value="/serviceDetails/{serviceDetailsId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<ServiceDetails> updateServiceDetails(@PathVariable("serviceDetailsId") Integer serviceDetailsId, @RequestBody ServiceDetails serviceDetails) {
        System.out.println("Updating ServiceDetails " + serviceDetailsId);
         
        ServiceDetails currentServiceDetails = serviceDetailsService.getOneServiceDetails(serviceDetailsId);
         
        if (currentServiceDetails==null) {
            System.out.println("ServiceDetails with id " + serviceDetailsId + " not found");
            return new ResponseEntity<ServiceDetails>(HttpStatus.NOT_FOUND);
        }
 
        currentServiceDetails.setServiceDetailsId(serviceDetails.getServiceDetailsId());
        currentServiceDetails.setName(serviceDetails.getName());
        currentServiceDetails.setCost(serviceDetails.getCost());
        
         
        serviceDetailsService.updateServiceDetails(currentServiceDetails);
        return new ResponseEntity<ServiceDetails>(currentServiceDetails, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/serviceDetails/{serviceDetailsId}")
    public ResponseEntity<ServiceDetails> deleteServiceDetails(@PathVariable("serviceDetailsId") Integer serviceDetailsId) {
        System.out.println("Fetching & Deleting Category with id " + serviceDetailsId);

        ServiceDetails serviceDetails = serviceDetailsService.getOneServiceDetails(serviceDetailsId);
        if (serviceDetails == null) {
            System.out.println("Unable to delete. Category with id " + serviceDetailsId + " not found");
            return new ResponseEntity<ServiceDetails>(HttpStatus.NOT_FOUND);
        }

        serviceDetailsService.deleteServiceDetails(serviceDetailsId);
        return new ResponseEntity<ServiceDetails>(HttpStatus.NO_CONTENT);
    }
}
