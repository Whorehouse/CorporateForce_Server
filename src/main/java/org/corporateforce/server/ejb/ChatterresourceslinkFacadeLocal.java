/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Chatterresourceslink;

@Local
public interface ChatterresourceslinkFacadeLocal {
    Chatterresourceslink createChatterresourceslink(Chatterresourceslink entity);
    void editChatterresourceslink(Chatterresourceslink entity);
    void deleteChatterresourceslink(Chatterresourceslink entity);
    Chatterresourceslink getChatterresourceslink(int id);
    List<Chatterresourceslink> listChatterresourceslink();
    int countChatterresourceslink();    
}
