/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Chatterresourceslink;

/**
 *
 * @author Chep
 */
@Stateless
public class ChatterresourceslinkFacade extends AbstractFacade<Chatterresourceslink> implements ChatterresourceslinkFacadeLocal {

    public ChatterresourceslinkFacade() {
        super(Chatterresourceslink.class);
    }

    @Override
    public Chatterresourceslink createChatterresourceslink(Chatterresourceslink entity) {
        return this.create(entity);
    }

    @Override
    public void editChatterresourceslink(Chatterresourceslink entity) {
        this.edit(entity);
    }

    @Override
    public void deleteChatterresourceslink(Chatterresourceslink entity) {
        this.delete(entity);
    }

    @Override
    public Chatterresourceslink getChatterresourceslink(int id) {
        return this.get(id);
    }

    @Override
    public List<Chatterresourceslink> listChatterresourceslink() {
        return this.list();
    }

    @Override
    public int countChatterresourceslink() {
        return this.count();
    }  
    
}