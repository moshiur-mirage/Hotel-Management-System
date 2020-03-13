/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.service.interfaces.CustomerService;
import com.mirage.hms.model.Customer;
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
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    //show all
    @GetMapping("/customer")
    public List<Customer>getCustomerlist(){
        return customerService.viewAllCustomer();        
    
    }
    
    //get customer by name
    @GetMapping("/customer/name/{name}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name){
        Customer customer  = customerService.viewCustomerByName(name);
        if(customer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    
    //create 
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }
    // view by id
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Integer customerId){
        Customer customer = customerService.getOneCustomer(customerId);
        if(customer == null){
            //no customer found in browser
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Customer>(customer,HttpStatus.OK);
        }
    }
    
    // update customer 
    @PutMapping(value="/customer/{customerId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + customerId);
         
        Customer currentCustomer = customerService.getOneCustomer(customerId);
         
        if (currentCustomer==null) {
            System.out.println("Customer with id " + customerId + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
 
        currentCustomer.setCustomerId(customer.getCustomerId());
        currentCustomer.setName(customer.getName());
        currentCustomer.setEmail(customer.getEmail());
        currentCustomer.setMobile(customer.getMobile());
        currentCustomer.setCustomername(customer.getCustomername());
        currentCustomer.setPassword(customer.getPassword());
        
              
        
         
        customerService.updateCustomer(currentCustomer);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Integer customerId) {
        System.out.println("Fetching & Deleting Category with id " + customerId);

        Customer customer = customerService.getOneCustomer(customerId);
        if (customer == null) {
            System.out.println("Unable to delete. Category with id " + customerId + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        customerService.deleteCustomer(customerId);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}
