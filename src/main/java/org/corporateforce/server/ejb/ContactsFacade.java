/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Contacts;

/**
 *
 * @author Chep
 */
@Stateless
public class ContactsFacade extends AbstractFacade<Contacts> implements ContactsFacadeLocal {

    public ContactsFacade() {
        super(Contacts.class);
    }

    @Override
    public Contacts createContacts(Contacts entity) {
        return this.create(entity);
    }

    @Override
    public void editContacts(Contacts entity) {
        this.edit(entity);
    }

    @Override
    public void deleteContacts(Contacts entity) {
        this.delete(entity);
    }

    @Override
    public Contacts getContacts(int id) {
        return this.get(id);
    }

    @Override
    public List<Contacts> listContacts() {
        return this.list();
    }

    @Override
    public int countContacts() {
        return this.count();
    }  
    
}