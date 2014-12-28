/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Worklogs;

/**
 *
 * @author Chep
 */
@Stateless
public class WorklogsFacade extends AbstractFacade<Worklogs> implements WorklogsFacadeLocal {

    public WorklogsFacade() {
        super(Worklogs.class);
    }

    @Override
    public Worklogs createWorklogs(Worklogs entity) {
        return this.create(entity);
    }

    @Override
    public void editWorklogs(Worklogs entity) {
        this.edit(entity);
    }

    @Override
    public void deleteWorklogs(Worklogs entity) {
        this.delete(entity);
    }

    @Override
    public Worklogs getWorklogs(int id) {
        return this.get(id);
    }

    @Override
    public List<Worklogs> listWorklogs() {
        return this.list();
    }

    @Override
    public int countWorklogs() {
        return this.count();
    }  
    
}