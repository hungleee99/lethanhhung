/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.frontend;

import TestingSystem_Assignment_10.backend.Ex2;
import TestingSystem_Assignment_10.entity.Department;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Program2 {
    public static void main(String[] args) throws ClassNotFoundException, IOException, FileNotFoundException, SQLException, Exception {
        System.out.println("in ds");
        q1();
        System.out.println("\n\tlay ra id nhap vao\n");
        q23();
        System.out.println("\n\tkiem tra ten theo boolean\n");
        q4();
        System.out.println("\n\tCreateDepartment is not exists\n");
        q5();
        System.out.println("\n\tupdate Department theo id nhap vao , va ten muon update\n");
        q6();
        System.out.println("\n\tdelete department theo id\n");
        q7();
    }
   private static  void q1() throws ClassNotFoundException, IOException, FileNotFoundException, SQLException{
       List<Department> departments = new Ex2().getDepartment();
       for (Department department : departments) {
           System.out.println(department);
       }
   }
   private static void q23() throws ClassNotFoundException, SQLException, Exception{
       Scanner s = new Scanner(System.in);
       System.out.println("nhap id: ");
       int id = s.nextInt();
       Department d = new Ex2().searching(id);
       System.out.println(d);

   }
   private static  void q4() throws ClassNotFoundException, SQLException, Exception{
       Scanner s = new Scanner(System.in);
       System.out.println("nhap name: ");
       String name = s.nextLine();
       boolean rs = new Ex2().isDepartmentNameExists(name);
       System.out.println("result:"+rs);
   }
   private static  void q5() throws ClassNotFoundException, SQLException, Exception{
       Scanner s = new Scanner(System.in);
       System.out.println("nhap name: ");
       String name = s.nextLine();
       new Ex2().createDepartment(name);
       System.out.println("succes full");
   }
   private static  void q6() throws ClassNotFoundException, SQLException, Exception{
       Scanner s = new Scanner(System.in);
       System.out.println("nhap id: ");
       int id = s.nextInt();
       s.nextLine();
       System.out.println("nhap name: ");
       String name = s.nextLine();
       new Ex2().updateDepartmentName(id, name);
       System.out.println("succes full");
   }
   private static  void q7() throws ClassNotFoundException, SQLException, Exception{
       Scanner s = new Scanner(System.in);
       System.out.println("nhap id: ");
       int id = s.nextInt();     
       new Ex2().deleteDepartment(id);
       System.out.println("succes full");
   }
}
