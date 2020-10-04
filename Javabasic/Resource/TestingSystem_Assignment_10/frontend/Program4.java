/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.frontend;

import TestingSystem_Assignment_10.backend.Ex4;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Program4 {
    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException {
        delete();
    }
    private static void delete() throws SQLException, IOException, FileNotFoundException, ClassNotFoundException{
        Scanner s = new Scanner(System.in);
        System.out.println("nhap id: ");
        int id = s.nextInt();
        new Ex4().deletesql(id);
        System.out.println("success full");
    }
}
