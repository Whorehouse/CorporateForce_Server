/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Settings;

/**
 *
 * @author Chep
 */
@Local
public interface SettingsFacadeLocal {

    void create(Settings settings);

    void edit(Settings settings);

    void remove(Settings settings);

    Settings find(Object id);

    List<Settings> findAll();

    List<Settings> findRange(int[] range);

    int count();
    
}
