/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Offices;

/**
 *
 * @author Chep
 */
@Stateless
public class OfficesFacade extends AbstractFacade<Offices> implements OfficesFacadeLocal {

    public OfficesFacade() {
        super(Offices.class);
    }

    @Override
    public Offices createOffices(Offices entity) {
        return this.create(entity);
    }

    @Override
    public void editOffices(Offices entity) {
        this.edit(entity);
    }

    @Override
    public void deleteOffices(Offices entity) {
        this.delete(entity);
    }

    @Override
    public Offices getOffices(int id) {
        return this.get(id);
    }

    @Override
    public List<Offices> listOffices() {
        return this.list();
    }

    @Override
    public int countOffices() {
        return this.count();
    }  
    
}