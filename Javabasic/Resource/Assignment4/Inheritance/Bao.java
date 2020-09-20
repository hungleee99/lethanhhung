/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Inheritance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Bao extends QLTL{
    ArrayList<Bao> b = new ArrayList<Bao>();
    public int ngayph;

    public Bao() {
    }

    
       public void nhap(){
       Scanner nhap = new Scanner(System.in);
       System.out.println("nhap ma: ");
       this.ma = nhap.nextInt();
       nhap.nextLine();
       System.out.println("nhap ten nxb: ");
       this.tennxb = nhap.nextLine();
       System.out.println("nhap ngay ph: ");
       this.ngayph = nhap.nextInt();
       System.out.println("nhap so ban phat hanh: ");
       this.sophathanh = nhap.nextInt();
   }

    public Bao(int ngayph, int ma, String tennxb, int sophathanh) {
        super(ma, tennxb, sophathanh);
        this.ngayph = ngayph;
    }
   public void in(){
       System.out.println("ma: "+this.ma);
       System.out.println("ten nxb: "+this.tennxb);
       System.out.println("so ngay ph: "+this.ngayph);
       System.out.println("so phat hanh: "+this.sophathanh);
   }
   public void remove(){
       b.remove(b);
   }
}
