/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Trainings;

/**
 *
 * @author Chep
 */
@Stateless
public class TrainingsFacade extends AbstractFacade<Trainings> implements TrainingsFacadeLocal {

    public TrainingsFacade() {
        super(Trainings.class);
    }

    @Override
    public Trainings createTrainings(Trainings entity) {
        return this.create(entity);
    }

    @Override
    public void editTrainings(Trainings entity) {
        this.edit(entity);
    }

    @Override
    public void deleteTrainings(Trainings entity) {
        this.delete(entity);
    }

    @Override
    public Trainings getTrainings(int id) {
        return this.get(id);
    }

    @Override
    public List<Trainings> listTrainings() {
        return this.list();
    }

    @Override
    public int countTrainings() {
        return this.count();
    }  
    
}