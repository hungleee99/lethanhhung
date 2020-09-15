/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

/**
 *
 * @author admin
 */
public class Answer {
    int id;
    String content;
    Question question;
    Boolean isCorrect;

    public Answer() {
    }

    public Answer(int id, String content, Question question, Boolean isCorrect) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }
    
}
