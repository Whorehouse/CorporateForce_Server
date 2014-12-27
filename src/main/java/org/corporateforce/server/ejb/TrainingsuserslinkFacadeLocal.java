/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Trainingsuserslink;

/**
 *
 * @author Chep
 */
@Local
public interface TrainingsuserslinkFacadeLocal {

    void create(Trainingsuserslink trainingsuserslink);

    void edit(Trainingsuserslink trainingsuserslink);

    void remove(Trainingsuserslink trainingsuserslink);

    Trainingsuserslink find(Object id);

    List<Trainingsuserslink> findAll();

    List<Trainingsuserslink> findRange(int[] range);

    int count();
    
}
