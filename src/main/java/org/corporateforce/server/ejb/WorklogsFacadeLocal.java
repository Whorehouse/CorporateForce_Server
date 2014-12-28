/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Worklogs;

@Local
public interface WorklogsFacadeLocal {
    Worklogs createWorklogs(Worklogs entity);
    void editWorklogs(Worklogs entity);
    void deleteWorklogs(Worklogs entity);
    Worklogs getWorklogs(int id);
    List<Worklogs> listWorklogs();
    int countWorklogs();    
}
