/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.chuabai;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner s = new Scanner(System.in);
        File file = new File("E:\\StudentInformation.txt");
        try {
            FileWriter fws = new FileWriter(file);
            for(int i=0;i<3;i++){
                student.nhap();
                fws.write("id"+ student.getId()+"\n");
                fws.write("name"+ student.getName()+"\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for(int i=0;i<3;i++){
            student.in();
        }
        

    }
}
