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
public class Tapchi extends QLTL{
    ArrayList<Tapchi> b = new ArrayList<Tapchi>();
    public int Sophathanh;
    public int thangphathanh;


    public Tapchi() {
    }

    public Tapchi(int Sophathanh, int thangphathanh, int ma, String tennxb, int sophathanh) {
        super(ma, tennxb, sophathanh);
        this.Sophathanh = Sophathanh;
        this.thangphathanh = thangphathanh;
    }

    

       public void nhap(){
       Scanner nhap = new Scanner(System.in);
       System.out.println("nhap ma: ");
       this.ma = nhap.nextInt();
       nhap.nextLine();
       System.out.println("nhap ten nxb: ");
       this.tennxb = nhap.nextLine();
       System.out.println("nhap so phat hanh: ");
       this.Sophathanh = nhap.nextInt();
       System.out.println("nhap thang phathanh: ");
       this.thangphathanh = nhap.nextInt();
       System.out.println("nhap so ban phat hanh: ");
       this.sophathanh = nhap.nextInt();
   }
   public void in(){
       System.out.println("ma: "+this.ma);
       System.out.println("ten nxb: "+this.tennxb);
       System.out.println("so phat hanh: "+this.Sophathanh);
       System.out.println("thang phat hanh: "+this.thangphathanh);
       System.out.println("so ban phat hanh: "+this.sophathanh);
   }
   public void remove(){
       b.remove(b);
   }
}
