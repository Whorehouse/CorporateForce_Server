/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Chatter;

@Local
public interface ChatterFacadeLocal {
    Chatter createChatter(Chatter entity);
    void editChatter(Chatter entity);
    void deleteChatter(Chatter entity);
    Chatter getChatter(int id);
    List<Chatter> listChatter();
    int countChatter();    
}
