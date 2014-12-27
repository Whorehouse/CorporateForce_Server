/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Objectives;

/**
 *
 * @author Chep
 */
@Local
public interface ObjectivesFacadeLocal {

    void create(Objectives objectives);

    void edit(Objectives objectives);

    void remove(Objectives objectives);

    Objectives find(Object id);

    List<Objectives> findAll();

    List<Objectives> findRange(int[] range);

    int count();
    
}
