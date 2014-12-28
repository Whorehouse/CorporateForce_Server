/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Languages;

@Local
public interface LanguagesFacadeLocal {
    Languages createLanguages(Languages entity);
    void editLanguages(Languages entity);
    void deleteLanguages(Languages entity);
    Languages getLanguages(int id);
    List<Languages> listLanguages();
    int countLanguages();    
}
