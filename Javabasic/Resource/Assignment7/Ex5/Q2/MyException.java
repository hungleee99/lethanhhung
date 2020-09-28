/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.Q2;

import java.time.DateTimeException;

/**
 *
 * @author admin
 */
public class MyException extends  Exception{
    private String message;
    private String reason;
    private String StackTrace;
    private DateTimeException time;

    public MyException() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStackTrace(String StackTrace) {
        this.StackTrace = StackTrace;
    }

    public DateTimeException getTime() {
        return time;
    }

    public void setTime(DateTimeException time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyException{"+ "id=" + message + ", name='" + reason+ ", StackTrace='" + StackTrace + '\'' + '}';
    }
    
}
