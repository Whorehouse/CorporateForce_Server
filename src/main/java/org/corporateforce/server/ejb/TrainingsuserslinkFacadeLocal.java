/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Trainingsuserslink;

@Local
public interface TrainingsuserslinkFacadeLocal {
    Trainingsuserslink createTrainingsuserslink(Trainingsuserslink entity);
    void editTrainingsuserslink(Trainingsuserslink entity);
    void deleteTrainingsuserslink(Trainingsuserslink entity);
    Trainingsuserslink getTrainingsuserslink(int id);
    List<Trainingsuserslink> listTrainingsuserslink();
    int countTrainingsuserslink();    
}
