/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.implementation;

import com.mirage.hms.dao.interfaces.RoleDao;
import com.mirage.hms.model.Role;
import com.mirage.hms.service.interfaces.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirage
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;
    @Override
    public Role insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public List<Role> viewAllRole() {
        return roleDao.viewAllRole();
    }

    @Override
    public Role getOneRole(Integer roleId) {
        return roleDao.getOneRole(roleId);
    }
}
