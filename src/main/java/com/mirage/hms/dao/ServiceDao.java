/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.dao;

import com.mirage.hms.model.Service;
import java.util.List;

/**
 *
 * @author mirage
 */
@org.springframework.stereotype.Service
public interface ServiceDao {
    public Service insertService(Service service);

    public void updateService(Service service);

    public void deleteService(Integer serviceId);

    public List<Service> viewAllService();

    public Service getOneService(Integer serviceId);
}
