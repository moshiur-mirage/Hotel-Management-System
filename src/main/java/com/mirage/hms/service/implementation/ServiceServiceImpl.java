/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;


import com.mirage.hms.dao.interfaces.ServiceDao;
import com.mirage.hms.model.Service;
import com.mirage.hms.service.interfaces.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mirage
 */
@org.springframework.stereotype.Service("serviceService")
public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private ServiceDao serviceDao;
    @Override
    public Service insertService(Service service) {
        return serviceDao.insertService(service);
    }

    @Override
    public void updateService(Service service) {
        serviceDao.updateService(service);
    }

    @Override
    public void deleteService(Integer serviceId) {
        serviceDao.deleteService(serviceId);
    }

    @Override
    public List<Service> viewAllService() {
        return serviceDao.viewAllService();
    }

    @Override
    public Service getOneService(Integer serviceId) {
        return serviceDao.getOneService(serviceId);
    }
    
}
