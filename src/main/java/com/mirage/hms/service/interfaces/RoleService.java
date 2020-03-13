/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.service.interfaces;

import com.mirage.hms.dao.interfaces.*;
import com.mirage.hms.model.Role;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author mirage
 */
@Service
public interface RoleService {

    public Role insertRole(Role role);

    public void updateRole(Role role);

    public void deleteRole(Integer roleId);

    public List<Role> viewAllRole();

    public Role getOneRole(Integer roleId);

}
