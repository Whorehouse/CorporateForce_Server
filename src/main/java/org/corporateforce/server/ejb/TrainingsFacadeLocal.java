/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Trainings;

/**
 *
 * @author Chep
 */
@Local
public interface TrainingsFacadeLocal {

    void create(Trainings trainings);

    void edit(Trainings trainings);

    void remove(Trainings trainings);

    Trainings find(Object id);

    List<Trainings> findAll();

    List<Trainings> findRange(int[] range);

    int count();
    
}
