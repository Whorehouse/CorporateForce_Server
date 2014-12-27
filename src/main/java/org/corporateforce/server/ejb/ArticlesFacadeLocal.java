/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Articles;

/**
 *
 * @author Chep
 */
@Local
public interface ArticlesFacadeLocal {

    void create(Articles articles);

    void edit(Articles articles);

    void remove(Articles articles);

    Articles find(Object id);

    List<Articles> findAll();

    List<Articles> findRange(int[] range);

    int count();
    
}
