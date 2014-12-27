/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Holidays;

/**
 *
 * @author Chep
 */
@Local
public interface HolidaysFacadeLocal {

    void create(Holidays holidays);

    void edit(Holidays holidays);

    void remove(Holidays holidays);

    Holidays find(Object id);

    List<Holidays> findAll();

    List<Holidays> findRange(int[] range);

    int count();
    
}
