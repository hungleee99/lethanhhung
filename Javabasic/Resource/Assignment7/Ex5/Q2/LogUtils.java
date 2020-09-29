/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.Q2;

import Assignment7.Ex5.Q1.IOStream;
import Assignment7.Ex5.Q1.ScannerUtils;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LogUtils {
    private List<MyException> my;
    private String pathFile ;

    public LogUtils() {
        my = new ArrayList<>();
        pathFile = "Exception.ser";
    }
    
    public void writeLog(){
        System.out.println("Input number Exception ");
		int n = ScannerUtils.inputInt();

		for (int i = 0; i < n; i++) {
			my.add(new MyException());
		}

    }

    public void writeLog(MyException exception){
        exception.StackTraceElement();
        exception.runtimeExceptin();
        my.add(exception);
    }
    public void main() throws Exception {
		IOStream.writeObject(my, pathFile);
	}
    public void readLog() throws Exception{
        my = (List<MyException>) IOStream.readObject(pathFile);
    }
    
    @Override
    public String toString() {
        return super.toString(); 
    }
    
}
