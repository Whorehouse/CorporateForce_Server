/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Trainings;

@Local
public interface TrainingsFacadeLocal {
    Trainings createTrainings(Trainings entity);
    void editTrainings(Trainings entity);
    void deleteTrainings(Trainings entity);
    Trainings getTrainings(int id);
    List<Trainings> listTrainings();
    int countTrainings();    
}
