/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Trainingsuserslink;

/**
 *
 * @author Chep
 */
@Stateless
public class TrainingsuserslinkFacade extends AbstractFacade<Trainingsuserslink> implements TrainingsuserslinkFacadeLocal {

    public TrainingsuserslinkFacade() {
        super(Trainingsuserslink.class);
    }

    @Override
    public Trainingsuserslink createTrainingsuserslink(Trainingsuserslink entity) {
        return this.create(entity);
    }

    @Override
    public void editTrainingsuserslink(Trainingsuserslink entity) {
        this.edit(entity);
    }

    @Override
    public void deleteTrainingsuserslink(Trainingsuserslink entity) {
        this.delete(entity);
    }

    @Override
    public Trainingsuserslink getTrainingsuserslink(int id) {
        return this.get(id);
    }

    @Override
    public List<Trainingsuserslink> listTrainingsuserslink() {
        return this.list();
    }

    @Override
    public int countTrainingsuserslink() {
        return this.count();
    }  
    
}