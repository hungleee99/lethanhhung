/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.chuabai.common;

import Assignment7.Ex5.chuabai.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class FileUltils {
    private static Writer txtWrite = null;
    private static Reader txtRead = null;
    private static BufferedReader buf = null;
    
    private static int c = 0;
    public static void writeStudent(Student std,int i,String pathFile) throws IOException{
        txtWrite = new FileWriter(new File(pathFile),true);
        txtWrite.write("Student  "+i+":"+std.toString()+"\n");
        txtWrite.close();
    }
    public static void writeStudentList(Student[] stds,String pathFile) throws IOException{
        for (int i=0;i<stds.length;i++) {
            writeStudent(stds[i],i+1, pathFile);
        }
    }
    public static void readStudent(Student std,String pathFile) throws IOException{
        txtRead = new FileReader(new File(pathFile));
        while((c = txtRead.read())!= -1){
            System.out.println("");
        }
        txtRead.close();
    }
    public static  ArrayList<Student> readStudensIntoArray(String pathFile) throws FileNotFoundException, IOException{
        ArrayList<Student> stdList = new ArrayList<Student>();
        txtRead = new FileReader(new File(pathFile));
        buf = new BufferedReader(txtRead);
        String line = null;
        while((line= buf.readLine())!= null){
            Student currentStudent = convertStringToStudent(line);
            stdList.add(currentStudent);
        }
 
        return stdList;
    }

    private static Student convertStringToStudent(String line) {
        String id =null;
        String name =null;
        // phân tích cú pháp text đây là lấy đc id và name
//        Substring(beginindex,endindex) vd "hieu".substring(1,4) ->  'ieu'
        // biginindex của id là sau dấu :1 ký tự
        int beginIndexOfID = line.indexOf(":")+1;
        int endIndexOfID = line.indexOf("-");
        int beginIndexOfName = endIndexOfID+1;
        id = line.substring(beginIndexOfID,endIndexOfID);
        name = line.substring(beginIndexOfName);
        return new Student(id,name);
        
    }
    
    
}
