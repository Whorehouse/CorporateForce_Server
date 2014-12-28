/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Questions;

@Local
public interface QuestionsFacadeLocal {
    Questions createQuestions(Questions entity);
    void editQuestions(Questions entity);
    void deleteQuestions(Questions entity);
    Questions getQuestions(int id);
    List<Questions> listQuestions();
    int countQuestions();    
}
