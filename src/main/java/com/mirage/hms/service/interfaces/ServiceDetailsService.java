/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.interfaces;

import com.mirage.hms.dao.interfaces.*;
import com.mirage.hms.model.ServiceDetails;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */

public interface ServiceDetailsService {
    public ServiceDetails insertServiceDetails(ServiceDetails serviceDetails);

    public void updateServiceDetails(ServiceDetails serviceDetails);

    public void deleteServiceDetails(Integer serviceDetailsId);

    public List<ServiceDetails> viewAllServiceDetails();

    public ServiceDetails getOneServiceDetails(Integer serviceDetailsId);

    
    public ServiceDetails viewServiceDetailsByName(String name);
}
