/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Articlesresourceslink;

/**
 *
 * @author Chep
 */
@Local
public interface ArticlesresourceslinkFacadeLocal {

    void create(Articlesresourceslink articlesresourceslink);

    void edit(Articlesresourceslink articlesresourceslink);

    void remove(Articlesresourceslink articlesresourceslink);

    Articlesresourceslink find(Object id);

    List<Articlesresourceslink> findAll();

    List<Articlesresourceslink> findRange(int[] range);

    int count();
    
}
