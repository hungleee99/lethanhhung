/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment4.Inheritance;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class KiSu extends Q1_canbo{
    public String Nganh;

    public KiSu(String Nganh, String name, int age, String address) {
        super(name, age, address);
        this.Nganh = Nganh;
    }

    public KiSu() {
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String Nganh) {
        this.Nganh = Nganh;
    }
    @Override
    public void nhap() {       
               Scanner nhap = new Scanner(System.in);
               System.out.println("nhap nganh : ");     
               Nganh = nhap.nextLine();
               super.nhap();
    }

    @Override
    public void in() {
        System.out.println("Nganh: "+this.Nganh);
        super.in(); 
    }
    
}
