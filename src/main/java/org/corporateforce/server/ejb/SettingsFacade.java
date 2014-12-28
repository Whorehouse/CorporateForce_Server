/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Settings;

/**
 *
 * @author Chep
 */
@Stateless
public class SettingsFacade extends AbstractFacade<Settings> implements SettingsFacadeLocal {

    public SettingsFacade() {
        super(Settings.class);
    }

    @Override
    public Settings createSettings(Settings entity) {
        return this.create(entity);
    }

    @Override
    public void editSettings(Settings entity) {
        this.edit(entity);
    }

    @Override
    public void deleteSettings(Settings entity) {
        this.delete(entity);
    }

    @Override
    public Settings getSettings(int id) {
        return this.get(id);
    }

    @Override
    public List<Settings> listSettings() {
        return this.list();
    }

    @Override
    public int countSettings() {
        return this.count();
    }  
    
}