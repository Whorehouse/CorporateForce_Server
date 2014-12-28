/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Articlesresourceslink;

/**
 *
 * @author Chep
 */
@Stateless
public class ArticlesresourceslinkFacade extends AbstractFacade<Articlesresourceslink> implements ArticlesresourceslinkFacadeLocal {

    public ArticlesresourceslinkFacade() {
        super(Articlesresourceslink.class);
    }

    @Override
    public Articlesresourceslink createArticlesresourceslink(Articlesresourceslink entity) {
        return this.create(entity);
    }

    @Override
    public void editArticlesresourceslink(Articlesresourceslink entity) {
        this.edit(entity);
    }

    @Override
    public void deleteArticlesresourceslink(Articlesresourceslink entity) {
        this.delete(entity);
    }

    @Override
    public Articlesresourceslink getArticlesresourceslink(int id) {
        return this.get(id);
    }

    @Override
    public List<Articlesresourceslink> listArticlesresourceslink() {
        return this.list();
    }

    @Override
    public int countArticlesresourceslink() {
        return this.count();
    }  
    
}