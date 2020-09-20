/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5.Inheritance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Q2_QLCB {

    private ArrayList<Q1_canbo> canbos = new ArrayList<Q1_canbo>();

     public  void nhap(){
         Q1_canbo canbo=new Q1_canbo();
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap ten: ");     
        canbo.setName(nhap.nextLine()); 
        System.out.println("nhap tuoi: ");     
        canbo.setAge(nhap.nextInt()); ;
        System.out.println("nhap Gender: "); 
        System.out.println("0 - FEMALE, 1 - MALE , Other -  UNKNOW");
        canbo.setgt(nhap.nextInt());
            
        nhap.nextLine();
        System.out.println("nhap dia chi: ");     
        canbo.setAddress(nhap.nextLine());
        
        canbos.add(canbo);
    }
    public void in(){
        for (Q1_canbo q1_canbo : canbos) {
            System.out.println("\nthong tin can bo\n");
            System.out.println("Ten: "+q1_canbo.getName());
            System.out.println("Tuoi: "+q1_canbo.getAge());
            System.out.println("gioitinh: "+q1_canbo.getGender());
            System.out.println("dia chi: "+q1_canbo.getAddress());
        }     
    }
    
public void tk(){
    Scanner nhap = new Scanner(System.in);
    System.out.println (" \n\t\tnhap ten can tim");
    String s = nhap.nextLine();
    boolean kt = false;
    for (Q1_canbo q1_canbo : canbos) {
        if (q1_canbo.getName().compareTo(s) == 0) {
            kt = true;
            break;
        } else kt = false;
    }
    if(kt == true){
        System.out.println("co nguoi nay\n\n");
    }

    else System.out.println ("khong co nguoi nay\n\n");
}
        

public void remove(){
    Scanner nhap = new Scanner(System.in);
    System.out.println (" nhap ten ban muon xoa");
    String s2 = nhap.nextLine();
    boolean tk = false;
    for (Q1_canbo q1_canbo : canbos) {
        if (s2.toString().equals(q1_canbo.getName())) {
            tk=true;
            canbos.remove(q1_canbo);
            break;
        }else tk = false;
    }
    if(tk == true){
        System.out.println("xoa thanh cong\n");
    }

    else System.out.println ("xoa that bai\n");
}
////        e
//
//    System.exit (
//
//0);
//    
}
