/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Labels;

/**
 *
 * @author Chep
 */
@Stateless
public class LabelsFacade extends AbstractFacade<Labels> implements LabelsFacadeLocal {

    public LabelsFacade() {
        super(Labels.class);
    }

    @Override
    public Labels createLabels(Labels entity) {
        return this.create(entity);
    }

    @Override
    public void editLabels(Labels entity) {
        this.edit(entity);
    }

    @Override
    public void deleteLabels(Labels entity) {
        this.delete(entity);
    }

    @Override
    public Labels getLabels(int id) {
        return this.get(id);
    }

    @Override
    public List<Labels> listLabels() {
        return this.list();
    }

    @Override
    public int countLabels() {
        return this.count();
    }  
    
}