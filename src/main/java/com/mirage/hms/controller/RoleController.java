/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirage.hms.controller;

import com.mirage.hms.dao.RoleDao;
import com.mirage.hms.model.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirage
 */
@RestController
@RequestMapping(value= "/admin/")
public class RoleController {

    @Autowired
    private RoleDao roleDao;
    
    //show all
    @GetMapping("/role")
    public List<Role>getRolelist(){
        return roleDao.viewAllRole();        
    }
    
    
    //create 
    @PostMapping("/role")
    public Role createRole(@RequestBody Role role){
        return roleDao.insertRole(role);
    }
    // view by id
    @GetMapping("/role/{roleId}")
    public ResponseEntity<Role> getRole(@PathVariable("roleId") Integer roleId){
        Role role = roleDao.getOneRole(roleId);
        if(role == null){
            //no role found in browser
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Role>(role,HttpStatus.OK);
        }
    }
    
    // update role 
    @PutMapping(value="/role/{roleId}",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Role> updateRole(@PathVariable("roleId") Integer roleId, @RequestBody Role role) {
        System.out.println("Updating Role " + roleId);
         
        Role currentRole = roleDao.getOneRole(roleId);
         
        if (currentRole==null) {
            System.out.println("Role with id " + roleId + " not found");
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
 
        
        currentRole.setRoleName(role.getRoleName());
        currentRole.setRoleId(role.getRoleId());
        
         
        roleDao.updateRole(currentRole);
        return new ResponseEntity<Role>(currentRole, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/role/{roleId}")
    public ResponseEntity<Role> deleteUser(@PathVariable("roleId") Integer roleId) {
        System.out.println("Fetching & Deleting Category with id " + roleId);

        Role role = roleDao.getOneRole(roleId);
        if (role == null) {
            System.out.println("Unable to delete. Category with id " + roleId + " not found");
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }

        roleDao.deleteRole(roleId);
        return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
    }
    
    //view by name
}
