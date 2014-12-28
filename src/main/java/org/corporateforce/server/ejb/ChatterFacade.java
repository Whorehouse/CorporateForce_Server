/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Chatter;

/**
 *
 * @author Chep
 */
@Stateless
public class ChatterFacade extends AbstractFacade<Chatter> implements ChatterFacadeLocal {

    public ChatterFacade() {
        super(Chatter.class);
    }

    @Override
    public Chatter createChatter(Chatter entity) {
        return this.create(entity);
    }

    @Override
    public void editChatter(Chatter entity) {
        this.edit(entity);
    }

    @Override
    public void deleteChatter(Chatter entity) {
        this.delete(entity);
    }

    @Override
    public Chatter getChatter(int id) {
        return this.get(id);
    }

    @Override
    public List<Chatter> listChatter() {
        return this.list();
    }

    @Override
    public int countChatter() {
        return this.count();
    }  
    
}