/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.chuabai.fontend;

import Assignment7.Ex5.chuabai.Student;
import Assignment7.Ex5.chuabai.common.FileUltils;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) throws IOException {
            // nhap
    //viet
    //doc 
    //in
    Student s1 = new Student("1", "hung");
    Student s2 = new Student("2", "toan");
    Student s3 = new Student("3", "tinh");
    Student[] stdlist = {s1,s2,s3};
    String pathFile = "E:\\StudenList.txt";
    FileUltils.writeStudentList(stdlist, pathFile);
    ArrayList<Student> stds = FileUltils.readStudensIntoArray(pathFile);
        for (Student student : stdlist) {
            System.out.println(student.toString());
        }
    }
}
