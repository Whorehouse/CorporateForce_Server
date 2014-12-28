/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Projects;

/**
 *
 * @author Chep
 */
@Stateless
public class ProjectsFacade extends AbstractFacade<Projects> implements ProjectsFacadeLocal {

    public ProjectsFacade() {
        super(Projects.class);
    }

    @Override
    public Projects createProjects(Projects entity) {
        return this.create(entity);
    }

    @Override
    public void editProjects(Projects entity) {
        this.edit(entity);
    }

    @Override
    public void deleteProjects(Projects entity) {
        this.delete(entity);
    }

    @Override
    public Projects getProjects(int id) {
        return this.get(id);
    }

    @Override
    public List<Projects> listProjects() {
        return this.list();
    }

    @Override
    public int countProjects() {
        return this.count();
    }  
    
}