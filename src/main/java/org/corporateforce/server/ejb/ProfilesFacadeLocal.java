/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Profiles;

@Local
public interface ProfilesFacadeLocal {
    Profiles createProfiles(Profiles entity);
    void editProfiles(Profiles entity);
    void deleteProfiles(Profiles entity);
    Profiles getProfiles(int id);
    List<Profiles> listProfiles();
    int countProfiles();    
}
