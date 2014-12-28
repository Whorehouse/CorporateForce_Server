/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Roles;

/**
 *
 * @author Chep
 */
@Stateless
public class RolesFacade extends AbstractFacade<Roles> implements RolesFacadeLocal {

    public RolesFacade() {
        super(Roles.class);
    }

    @Override
    public Roles createRoles(Roles entity) {
        return this.create(entity);
    }

    @Override
    public void editRoles(Roles entity) {
        this.edit(entity);
    }

    @Override
    public void deleteRoles(Roles entity) {
        this.delete(entity);
    }

    @Override
    public Roles getRoles(int id) {
        return this.get(id);
    }

    @Override
    public List<Roles> listRoles() {
        return this.list();
    }

    @Override
    public int countRoles() {
        return this.count();
    }  
    
}