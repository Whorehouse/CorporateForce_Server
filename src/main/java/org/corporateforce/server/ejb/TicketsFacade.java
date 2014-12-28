/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Tickets;

/**
 *
 * @author Chep
 */
@Stateless
public class TicketsFacade extends AbstractFacade<Tickets> implements TicketsFacadeLocal {

    public TicketsFacade() {
        super(Tickets.class);
    }

    @Override
    public Tickets createTickets(Tickets entity) {
        return this.create(entity);
    }

    @Override
    public void editTickets(Tickets entity) {
        this.edit(entity);
    }

    @Override
    public void deleteTickets(Tickets entity) {
        this.delete(entity);
    }

    @Override
    public Tickets getTickets(int id) {
        return this.get(id);
    }

    @Override
    public List<Tickets> listTickets() {
        return this.list();
    }

    @Override
    public int countTickets() {
        return this.count();
    }  
    
}