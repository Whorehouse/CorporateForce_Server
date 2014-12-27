/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Results;

/**
 *
 * @author Chep
 */
@Local
public interface ResultsFacadeLocal {

    void create(Results results);

    void edit(Results results);

    void remove(Results results);

    Results find(Object id);

    List<Results> findAll();

    List<Results> findRange(int[] range);

    int count();
    
}
