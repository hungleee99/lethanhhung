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
import java.time.LocalDate;

public class Exam {
    int id;
    String code;
    String title;
    CategoryQuestion[] categoryQuestion;
    int duration;
    Account account;
    LocalDate createDate;
    Question[] questions;

    public Exam() {
    }

    public Exam(int id, String code, String title, CategoryQuestion[] categoryQuestion, int duration, Account account, LocalDate createDate, Question[] questions) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.categoryQuestion = categoryQuestion;
        this.duration = duration;
        this.account = account;
        this.createDate = createDate;
        this.questions = questions;
    }
    
}
