/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3;

import assignment3.ex2_as3;
import java.time.LocalDate;

public class ex2_as3_1 {
    public static void main(String[] args) {
        
        ex2_as3[] accounts = new ex2_as3[5];

		// insert account
		for (int i = 0; i < 5; i++) {
			ex2_as3 account = new ex2_as3();
			account.Email = "Email " + (i + 1);
			account.Username = "Username " + (i + 1);
			account.Fullname = "Full name " + (i + 1);
			account.Createdate = LocalDate.now();

			accounts[i] = account;
		}

		// print accounts
		for (ex2_as3 account : accounts) {
			System.out.println(account.Email);
			System.out.println(account.Username);
			System.out.println(account.Fullname);
			System.out.println(account.Createdate);
			System.out.println("\n");
		}

    }
}
