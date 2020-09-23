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
public class NhanVien extends Q1_canbo{
    public  String congviec;

    public NhanVien() {
    }

    public NhanVien(String congviec, String name, int age, String address) {
        super(name, age, address);
        this.congviec = congviec;
    }

    public String getCongviec() {
        return congviec;
    }

    public void setCongviec(String congviec) {
        this.congviec = congviec;
    }
    @Override
    public void nhap() {       
               Scanner nhap = new Scanner(System.in);
               System.out.println("nhap cong viec : ");     
               congviec = nhap.nextLine();
               super.nhap();
    }

    @Override
    public void in() {
        System.out.println("cong viec: "+this.congviec);
        super.in();
    }
    
}
