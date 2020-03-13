/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.CustomerDao;
import com.mirage.hms.model.Customer;
import com.mirage.hms.service.interfaces.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Override
    public Customer insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
         customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> viewAllCustomer() {
       return customerDao.viewAllCustomer();
    }

    @Override
    public Customer getOneCustomer(Integer customerId) {
       return customerDao.getOneCustomer(customerId);
    }

    @Override
    public Customer viewCustomerByName(String name) {
        return customerDao.viewCustomerByName(name);
    }
   

}
