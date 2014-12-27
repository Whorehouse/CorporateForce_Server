/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Chatter;

/**
 *
 * @author Chep
 */
@Local
public interface ChatterFacadeLocal {

    void create(Chatter chatter);

    void edit(Chatter chatter);

    void remove(Chatter chatter);

    Chatter find(Object id);

    List<Chatter> findAll();

    List<Chatter> findRange(int[] range);

    int count();
    
}
