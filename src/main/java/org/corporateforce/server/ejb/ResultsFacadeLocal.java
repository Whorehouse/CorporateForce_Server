/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Results;

@Local
public interface ResultsFacadeLocal {
    Results createResults(Results entity);
    void editResults(Results entity);
    void deleteResults(Results entity);
    Results getResults(int id);
    List<Results> listResults();
    int countResults();    
}
