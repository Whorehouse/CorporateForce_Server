/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Articles;

/**
 *
 * @author Chep
 */
@Stateless
public class ArticlesFacade extends AbstractFacade<Articles> implements ArticlesFacadeLocal {

    public ArticlesFacade() {
        super(Articles.class);
    }

    @Override
    public Articles createArticles(Articles entity) {
        return this.create(entity);
    }

    @Override
    public void editArticles(Articles entity) {
        this.edit(entity);
    }

    @Override
    public void deleteArticles(Articles entity) {
        this.delete(entity);
    }

    @Override
    public Articles getArticles(int id) {
        return this.get(id);
    }

    @Override
    public List<Articles> listArticles() {
        return this.list();
    }

    @Override
    public int countArticles() {
        return this.count();
    }  
    
}