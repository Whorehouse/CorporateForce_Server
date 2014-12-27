/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Languages;

/**
 *
 * @author Chep
 */
@Local
public interface LanguagesFacadeLocal {

    void create(Languages languages);

    void edit(Languages languages);

    void remove(Languages languages);

    Languages find(Object id);

    List<Languages> findAll();

    List<Languages> findRange(int[] range);

    int count();
    
}
