/*
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
public class Sach extends QLTL{
    ArrayList<Sach> b = new ArrayList<Sach>();
   public  String tentg;
   public int sotrang;

    public Sach() {
    }

    public Sach(String tentg, int sotrang, int ma, String tennxb, int sophathanh) {
        super(ma, tennxb, sophathanh);
        this.tentg = tentg;
        this.sotrang = sotrang;
    }

    
   public void nhap(){
       Scanner nhap = new Scanner(System.in);
       System.out.println("nhap ma: ");
       this.ma = nhap.nextInt();
       System.out.println("nhap ten nxb: ");
       nhap.nextLine();
       this.tennxb = nhap.nextLine();
       System.out.println("nhap so trang: ");
       this.sotrang = nhap.nextInt();
       nhap.nextLine();
       System.out.println("nhap ten tg: ");
       this.tentg = nhap.nextLine();
       System.out.println("nhap so ban phat hanh: ");
       this.sophathanh = nhap.nextInt();
   }
   public void in(){
       System.out.println("ma: "+this.ma);
       System.out.println("ten nxb: "+this.tennxb);
       System.out.println("so trang: "+this.sotrang);
       System.out.println("ten tg: "+this.tentg);
       System.out.println("so phat hanh: "+this.sophathanh);
   }
   public void remove(){
       b.remove(b);
   }
}
