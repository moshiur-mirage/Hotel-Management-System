/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.interfaces;

import com.mirage.hms.dao.interfaces.*;
import com.mirage.hms.model.Method;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service
public interface MethodService {
    public Method insertMethod(Method method);

    public void updateMethod(Method method);

    public void deleteMethod(Integer methodId);

    public List<Method> viewAllMethod();

    public Method getOneMethod(Integer methodId);
}
