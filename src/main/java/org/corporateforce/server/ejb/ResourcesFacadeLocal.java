/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Resources;

@Local
public interface ResourcesFacadeLocal {
    Resources createResources(Resources entity);
    void editResources(Resources entity);
    void deleteResources(Resources entity);
    Resources getResources(int id);
    List<Resources> listResources();
    int countResources();    
}
