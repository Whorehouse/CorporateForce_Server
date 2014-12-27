/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Chatterresourceslink;

/**
 *
 * @author Chep
 */
@Local
public interface ChatterresourceslinkFacadeLocal {

    void create(Chatterresourceslink chatterresourceslink);

    void edit(Chatterresourceslink chatterresourceslink);

    void remove(Chatterresourceslink chatterresourceslink);

    Chatterresourceslink find(Object id);

    List<Chatterresourceslink> findAll();

    List<Chatterresourceslink> findRange(int[] range);

    int count();
    
}
