/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.ServiceDetailsDao;
import com.mirage.hms.model.ServiceDetails;
import com.mirage.hms.service.interfaces.ServiceDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("serviceDetailsService")
public class ServiceDetailsServiceImpl implements ServiceDetailsService{
    @Autowired
    private ServiceDetailsDao serviceDetailsDao;
    @Override
    public ServiceDetails insertServiceDetails(ServiceDetails serviceDetails) {
        return serviceDetailsDao.insertServiceDetails(serviceDetails);
    }

    @Override
    public void updateServiceDetails(ServiceDetails serviceDetails) {
        serviceDetailsDao.updateServiceDetails(serviceDetails);
    }

    @Override
    public void deleteServiceDetails(Integer serviceDetailsId) {
        serviceDetailsDao.deleteServiceDetails(serviceDetailsId);
    }

    @Override
    public List<ServiceDetails> viewAllServiceDetails() {
        return serviceDetailsDao.viewAllServiceDetails();
    }

    @Override
    public ServiceDetails getOneServiceDetails(Integer serviceDetailsId) {
        return serviceDetailsDao.getOneServiceDetails(serviceDetailsId);
    }


    @Override
    public ServiceDetails viewServiceDetailsByName(String name) {
        return serviceDetailsDao.viewServiceDetailsByName(name);
    }
}
