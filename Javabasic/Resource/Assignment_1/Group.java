/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.time.LocalDate;

public class Group {
    int id;
    String name;
    Account[] accounts;
    LocalDate createDate;

    public Group() {
    }

    public Group(int id, String name, Account[] accounts, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
        this.createDate = createDate;
    }
    
}