/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Languages;

/**
 *
 * @author Chep
 */
@Stateless
public class LanguagesFacade extends AbstractFacade<Languages> implements LanguagesFacadeLocal {

    public LanguagesFacade() {
        super(Languages.class);
    }

    @Override
    public Languages createLanguages(Languages entity) {
        return this.create(entity);
    }

    @Override
    public void editLanguages(Languages entity) {
        this.edit(entity);
    }

    @Override
    public void deleteLanguages(Languages entity) {
        this.delete(entity);
    }

    @Override
    public Languages getLanguages(int id) {
        return this.get(id);
    }

    @Override
    public List<Languages> listLanguages() {
        return this.list();
    }

    @Override
    public int countLanguages() {
        return this.count();
    }  
    
}