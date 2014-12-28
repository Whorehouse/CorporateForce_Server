/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Articles;

@Local
public interface ArticlesFacadeLocal {
    Articles createArticles(Articles entity);
    void editArticles(Articles entity);
    void deleteArticles(Articles entity);
    Articles getArticles(int id);
    List<Articles> listArticles();
    int countArticles();    
}
