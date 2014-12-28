/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Holidays;

/**
 *
 * @author Chep
 */
@Stateless
public class HolidaysFacade extends AbstractFacade<Holidays> implements HolidaysFacadeLocal {

    public HolidaysFacade() {
        super(Holidays.class);
    }

    @Override
    public Holidays createHolidays(Holidays entity) {
        return this.create(entity);
    }

    @Override
    public void editHolidays(Holidays entity) {
        this.edit(entity);
    }

    @Override
    public void deleteHolidays(Holidays entity) {
        this.delete(entity);
    }

    @Override
    public Holidays getHolidays(int id) {
        return this.get(id);
    }

    @Override
    public List<Holidays> listHolidays() {
        return this.list();
    }

    @Override
    public int countHolidays() {
        return this.count();
    }  
    
}