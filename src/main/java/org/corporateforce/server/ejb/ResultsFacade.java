/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Results;

/**
 *
 * @author Chep
 */
@Stateless
public class ResultsFacade extends AbstractFacade<Results> implements ResultsFacadeLocal {

    public ResultsFacade() {
        super(Results.class);
    }

    @Override
    public Results createResults(Results entity) {
        return this.create(entity);
    }

    @Override
    public void editResults(Results entity) {
        this.edit(entity);
    }

    @Override
    public void deleteResults(Results entity) {
        this.delete(entity);
    }

    @Override
    public Results getResults(int id) {
        return this.get(id);
    }

    @Override
    public List<Results> listResults() {
        return this.list();
    }

    @Override
    public int countResults() {
        return this.count();
    }  
    
}