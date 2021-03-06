/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.service.interfaces.PaymentService;
import com.mirage.hms.model.Payment;
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
@RequestMapping("/admin/")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    
    //show all
    @GetMapping("/payment")
    public List<Payment>getPaymentlist(){
        return paymentService.viewAllPayment();        
    }
    
    
    //create 
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        return paymentService.insertPayment(payment);
    }
    // view by id
    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable("paymentId") Integer paymentId){
        Payment payment = paymentService.getOnePayment(paymentId);
        if(payment == null){
            //no payment found in browser
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Payment>(payment,HttpStatus.OK);
        }
    }
    
    // update payment 
    @PutMapping(value="/payment/{paymentId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Payment> updatePayment(@PathVariable("paymentId") Integer paymentId, @RequestBody Payment payment) {
        System.out.println("Updating Payment " + paymentId);
         
        Payment currentPayment = paymentService.getOnePayment(paymentId);
         
        if (currentPayment==null) {
            System.out.println("Payment with id " + paymentId + " not found");
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
 
        
        currentPayment.setCustomerId(payment.getCustomerId());
        currentPayment.setAmount(payment.getAmount());
        currentPayment.setDate(payment.getDate());
        currentPayment.setBookingId(payment.getBookingId());
        currentPayment.setPaymentId(payment.getPaymentId());
        
         
        paymentService.updatePayment(currentPayment);
        return new ResponseEntity<Payment>(currentPayment, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/payment/{paymentId}")
    public ResponseEntity<Payment> deletePayment(@PathVariable("paymentId") Integer paymentId) {
        System.out.println("Fetching & Deleting Category with id " + paymentId);

        Payment payment = paymentService.getOnePayment(paymentId);
        if (payment == null) {
            System.out.println("Unable to delete. Category with id " + paymentId + " not found");
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }

        paymentService.deletePayment(paymentId);
        return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);
    }
}
