/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Articlesresourceslink;

@Local
public interface ArticlesresourceslinkFacadeLocal {
    Articlesresourceslink createArticlesresourceslink(Articlesresourceslink entity);
    void editArticlesresourceslink(Articlesresourceslink entity);
    void deleteArticlesresourceslink(Articlesresourceslink entity);
    Articlesresourceslink getArticlesresourceslink(int id);
    List<Articlesresourceslink> listArticlesresourceslink();
    int countArticlesresourceslink();    
}
