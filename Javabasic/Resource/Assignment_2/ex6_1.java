/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class ex6_1 {
    public void sc(){
        for(int i=0;i<10;i++)
            if(i%2==0)
            System.out.println(i);
    }
    public void acc(){
        Account a = new Account();
        // Create account
		Account account1 = new Account();
		account1.id = 1;
		account1.createDate = LocalDate.now();
		account1.email = "An@gmail.com";
		account1.fullname = "Nguyen Van An";
		account1.username = "an.nguyenvan";

		Account account2 = new Account();
		account2.id = 2;
		account2.createDate = LocalDate.now();
		account2.email = "Linh@gmail.com";
		account2.fullname = "Nguyen Hoai Linh";
		account2.username = "Linh.nguyenhoai";

		Account account3 = new Account();
		account3.id = 3;
		account3.createDate = LocalDate.now();
		account3.email = "ha@gmail.com";
		account3.fullname = "Pham Hai Ha";
		account3.username = "Ha.phamhai";
                
                // print account
		System.out.println("\n\t\tAccount 1 information: \n");
		System.out.println("id: " + account1.id);
                System.out.println("Fullname "+ account1.fullname);
                System.out.println("DepartmentId "+ account1.department.departmentID);
		System.out.println("Email: " + account1.email);
		System.out.println("Create Date: " + account1.createDate);
                
                System.out.println("\n\t\tAccount 1 information: \n");
		System.out.println("id: " + account2.id);
                System.out.println("Fullname "+ account2.fullname);
                System.out.println("DepartmentId "+ account2.department.departmentID);
		System.out.println("Email: " + account1.email);
		System.out.println("Create Date: " + account1.createDate);
                
    }
    public void scn(){
        for(int i=0;i<10;i++)
            System.out.println(i);
    }
}
