/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Resources;

/**
 *
 * @author Chep
 */
@Local
public interface ResourcesFacadeLocal {

    void create(Resources resources);

    void edit(Resources resources);

    void remove(Resources resources);

    Resources find(Object id);

    List<Resources> findAll();

    List<Resources> findRange(int[] range);

    int count();
    
}
