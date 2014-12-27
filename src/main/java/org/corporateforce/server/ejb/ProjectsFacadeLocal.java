/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Projects;

/**
 *
 * @author Chep
 */
@Local
public interface ProjectsFacadeLocal {

    void create(Projects projects);

    void edit(Projects projects);

    void remove(Projects projects);

    Projects find(Object id);

    List<Projects> findAll();

    List<Projects> findRange(int[] range);

    int count();
    
}
