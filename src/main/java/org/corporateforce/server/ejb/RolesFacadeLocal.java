/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Roles;

@Local
public interface RolesFacadeLocal {
    Roles createRoles(Roles entity);
    void editRoles(Roles entity);
    void deleteRoles(Roles entity);
    Roles getRoles(int id);
    List<Roles> listRoles();
    int countRoles();    
}
