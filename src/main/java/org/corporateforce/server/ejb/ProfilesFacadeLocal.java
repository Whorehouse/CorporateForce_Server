/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Profiles;

/**
 *
 * @author Chep
 */
@Local
public interface ProfilesFacadeLocal {

    void create(Profiles profiles);

    void edit(Profiles profiles);

    void remove(Profiles profiles);

    Profiles find(Object id);

    List<Profiles> findAll();

    List<Profiles> findRange(int[] range);

    int count();
    
}
