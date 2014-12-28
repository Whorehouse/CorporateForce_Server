/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Labels;

@Local
public interface LabelsFacadeLocal {
    Labels createLabels(Labels entity);
    void editLabels(Labels entity);
    void deleteLabels(Labels entity);
    Labels getLabels(int id);
    List<Labels> listLabels();
    int countLabels();    
}
