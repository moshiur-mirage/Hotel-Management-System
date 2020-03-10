package com.mirage.hms.model;
// Generated 01-Mar-2020 22:54:27 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,catalog="hms"
)
public class Role  implements java.io.Serializable {


     private int roleId;
     private String roleName;

    public Role() {
    }

	
    public Role(int roleId) {
        this.roleId = roleId;
    }
    public Role(int roleId, String roleName) {
       this.roleId = roleId;
       this.roleName = roleName;
    }
   
     @Id 

    
    @Column(name="roleId", unique=true, nullable=false)
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    
    @Column(name="roleName", length=45)
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }




}


