/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Inheritance;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class QLSach {
    public static void main(String[] args) {
        Sach s = new Sach();
        Tapchi t = new Tapchi();
        Bao b = new Bao();
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap ban ghi\n");
        System.out.println("nhap thong tin ve sach\n");
        s.nhap();
        System.out.println("nhap thong tin ve tap chi\n");
        t.nhap();
        System.out.println("nhap thong tin ve bao\n");
        b.nhap();
        
//        b
        System.out.println("nhap ma tai lieu ve sach muon xoa");
        int m1 = nhap.nextInt();
        if(m1 == s.ma){
            s.remove();
        }
        System.out.println("nhap ma tai lieu ve tap chi muon xoa");
        int m2 = nhap.nextInt();
        if(m2 == s.ma){
            t.remove();
        }
        System.out.println("nhap ma tai lieu ve bao muon xoa");
        int m3 = nhap.nextInt();
        if(m3 == s.ma){
            b.remove();
        }
//        c
        s.in();
        t.in();
        b.in();
//        d
        System.out.println("tim kiem tai lieu theo loai");
        String tk = "";
        if(tk.equals("Sach")){
            s.in();
        }
        else if(tk.equals("Tap chi")){
            t.in();
        }
        else if(tk.equals("Bao")){
            b.in();
        }
        System.exit(0);
    }
}
