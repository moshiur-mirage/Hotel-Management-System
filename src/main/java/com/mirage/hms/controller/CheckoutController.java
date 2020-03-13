/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.model.Checkout;
import com.mirage.hms.service.interfaces.CheckoutService;
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
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;
    
    //show all
    @GetMapping("/checkout")
    public List<Checkout>getCheckoutlist(){
        return checkoutService.viewAllCheckout();        
    
    }
    

    
    //create 
    @PostMapping("/checkout")
    public Checkout createCheckout(@RequestBody Checkout checkout){
        return checkoutService.insertCheckout(checkout);
    }
    // view by id
    @GetMapping("/checkout/{checkoutId}")
    public ResponseEntity<Checkout> getCheckout(@PathVariable("checkoutId") Integer checkoutId){
        Checkout checkout = checkoutService.getOneCheckout(checkoutId);
        if(checkout == null){
            //no checkout found in browser
            return new ResponseEntity<Checkout>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Checkout>(checkout,HttpStatus.OK);
        }
    }
    
    // update checkout 
    @PutMapping(value="/checkout/{checkoutId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Checkout> updateCheckout(@PathVariable("checkoutId") Integer checkoutId, @RequestBody Checkout checkout) {
        System.out.println("Updating Checkout " + checkoutId);
         
        Checkout currentCheckout = checkoutService.getOneCheckout(checkoutId);
         
        if (currentCheckout==null) {
            System.out.println("Checkout with id " + checkoutId + " not found");
            return new ResponseEntity<Checkout>(HttpStatus.NOT_FOUND);
        }
 
        currentCheckout.setCheckoutId(checkout.getCheckoutId());
        currentCheckout.setCustomerId(checkout.getCustomerId());
        currentCheckout.setBookingId(checkout.getBookingId());
        currentCheckout.setTotalPay(checkout.getTotalPay());
        currentCheckout.setDate(checkout.getDate());
        
              
        
         
        checkoutService.updateCheckout(currentCheckout);
        return new ResponseEntity<Checkout>(currentCheckout, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/checkout/{checkoutId}")
    public ResponseEntity<Checkout> deleteCheckout(@PathVariable("checkoutId") Integer checkoutId) {
        System.out.println("Fetching & Deleting Category with id " + checkoutId);

        Checkout checkout = checkoutService.getOneCheckout(checkoutId);
        if (checkout == null) {
            System.out.println("Unable to delete. Category with id " + checkoutId + " not found");
            return new ResponseEntity<Checkout>(HttpStatus.NOT_FOUND);
        }

        checkoutService.deleteCheckout(checkoutId);
        return new ResponseEntity<Checkout>(HttpStatus.NO_CONTENT);
    }
}
