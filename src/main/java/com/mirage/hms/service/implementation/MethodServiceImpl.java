/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.MethodDao;
import com.mirage.hms.model.Method;
import com.mirage.hms.service.interfaces.MethodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("methodService")
public class MethodServiceImpl implements MethodService{
    @Autowired
    private MethodDao methodDao;
    @Override
    public Method insertMethod(Method method) {
        return methodDao.insertMethod(method);
    }

    @Override
    public void updateMethod(Method method) {
        methodDao.updateMethod(method);
    }

    @Override
    public void deleteMethod(Integer methodId) {
        methodDao.deleteMethod(methodId);
    }

    @Override
    public List<Method> viewAllMethod() {
        return methodDao.viewAllMethod();
    }

    @Override
    public Method getOneMethod(Integer methodId) {
        return methodDao.getOneMethod(methodId);
    }
}
