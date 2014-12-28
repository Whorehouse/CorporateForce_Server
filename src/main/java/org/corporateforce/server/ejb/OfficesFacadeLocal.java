/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Offices;

@Local
public interface OfficesFacadeLocal {
    Offices createOffices(Offices entity);
    void editOffices(Offices entity);
    void deleteOffices(Offices entity);
    Offices getOffices(int id);
    List<Offices> listOffices();
    int countOffices();    
}
