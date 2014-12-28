/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Projects;

@Local
public interface ProjectsFacadeLocal {
    Projects createProjects(Projects entity);
    void editProjects(Projects entity);
    void deleteProjects(Projects entity);
    Projects getProjects(int id);
    List<Projects> listProjects();
    int countProjects();    
}
