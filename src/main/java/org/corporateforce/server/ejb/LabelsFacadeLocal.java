/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Labels;

/**
 *
 * @author Chep
 */
@Local
public interface LabelsFacadeLocal {

    void create(Labels labels);

    void edit(Labels labels);

    void remove(Labels labels);

    Labels find(Object id);

    List<Labels> findAll();

    List<Labels> findRange(int[] range);

    int count();
    
}
