/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Tickets;

@Local
public interface TicketsFacadeLocal {
    Tickets createTickets(Tickets entity);
    void editTickets(Tickets entity);
    void deleteTickets(Tickets entity);
    Tickets getTickets(int id);
    List<Tickets> listTickets();
    int countTickets();    
}
