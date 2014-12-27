/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Worklogs;

/**
 *
 * @author Chep
 */
@Local
public interface WorklogsFacadeLocal {

    void create(Worklogs worklogs);

    void edit(Worklogs worklogs);

    void remove(Worklogs worklogs);

    Worklogs find(Object id);

    List<Worklogs> findAll();

    List<Worklogs> findRange(int[] range);

    int count();
    
}
