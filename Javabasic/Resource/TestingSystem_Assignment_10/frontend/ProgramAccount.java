/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.frontend;

import TestingSystem_Assignment_10.backend.ActionAccount;
import TestingSystem_Assignment_10.entity.Account;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ProgramAccount {
    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException, Exception {
        q1();
//        q23();
//        q4();
//        q5();
    }
    private static void q1() throws SQLException, IOException, FileNotFoundException, ClassNotFoundException{
        List<Account> accounts = new ActionAccount().getAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    private static void q23() throws SQLException, IOException, FileNotFoundException, ClassNotFoundException, Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id: ");
        int id = scanner.nextInt();
        Account a = new ActionAccount().search(id);
        System.out.println(a);
    }
    private static void q4() throws SQLException, IOException, FileNotFoundException, ClassNotFoundException, Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap username: ");
        String name = scanner.nextLine();
        boolean a = new ActionAccount().searchName(name);
        System.out.println(a);
    }
    private static void q5() throws SQLException, IOException, FileNotFoundException, ClassNotFoundException, Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap Email: ");
        String name1 = scanner.nextLine();
        System.out.println("nhap username: ");
        String name = scanner.nextLine();
        new ActionAccount().crename(name1,name);
        System.out.println("oki");
    }
}
