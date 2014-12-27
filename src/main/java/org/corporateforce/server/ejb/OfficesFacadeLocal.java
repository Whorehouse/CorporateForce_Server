/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Offices;

/**
 *
 * @author Chep
 */
@Local
public interface OfficesFacadeLocal {

    void create(Offices offices);

    void edit(Offices offices);

    void remove(Offices offices);

    Offices find(Object id);

    List<Offices> findAll();

    List<Offices> findRange(int[] range);

    int count();
    
}
