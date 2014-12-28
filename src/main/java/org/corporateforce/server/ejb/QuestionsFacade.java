/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Questions;

/**
 *
 * @author Chep
 */
@Stateless
public class QuestionsFacade extends AbstractFacade<Questions> implements QuestionsFacadeLocal {

    public QuestionsFacade() {
        super(Questions.class);
    }

    @Override
    public Questions createQuestions(Questions entity) {
        return this.create(entity);
    }

    @Override
    public void editQuestions(Questions entity) {
        this.edit(entity);
    }

    @Override
    public void deleteQuestions(Questions entity) {
        this.delete(entity);
    }

    @Override
    public Questions getQuestions(int id) {
        return this.get(id);
    }

    @Override
    public List<Questions> listQuestions() {
        return this.list();
    }

    @Override
    public int countQuestions() {
        return this.count();
    }  
    
}