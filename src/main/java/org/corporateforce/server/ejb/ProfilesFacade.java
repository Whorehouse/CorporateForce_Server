/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Profiles;

/**
 *
 * @author Chep
 */
@Stateless
public class ProfilesFacade extends AbstractFacade<Profiles> implements ProfilesFacadeLocal {

    public ProfilesFacade() {
        super(Profiles.class);
    }

    @Override
    public Profiles createProfiles(Profiles entity) {
        return this.create(entity);
    }

    @Override
    public void editProfiles(Profiles entity) {
        this.edit(entity);
    }

    @Override
    public void deleteProfiles(Profiles entity) {
        this.delete(entity);
    }

    @Override
    public Profiles getProfiles(int id) {
        return this.get(id);
    }

    @Override
    public List<Profiles> listProfiles() {
        return this.list();
    }

    @Override
    public int countProfiles() {
        return this.count();
    }  
    
}