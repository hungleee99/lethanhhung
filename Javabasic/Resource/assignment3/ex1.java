/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3;

import java.util.Random;

/**
 *
 * @author admin
 */
import java.util.Scanner;

//    Exercise 1: Datatype Casting
public class ex1 {

	// Ở đây Account không có thuộc tính Salary nên không add vào
	public static void main(String[] args) {
		 question23();
	}

	

	// Question 2:
	// Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
	// có số 0 ở đầu cho đủ 5 chữ số)

	// Question 3:
	// Lấy 2 số cuối của số ở Question 2 và in ra.
	// Gợi ý:
	// Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
	// Cách 2: chia lấy dư số đó cho 100
	public static void question23() {
                Random  x =new Random();
                int m = x.nextInt(99999);
		System.out.printf("===Question2======\n");
		System.out.println("Số ngẫu nhiên: " + m);
                if(m<10000 && m>999){
                    String s = "0"+m;
                    System.out.println(s);
                    System.out.println("Hai số cuối: " + s.substring(3));
                }else if(m<1000 && m>99){
                    String s ="00"+m;
                    System.out.println(s);
                    System.out.println("Hai số cuối: " + s.substring(3));
                }else if(m<100 && m>9){
                    String s ="000"+m;
                    System.out.println(s);
                    System.out.println("Hai số cuối: " + s.substring(3));
                }else if(m<10 && m>0){
                    String s ="0000"+m;
                    System.out.println(s);
                    System.out.println("Hai số cuối: " + s.substring(3));
                }else{
                    String s = String.valueOf(m);
                    System.out.println(s);
                    System.out.println("Hai số cuối: " + s.substring(3));
                }
//                System.out.println("======Question3=======");
//		String b = String.valueOf(m);
//		System.out.println("Hai số cuối: " + s.substring(3));
        }

		
            

        
        
	
}

