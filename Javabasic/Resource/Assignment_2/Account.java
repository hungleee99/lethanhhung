/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.time.LocalDate;

public class Account {
	int id;
	String email;
	String username;
	String fullname;
	Department department;
	Position position;
	LocalDate createDate;
	Group[] groups;

    public Account() {
    }

    public Account(int id, String email, String username, String fullname, Department department, Position position, LocalDate createDate, Group[] groups) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
        this.groups = groups;
    }

    
      
    

}

