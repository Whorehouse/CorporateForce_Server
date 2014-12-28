/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Objectives;

/**
 *
 * @author Chep
 */
@Stateless
public class ObjectivesFacade extends AbstractFacade<Objectives> implements ObjectivesFacadeLocal {

    public ObjectivesFacade() {
        super(Objectives.class);
    }

    @Override
    public Objectives createObjectives(Objectives entity) {
        return this.create(entity);
    }

    @Override
    public void editObjectives(Objectives entity) {
        this.edit(entity);
    }

    @Override
    public void deleteObjectives(Objectives entity) {
        this.delete(entity);
    }

    @Override
    public Objectives getObjectives(int id) {
        return this.get(id);
    }

    @Override
    public List<Objectives> listObjectives() {
        return this.list();
    }

    @Override
    public int countObjectives() {
        return this.count();
    }  
    
}