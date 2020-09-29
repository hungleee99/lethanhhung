/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.Q2;

import Assignment7.Ex5.Q1.ScannerUtils;
import java.io.Serializable;
import java.time.DateTimeException;

/**
 *
 * @author admin
 */
public class MyException extends  Exception implements Serializable{
    private static final long serialVersionUID = 1L;
    private String message;
    private String reason;

    public void StackTraceElement() {
        new Exception("StackTrace").printStackTrace();
    }
    public void runtimeExceptin(){
        try {
            input();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public MyException() {
        input();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    private void input(){
        System.out.println("moi nhap message: ");
        message = ScannerUtils.inputName();
        System.out.println("moi nhap reason: ");
        reason = ScannerUtils.inputName();
//        StackTraceElement();
//        runtimeExceptin();
    }
    public void in(){
        System.out.println(" message: "+message);
        System.out.println(" reason: "+reason);
    }

    @Override
    public String toString() {
        return "MyException{"+ "id=" + message + ", name='" + reason+ '}';
    }
    
}
