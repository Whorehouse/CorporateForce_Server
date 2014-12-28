/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Resources;

/**
 *
 * @author Chep
 */
@Stateless
public class ResourcesFacade extends AbstractFacade<Resources> implements ResourcesFacadeLocal {

    public ResourcesFacade() {
        super(Resources.class);
    }

    @Override
    public Resources createResources(Resources entity) {
        return this.create(entity);
    }

    @Override
    public void editResources(Resources entity) {
        this.edit(entity);
    }

    @Override
    public void deleteResources(Resources entity) {
        this.delete(entity);
    }

    @Override
    public Resources getResources(int id) {
        return this.get(id);
    }

    @Override
    public List<Resources> listResources() {
        return this.list();
    }

    @Override
    public int countResources() {
        return this.count();
    }  
    
}