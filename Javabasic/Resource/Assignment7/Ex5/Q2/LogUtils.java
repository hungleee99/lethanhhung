/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.Q2;

import Assignment7.Ex5.Q1.IOStream;
import Assignment7.Ex5.Q1.ScannerUtils;
import java.time.DateTimeException;
import java.util.List;

/**
 *
 * @author admin
 */
public class LogUtils extends MyException{
    List<MyException> my;
    String pathFile = "E:\\Exception.ser";
    public void writeLog(String message, String reason,String StackTrace,DateTimeException time){
        System.out.println("moi nhap message: ");
        message = ScannerUtils.inputName();
        System.out.println("moi nhap reason: ");
        reason = ScannerUtils.inputName();
        System.out.println("moi nhap StackTrace: ");
        StackTrace = ScannerUtils.inputName();
        System.out.println("moi nhap DateTimeException: 1/1/1999 ");

    }
    public void writeLog() throws Exception{
        IOStream.writeObject(my, pathFile);
    }
    public void readLog() throws Exception{
        my = (List<MyException>) IOStream.readObject(pathFile);
    }
    
}
