/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Tutorials;

/**
 *
 * @author Chep
 */
@Local
public interface TutorialsFacadeLocal {

    void create(Tutorials tutorials);

    void edit(Tutorials tutorials);

    void remove(Tutorials tutorials);

    Tutorials find(Object id);

    List<Tutorials> findAll();

    List<Tutorials> findRange(int[] range);

    int count();
    
}
