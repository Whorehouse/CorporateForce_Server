/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Tutorials;

/**
 *
 * @author Chep
 */
@Stateless
public class TutorialsFacade extends AbstractFacade<Tutorials> implements TutorialsFacadeLocal {

    public TutorialsFacade() {
        super(Tutorials.class);
    }

    @Override
    public Tutorials createTutorials(Tutorials entity) {
        return this.create(entity);
    }

    @Override
    public void editTutorials(Tutorials entity) {
        this.edit(entity);
    }

    @Override
    public void deleteTutorials(Tutorials entity) {
        this.delete(entity);
    }

    @Override
    public Tutorials getTutorials(int id) {
        return this.get(id);
    }

    @Override
    public List<Tutorials> listTutorials() {
        return this.list();
    }

    @Override
    public int countTutorials() {
        return this.count();
    }  
    
}