/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Tutorials;

@Local
public interface TutorialsFacadeLocal {
    Tutorials createTutorials(Tutorials entity);
    void editTutorials(Tutorials entity);
    void deleteTutorials(Tutorials entity);
    Tutorials getTutorials(int id);
    List<Tutorials> listTutorials();
    int countTutorials();    
}
