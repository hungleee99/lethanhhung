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
public class CongNhan extends Q1_canbo{
    public int lever;

    public CongNhan(int bac, String name, int age, String address) {
        super(name, age, address);
        this.lever = bac;
    }

    public CongNhan() {
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    @Override
    public void nhap() {       
               Scanner nhap = new Scanner(System.in);
               System.out.println("nhap lever : ");     
               lever = nhap.nextInt();
               super.nhap();
    }

    @Override
    public void in() {
        System.out.println("Lever: "+this.lever);
        super.in();
    }

    
    
}
