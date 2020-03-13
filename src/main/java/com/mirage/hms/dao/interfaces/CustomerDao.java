/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao.interfaces;

import com.mirage.hms.model.Customer;
import java.util.List;

/**
 *
 * @author mirage
 */
public interface CustomerDao {
    public Customer insertCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Integer customerId);

    public List<Customer> viewAllCustomer();

    public Customer getOneCustomer(Integer customerId);
    
    public Customer viewCustomerByName(String name);
}
