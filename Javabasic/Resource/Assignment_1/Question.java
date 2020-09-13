/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.time.LocalDate;

public class Question {
    int id;
    String content;
    CategoryQuestion categoryQuestion;
    TypeQuestion typeQuestion;
    Account account;
    LocalDate createDate;

    public Question() {
    }

    public Question(int id, String content, CategoryQuestion categoryQuestion, TypeQuestion typeQuestion, Account account, LocalDate createDate) {
        this.id = id;
        this.content = content;
        this.categoryQuestion = categoryQuestion;
        this.typeQuestion = typeQuestion;
        this.account = account;
        this.createDate = createDate;
    }
    

}