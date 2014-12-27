/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Tickets;

/**
 *
 * @author Chep
 */
@Local
public interface TicketsFacadeLocal {

    void create(Tickets tickets);

    void edit(Tickets tickets);

    void remove(Tickets tickets);

    Tickets find(Object id);

    List<Tickets> findAll();

    List<Tickets> findRange(int[] range);

    int count();
    
}
