/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Settings;

@Local
public interface SettingsFacadeLocal {
    Settings createSettings(Settings entity);
    void editSettings(Settings entity);
    void deleteSettings(Settings entity);
    Settings getSettings(int id);
    List<Settings> listSettings();
    int countSettings();    
}
