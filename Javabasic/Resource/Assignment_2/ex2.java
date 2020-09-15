/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.util.Date;

/**
 *
 * @author admin
 */
public class ex2 {
    public static void main(String[] args) {
        System.out.printf("%d\n",5);
        System.out.printf("%d\n",Long.valueOf(10000000));
        System.out.printf("%.4f",5.567098);
        String name = "Nguyễn Văn A";
        System.out.println("Tôi tên là "+name+ " Và tôi đọc thân");
        Date date = new Date();
        System.out.printf("%tT %1$td.%1$tm.%1$ty %n", date);
    }
}
