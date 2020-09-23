/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4.Inheritance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Q2_QLCB {

    private ArrayList<Q1_canbo> canbos = new ArrayList<Q1_canbo>();

     public  void nhap(){
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap thong tin \n"); 
        System.out.println("\n\t\tnhap\n 1-cong nhan \n 2-nhanvien\n 3-kysu \n"); 
        int h = nhap.nextInt();
        if(h==1){
            Q1_canbo q1_canbo = new CongNhan();
            q1_canbo.nhap();
            canbos.add(q1_canbo);
        }else if(h==2){
            Q1_canbo q1_canbo = new NhanVien();
            q1_canbo.nhap();
            canbos.add(q1_canbo);
        }else if(h==3){
            Q1_canbo q1_canbo = new KiSu();
            q1_canbo.nhap();
            canbos.add(q1_canbo);
        }

               
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
    public void showkysu(){
        for (Q1_canbo q1_canbo : canbos) {
            if(q1_canbo instanceof KiSu){
                Q1_canbo ks = new KiSu();
                ks.in();
            }
        }
    }
}
