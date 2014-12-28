/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Objectives;

@Local
public interface ObjectivesFacadeLocal {
    Objectives createObjectives(Objectives entity);
    void editObjectives(Objectives entity);
    void deleteObjectives(Objectives entity);
    Objectives getObjectives(int id);
    List<Objectives> listObjectives();
    int countObjectives();    
}
